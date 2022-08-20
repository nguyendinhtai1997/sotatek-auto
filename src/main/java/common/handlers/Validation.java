package common.handlers;

import java.util.Date;

public class Validation {
    public static boolean isPrimitiveType(Class<?> retType) {
        if (retType.isPrimitive() && retType != void.class) {
            return true;
        }
        if (Number.class.isAssignableFrom(retType)) {
            return true;
        }
        if (Boolean.class == retType) {
            return true;
        }
        if (Character.class == retType) {
            return true;
        }
        if (String.class == retType) {
            return true;
        }
        if (Date.class.isAssignableFrom(retType)) {
            return true;
        }
        if (byte[].class.isAssignableFrom(retType)) {
            return true;
        }
        return Enum.class.isAssignableFrom(retType);
    }

    public static boolean isArrayList(Object object) {
        return "ArrayList".equalsIgnoreCase(object.getClass().getSimpleName());
    }

    public static boolean isTheSameClass(Object classOne, Object classTwo) {
        return classOne.getClass().isInstance(classTwo);
    }
}
