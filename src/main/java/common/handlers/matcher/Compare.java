package common.handlers.matcher;


import com.fasterxml.jackson.databind.ObjectMapper;
import common.models.Primitive;
import org.hamcrest.Description;
import org.hamcrest.StringDescription;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static common.handlers.Common.findObjectInListByKey;
import static common.handlers.Validation.*;
import static common.handlers.matcher.CombinableMatcher.all;
import static common.handlers.matcher.Verifier.verify;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.is;

public class Compare {
    private static final ObjectMapper mapper = new ObjectMapper();

    private Compare() {
        throw new IllegalStateException("Utility class");
    }

    public static <T> void twoObjectTheSame(Object actual, Object expect, String keyList, String fieldName, String... ignoreField) {
        Description mismatchDescriber = new StringDescription();

        if (actual == null || expect == null) {
            throw new AssertionError("Actual is " + actual + " but expect is " + expect);
        } else {
            boolean result = matchesSafelyObject(actual, expect, mismatchDescriber, fieldName, keyList, ignoreField);
            if (!result) {
                throw new AssertionError(mismatchDescriber.toString());
            }
        }
    }

    private static boolean matchesSafelyObject(Object actualObject, Object expectedObject, Description mismatchDescriber, String tcName, Object keyList, String... ignoreField) {
        boolean result = true;
        if (!isTheSameClass(actualObject, expectedObject)) {
            mismatchDescriber.appendText("Error: Actual Object va expect Object khac kieu\n");
            result = false;
        } else {
            Description mismatch = new StringDescription();

            if (isArrayList(actualObject)) {
                if (!matchesSafelyArrayList((List<Object>) actualObject, (List<Object>) expectedObject, mismatch, keyList, ignoreField)) {
                    result = false;
                    mismatchDescriber.appendText(mismatch.toString());
                }
            } else {
                if (!matchesSafelyObjectTheSameClass(actualObject, expectedObject, mismatch, keyList, tcName, ignoreField)) {
                    mismatchDescriber.appendText("\n====== Mismatch result: " + tcName + " ======");
                    mismatchDescriber.appendText(mismatch.toString());
                    result = false;
                }
            }
        }
        return result;
    }

    static boolean matchesSafelyObjectTheSameClass(Object actualObject, Object expectedObject, Description mismatchDescriber, Object keyList, String fieldName, String... ignoreField) {
        boolean result = true;
        CombinableMatcher matcher = null;
        Class clazz = expectedObject.getClass();
        boolean theFirstFlag = true;
        List<String> listIgnore = convertListIgnore(ignoreField);
        try {
            if (isPrimitiveType(clazz)) {
                Primitive actual = new Primitive(actualObject);
                Primitive expect = new Primitive(expectedObject);
                Field field1 = expect.getClass().getDeclaredFields()[0];

                matcher = all(hasProperty(field1.getName(), is(field1.get(expect))));
                if (!matchesSafely(matcher, actual, mismatchDescriber)) {
                    result = false;
                }
            } else {
                List<Field> fields = new ArrayList<>();
                fields = getAllFields(fields, clazz);
                for (Field field : fields) {
                    if (listIgnore.contains(field.getName())) {
                        continue;
                    }

                    field.setAccessible(true);
                    Object expected = field.get(expectedObject);
                    if (expected != null && !isPrimitiveType(expected.getClass())) {
                        if (!matchesSafelyObjectNotPrimitiveType(field, actualObject, expectedObject, mismatchDescriber, keyList, ignoreField)) {
                            result = false;
                        }
                    } else {
                        if (theFirstFlag) {
                            matcher = all(hasProperty(field.getName(), is(field.get(expectedObject))));
                            theFirstFlag = false;
                        } else {
                            matcher.and(hasProperty(field.getName(), is(field.get(expectedObject))));
                        }
                    }
                }
                if (!matchesSafely(matcher, actualObject, mismatchDescriber)) {
                    result = false;
                }
            }
        } catch (Exception e) {
            result = false;
        }
        return result;
    }

    static List<String> convertListIgnore(String... list) {
        List<String> listIgnore = new ArrayList<>();
        listIgnore.addAll(Arrays.asList(list));
        return listIgnore;
    }

