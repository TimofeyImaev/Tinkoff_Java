package edu.hw10.task1;

public class MaxHandler {
    private static final int MINIMUM_POWER_OF_TWO_THAT_DOES_NOT_FIT_INTO_INT = 31;
    private static final int MINIMUM_POWER_OF_TWO_THAT_DOES_NOT_FIT_INTO_SHORT = 15;
    private static final int MINIMUM_POWER_OF_TWO_THAT_DOES_NOT_FIT_INTO_LONG = 63;
    private static final float BIG_FLOAT_NUMBER = 999999;

    private MaxHandler() {

    }

    public static <T> void maxAnnotationHandler(java.lang.reflect.Field field, T object) throws IllegalAccessException {
        if (field.getType() == Integer.class) {
            field.set(object, 1 << MINIMUM_POWER_OF_TWO_THAT_DOES_NOT_FIT_INTO_INT - 1);
        } else if (field.getType() == String.class) {
            field.set(object, "MaxString");
        } else if (field.getType() == Short.class) {
            field.set(object, (short) (1 << MINIMUM_POWER_OF_TWO_THAT_DOES_NOT_FIT_INTO_SHORT - 1));
        } else if (field.getType() == Long.class) {
            field.set(object, 1L << MINIMUM_POWER_OF_TWO_THAT_DOES_NOT_FIT_INTO_LONG - 1);
        } else if (field.getType() == Float.class) {
            field.set(object, BIG_FLOAT_NUMBER);
        } else if (field.getType() == Boolean.class) {
            field.set(object, true);
        }
    }
}
