package common.handlers.matcher;

import com.fasterxml.jackson.databind.ObjectMapper;
import common.models.ResponseBase;
import org.hamcrest.Description;
import org.hamcrest.StringDescription;
import org.junit.Assert;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

import static common.handlers.Common.findObjectInListByKey;
import static common.handlers.Validation.*;
import static common.handlers.matcher.CombinableMatcher.all;
import static common.handlers.matcher.Compare.convertListIgnore;
import static common.handlers.matcher.Compare.matchesSafely;
import static org.hamcrest.Matchers.*;

public class CompareNew {

    private static final ObjectMapper mapper = new ObjectMapper();

    public static void verifyHttpStatus(Integer expect, Integer actual) {
        compareTwoObjectTheSame(expect, actual, null, null);
    }

    public static void compareTwoObjectTheSame(Object expect, Object actual, String fieldName, String keyList, String... ignoreField) {
        Description mismatchDescriber = new StringDescription();
        try {
            mismatchDescriber.appendText("\n====== Mismatch result: " + fieldName + " ======");
            if (isArrayList(expect)) {
                if (!verifyObject(new ResponseBase(null, null, expect), new ResponseBase(null, null, actual), mismatchDescriber, keyList, ignoreField)) {
                    throw new AssertionError(mismatchDescriber.toString());
                }
            } else {
                if (!verifyObject(expect, actual, mismatchDescriber, keyList, ignoreField)) {
                    throw new AssertionError(mismatchDescriber.toString());
                }
            }
        } catch (Exception e) {
            throw new AssertionError("Fail test:" + e);
        }
    }

    private static boolean verifyObject(Object object1, Object object2, Description desc, Object keyList, String... ignoreField) throws IllegalAccessException {
        Description mismatch = new StringDescription();
        boolean result = true;
        if (!isTheSameClass(object1, object2)) {
            desc.appendText("\nError: Actual Object va expect Object khac kieu\n");
            result = false;
        } else {
            if (!verifyObjectTheSame(object1, object2, mismatch, keyList, ignoreField)) {
                result = false;
                desc.appendText(mismatch.toString());
            }
        }
        return result;
    }

    private static boolean verifyObjectTheSame(Object object1, Object object2, Description desc, Object keyList, String... ignoreField) throws IllegalAccessException {
        CombinableMatcher matcher = null;
        Class clazz = object1.getClass();
        boolean theFirstFlag = true;
        List<String> listIgnore = convertListIgnore(ignoreField);
        if (isPrimitiveType(clazz)) {
            matcher = all(equalToObject(object1));
            return matchesSafely(matcher, object2, desc);
        } else {
            boolean result = true;
            for (Field field : clazz.getDeclaredFields()) {
                field.setAccessible(true);
                if (listIgnore.contains(field.getName())) {
                    continue;
                }

                Object expected = field.get(object1);
                if (expected != null && !isPrimitiveType(expected.getClass())) {
                    Object actual = field.get(object2);
                    if (!verifyObjectNotPrimitiveType(expected, actual, desc, field.getName(), keyList, ignoreField)) {
                        result = false;
                    }
                } else {
                    if (theFirstFlag) {
                        matcher = all(hasProperty(field.getName(), is(field.get(object1))));
                        theFirstFlag = false;
                    } else {
                        matcher.and(hasProperty(field.getName(), is(field.get(object1))));
                    }
                }
            }
            if (!matchesSafely(matcher, object2, desc)) {
                result = false;
            }
            return result;
        }
    }

    private static boolean verifyObjectNotPrimitiveType(Object object1, Object object2, Description desc, String fieldName, Object keyList, String... ignoreField) throws IllegalAccessException {
        Description mismatch = new StringDescription();
        boolean result = true;

        mismatch.appendText("\n====== Mismatch result: " + fieldName + " ======");
        if (isArrayList(object1)) {
            List<Object> list1 = (List<Object>) object1;
            List<Object> list2 = (List<Object>) object2;

            if (!list1.isEmpty() || !list2.isEmpty()) {
                Object classDto = !list1.isEmpty() ? list1.get(0) : list2.get(0);
                if (!matchesSafelyTwoList(list1, list2, keyList, mismatch, classDto.getClass(), ignoreField)) {
                    result = false;
                    desc.appendText(mismatch.toString());
                }
            }
        } else {
            if (!verifyObject(object1, object2, mismatch, keyList, ignoreField)) {
                result = false;
                desc.appendText(mismatch.toString());
            }
        }
        return result;
    }

    public static boolean matchesSafelyTwoList(List<Object> expectedObject, List<Object> actualObject, Object key, Description mismatchDescriber, Class<?> clazz, String... ignoreField) throws IllegalAccessException {
        boolean result = true;

        if (isPrimitiveType(clazz)) {
            Assert.assertArrayEquals(expectedObject.toArray(), actualObject.toArray());
        } else {
            Description mismatchExpected = new StringDescription();
            if (!matchesSafelyObjectDetailOfList(expectedObject, actualObject, key, mismatchExpected, clazz, ignoreField)) {
                mismatchDescriber.appendText("\n\n==========EXPECTED============");
                mismatchDescriber.appendText(mismatchExpected.toString());
                result = false;
            }

            Description mismatchActual = new StringDescription();
            if (!matchesSafelyObjectDetailOfList(actualObject, expectedObject, key, mismatchActual, clazz, ignoreField)) {
                mismatchDescriber.appendText("\n\n==========ACTUAL============");
                mismatchDescriber.appendText(mismatchActual.toString());
                result = false;
            }
        }

        return result;
    }

    public static boolean matchesSafelyObjectDetailOfList(List<Object> listOne, List<Object> listTwo, Object key, Description mismatchDescriber, Class<?> clazz, String... ignoreField) throws IllegalAccessException {
        boolean result = true;

        for (Object object1 : listOne) {
            Map mapRefer = mapper.convertValue(object1, Map.class);
            Object object2 = findObjectInListByKey(object1, listTwo, key, clazz);

            Description mismatchDetail = new StringDescription();
            String tcName = key + "_" + (mapRefer.get(key) == null ? "null" : mapRefer.get(key).toString());
            if (!verifyObject(object1, object2, mismatchDetail, key, ignoreField)) {
                mismatchDescriber.appendText("\n\n==========" + tcName + "============");
                mismatchDescriber.appendText(mismatchDetail.toString());
                result = false;
            }
        }
        return result;
    }
}
