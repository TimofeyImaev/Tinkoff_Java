package edu.hw10.task1;

import edu.hw10.task1.HelpClasses.Animal;
import edu.hw10.task1.HelpClasses.Car;
import edu.hw10.task1.HelpClasses.ManyNumberTypes;
import edu.hw10.task1.HelpClasses.Rectangle;
import edu.hw10.task1.HelpClasses.Square;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Random;

public class RandomObject {
    private static final Random RANDOM = new Random();
    private static final String RANDOM_STRING = "RandomString";
    private static final int MINIMUM_POWER_OF_TWO_THAT_DOES_NOT_FIT_INTO_SHORT = 15;
    private static final short BIGGEST_SHORT = 1 << MINIMUM_POWER_OF_TWO_THAT_DOES_NOT_FIT_INTO_SHORT - 1;

    private RandomObject() {

    }

    public static <T> T getRandomObjectByClass(Class<T> clazz)
        throws InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        Constructor<T> constructor = null;
        T object = null;

        if (Car.class == clazz) {
            constructor = clazz.getDeclaredConstructor(Integer.class);
            object = constructor.newInstance(RANDOM.nextInt());
        } else if (Animal.class == clazz) {
            constructor = clazz.getDeclaredConstructor(String.class, String.class);
            object = constructor.newInstance(RANDOM_STRING, RANDOM_STRING);
        } else if (Square.class == clazz) {
            constructor = clazz.getDeclaredConstructor(Integer.class);
            object = constructor.newInstance(RANDOM.nextInt());
        } else if (Rectangle.class == clazz) {
            constructor = clazz.getDeclaredConstructor(Integer.class, Integer.class);
            object = constructor.newInstance(RANDOM.nextInt(), RANDOM.nextInt());
        } else if (ManyNumberTypes.class == clazz) {
            constructor =
                clazz.getDeclaredConstructor(Boolean.class, Integer.class, Short.class, Long.class, Float.class);
            object = constructor.newInstance(
                RANDOM.nextBoolean(),
                RANDOM.nextInt(),
                ((Integer) RANDOM.nextInt(-BIGGEST_SHORT, BIGGEST_SHORT)).shortValue(),
                RANDOM.nextLong(),
                RANDOM.nextFloat()
            );
        }

        return object;
    }
}
