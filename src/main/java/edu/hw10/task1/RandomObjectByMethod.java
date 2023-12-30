package edu.hw10.task1;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Random;

public class RandomObjectByMethod {
    private static final Random RANDOM = new Random();
    private static final String RANDOM_STRING = "RandomString";
    private static final int MINIMUM_POWER_OF_TWO_THAT_DOES_NOT_FIT_INTO_SHORT = 15;
    private static final short BIGGEST_SHORT = 1 << MINIMUM_POWER_OF_TWO_THAT_DOES_NOT_FIT_INTO_SHORT - 1;

    private RandomObjectByMethod() {

    }

    public static <T> T getRandomObjectByClass(Class<T> clazz, String factoryMethod)
        throws InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {

        Method method = null;

        for (var each : clazz.getDeclaredMethods()) {
            if (each.getName().equals(factoryMethod)) {
                method = each;
                break;
            }
        }

        Object[] args = new Object[method.getParameterCount()];
        Class<?>[] paramTypes = method.getParameterTypes();

        for (int i = 0; i < method.getParameterCount(); ++i) {
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

        method.setAccessible(true);
        T object = (T) method.invoke(null, args);
        return object;
    }
}
