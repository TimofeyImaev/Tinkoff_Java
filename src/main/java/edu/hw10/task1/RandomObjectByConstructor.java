package edu.hw10.task1;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Random;

public class RandomObjectByConstructor {
    private static final Random RANDOM = new Random();
    private static final String RANDOM_STRING = "RandomString";
    private static final int MINIMUM_POWER_OF_TWO_THAT_DOES_NOT_FIT_INTO_SHORT = 15;
    private static final short BIGGEST_SHORT = 1 << MINIMUM_POWER_OF_TWO_THAT_DOES_NOT_FIT_INTO_SHORT - 1;

    private RandomObjectByConstructor() {

    }

    public static <T> T getRandomObjectByClass(Class<T> clazz)
        throws InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        Constructor<T> constructor = null;
        Constructor<?>[] constructors = null;
        T object = null;

        constructors = clazz.getDeclaredConstructors();

        for (var each : constructors) {
            if (each.getParameterCount() != 0) {
                constructor = (Constructor<T>) each;
                break;
            }
        }

        Object[] args = new Object[constructor.getParameterCount()];
        Class<?>[] paramTypes = constructor.getParameterTypes();

        for (int i = 0; i < constructor.getParameterCount(); ++i) {
            if (paramTypes[i] == Integer.class) {
                args[i] = RANDOM.nextInt();
            } else if (paramTypes[i] == String.class) {
                args[i] = "RandomStringGenerator";
            } else if (paramTypes[i] == Short.class) {
                args[i] = ((Integer) RANDOM.nextInt(-BIGGEST_SHORT, BIGGEST_SHORT)).shortValue();
            } else if (paramTypes[i] == Long.class) {
                args[i] = RANDOM.nextLong();
            } else if (paramTypes[i] == Float.class) {
                args[i] = RANDOM.nextFloat();
            } else if (paramTypes[i] == Boolean.class) {
                args[i] = RANDOM.nextBoolean();
            }
        }

        return constructor.newInstance(args);
    }
}
