package edu.hw10.task1;

import edu.hw10.task1.HelpClasses.Max;
import edu.hw10.task1.HelpClasses.Min;
import edu.hw10.task1.HelpClasses.SomeClass;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Random;
import org.jetbrains.annotations.NotNull;
import static edu.hw10.task1.MaxHandler.maxAnnotationHandler;
import static edu.hw10.task1.MinHandler.minAnnotationHandler;
import static edu.hw10.task1.RandomObject.getRandomObjectByClass;

public class RandomObjectGenerator {
    private static final String RANDOM_STRING = "RandomString";
    private static final Random RANDOM = new Random();

    public <T> T nextObject(Class<T> clazz, String factoryMethod) {
        T object = null;
        if (factoryMethod != null && !factoryMethod.isEmpty()) {
            try {
                Method method = null;
                if (clazz == SomeClass.class) {
                    method = clazz.getDeclaredMethod(factoryMethod, String.class, Integer.class);
                    method.setAccessible(true);
                    object = (T) method.invoke(null, "", RANDOM.nextInt());
                }
            } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        } else {
            try {
                object = getRandomObjectByClass(clazz);
            } catch (InvocationTargetException | NoSuchMethodException | InstantiationException
                     | IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }

        try {
            for (java.lang.reflect.Field field : clazz.getDeclaredFields()) {
                Annotation[] annotations = clazz.getDeclaredAnnotations();
                field.setAccessible(true);

                for (Annotation annotation : annotations) {
                    if (annotation instanceof NotNull && field.get(object) == null) {
                        NotNullHandler.notNullAnnotationHandler(field, object);
                    } else if (annotation instanceof Min) {
                        minAnnotationHandler(field, object);
                    } else if (annotation instanceof Max) {
                        maxAnnotationHandler(field, object);
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