    static boolean matchesSafely(CombinableMatcher matcher, Object actualObject, Description mismatchDescriber) {
        if (matcher != null) {
            return verify(actualObject, matcher, mismatchDescriber);
        } else {
            mismatchDescriber.appendText("Expected object is null, check it please!");
            return false;
        }
    }

    static boolean matchesSafelyObjectNotPrimitiveType(Field field, Object actualObject, Object expectedObject, Description mismatchDescriber, Object keyList, String... ignoreField) {
        Description mismatch = new StringDescription();
        boolean result = true;
        try {
            if (isArrayList(field.get(expectedObject))) {
                List<Object> listExpected = (List<Object>) field.get(expectedObject);
                List<Object> listActual = (List<Object>) field.get(actualObject);
                if (!matchesSafelyArrayList(listActual, listExpected, mismatch, keyList, ignoreField)) {
                    result = false;
                    mismatchDescriber.appendText(mismatch.toString());
                }
            } else {
                Object actual = field.get(actualObject) != null ? field.get(actualObject) : field.get(expectedObject).getClass().newInstance();
                if (!matchesSafelyObject(actual, field.get(expectedObject), mismatch, field.getName(), keyList, ignoreField)) {
                    result = false;
                    mismatchDescriber.appendText(mismatch.toString());
                }
            }
        } catch (Exception ex) {
            result = false;
            mismatchDescriber.appendText("\nMatcher Object Not Primitive is Exception with message: " + ex.getMessage());
        }

        return result;
    }

    public static boolean matchesSafelyArrayList(List<Object> listActual, List<Object> listExpected, Description mismatchDescriber, Object keyList, String... ignoreField) {
        Description mismatch = new StringDescription();
        if (!listActual.isEmpty() || !listExpected.isEmpty()) {
            Object classDto = !listExpected.isEmpty() ? listExpected.get(0) : listActual.get(0);
            if (!matchesSafelyTwoList(listActual, listExpected, keyList, mismatch, classDto.getClass(), ignoreField)) {
                mismatchDescriber.appendText(mismatch.toString());
                return false;
            }
        }
        return true;
    }

    public static boolean matchesSafelyTwoList(List<Object> actualObject, List<Object> expectedObject, Object key, Description mismatchDescriber, Class<?> clazz, String... ignoreField) {
        boolean result = true;

        Description mismatchExpected = new StringDescription();
        if (!matchesSafelyObjectDetailOfList(actualObject, expectedObject, key, mismatchExpected, clazz, ignoreField)) {
            mismatchDescriber.appendText("\n\n==========EXPECTED============");
            mismatchDescriber.appendText(mismatchExpected.toString());
            result = false;
        }

        Description mismatchActual = new StringDescription();
        if (!matchesSafelyObjectDetailOfList(expectedObject, actualObject, key, mismatchActual, clazz, ignoreField)) {
            mismatchDescriber.appendText("\n\n==========ACTUAL============");
            mismatchDescriber.appendText(mismatchActual.toString());
            result = false;
        }
        return result;
    }

    public static boolean matchesSafelyObjectDetailOfList(List<Object> listOne, List<Object> listTwo, Object key, Description mismatchDescriber, Class<?> clazz, String... ignoreField) {
        boolean result = true;

        for (Object twoObject : listTwo) {
            Map mapRefer = mapper.convertValue(twoObject, Map.class);
            Object oneObject = findObjectInListByKey(twoObject, listOne, key, clazz);

            Description mismatchDetail = new StringDescription();
            String tcName = key + "_" + (mapRefer.get(key) == null ? "null" : mapRefer.get(key).toString());
            if (!matchesSafelyObject(oneObject, twoObject, mismatchDetail, tcName, key, ignoreField)) {
                mismatchDescriber.appendText(mismatchDetail.toString());
                result = false;
            }
        }

        return result;
    }

    private static List<Field> getAllFields(List<Field> fields, Class<?> type) {
        fields.addAll(Arrays.asList(type.getDeclaredFields()));

        if (type.getSuperclass() != null) {
            getAllFields(fields, type.getSuperclass());
        }

        return fields;
    }
}
