package edu.hw10;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Random;
import org.jetbrains.annotations.NotNull;

@SuppressWarnings("CyclomaticComplexity")
public class Task1 {
    private static final String RANDOM_STRING = "RandomString";
    private static final int MINIMUM_POWER_OF_TO_THAT_DOES_NOT_FIT_INTO_INT = 31;

    public static class RandomObjectGenerator {
        private static final Random RANDOM = new Random();

        public <T> T nextObject(Class<T> clazz, String factoryMethod) {
            T object = null;
            if (factoryMethod != null && !factoryMethod.isEmpty()) {
                try {
                    Method method = null;
                    if (clazz == Task1HelpClasses.SomeClass.class) {
                        method = clazz.getDeclaredMethod(factoryMethod, String.class, Integer.class);
                    }

                    object = (T) method.invoke(null, "", RANDOM.nextInt());
                } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            } else {
                Constructor<T> constructor = null;
                try {
                    if (Task1HelpClasses.Car.class == clazz) {
                        constructor = clazz.getDeclaredConstructor(Integer.class);
                        object = constructor.newInstance(RANDOM.nextInt());
                    } else if (Task1HelpClasses.Animal.class == clazz) {
                        constructor = clazz.getDeclaredConstructor(String.class, String.class);
                        object = constructor.newInstance(RANDOM_STRING, RANDOM_STRING);
                    } else if (Task1HelpClasses.Square.class == clazz) {
                        constructor = clazz.getDeclaredConstructor(Integer.class);
                        object = constructor.newInstance(RANDOM.nextInt());
                    } else if (Task1HelpClasses.Rectangle.class == clazz) {
                        constructor = clazz.getDeclaredConstructor(Integer.class, Integer.class);
                        object = constructor.newInstance(RANDOM.nextInt(), RANDOM.nextInt());
                    }
                } catch (InvocationTargetException | NoSuchMethodException | InstantiationException
                         | IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
            try {
                for (java.lang.reflect.Field field : clazz.getDeclaredFields()) {
                    Annotation[] annotations = clazz.getDeclaredAnnotations();

                    for (Annotation annotation : annotations) {
                        if (annotation instanceof NotNull && field.get(object) == null) {
                            if (field.getType() == Integer.class) {
                                field.set(object, RANDOM.nextInt());
                            } else if (field.getType() == String.class && field.get(object) == null) {
                                field.set(object, "RandomStringGenerator");
                            }
                        } else if (annotation instanceof Task1HelpClasses.Min) {
                            if (field.getType() == Integer.class) {
                                field.set(object, 0);
                            } else if (field.getType() == String.class) {
                                field.set(object, "");
                            }
                        } else if (annotation instanceof Task1HelpClasses.Max) {
                            if (field.getType() == Integer.class) {
                                field.set(object, 1 << MINIMUM_POWER_OF_TO_THAT_DOES_NOT_FIT_INTO_INT - 1);
                            } else if (field.getType() == String.class) {
                                field.set(object, "MaxString");
                            }
                        }
                    }
                }

            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }

            return object;
        }

        public <T> T nextObject(Class<T> clazz) {
            return nextObject(clazz, "");
        }
    }
}
