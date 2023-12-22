package edu.hw10.task1;

import java.util.Random;

public class NotNullHandler {
    private static final Random RANDOM = new Random();
    private static final int MINIMUM_POWER_OF_TWO_THAT_DOES_NOT_FIT_INTO_SHORT = 15;

    private static final short BIGGEST_SHORT = 1 << MINIMUM_POWER_OF_TWO_THAT_DOES_NOT_FIT_INTO_SHORT - 1;

    private NotNullHandler() {
    }

    public static <T> void notNullAnnotationHandler(java.lang.reflect.Field field, T object)
        throws IllegalAccessException {
        if (field.getType() == Integer.class) {
            field.set(object, RANDOM.nextInt());
        } else if (field.getType() == String.class && field.get(object) == null) {
            field.set(object, "RandomStringGenerator");
        } else if (field.getType() == Short.class) {
            field.set(object, ((Integer) RANDOM.nextInt(-BIGGEST_SHORT, BIGGEST_SHORT)).shortValue());
        } else if (field.getType() == Long.class) {
            field.set(object, RANDOM.nextLong());
        } else if (field.getType() == Float.class) {
            field.set(object, RANDOM.nextFloat());
        } else if (field.getType() == Boolean.class) {
            field.set(object, RANDOM.nextBoolean());
        }
    }
}
