package edu.hw10;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;

public class Task2 {
    public interface FibCalculator {
        @Cache
        long fib(int number);
    }

    public interface StringConcatenation {
        @Cache
        String concatenate(String firstString, String secondString);
    }

    public interface SquareOfNumber {
        @Cache
        int square(int number);
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    public @interface Cache {
        boolean persist() default false;
    }

    public static class Fib implements FibCalculator {
        @Override
        public long fib(int number) {
            if (number <= 1) {
                return 0;
            }
            return fib(number - 1) + fib(number - 2);
        }
    }

    public static class Square implements SquareOfNumber {

        @Override
        public int square(int number) {
            return number * number;
        }
    }

    public static class Concatenate implements StringConcatenation {

        @Override
        public String concatenate(String firstString, String secondString) {
            return firstString + secondString;
        }
    }

    public static class CacheProxy implements InvocationHandler {
        private Object target;
        private HashMap<String, Object> cache;

        public CacheProxy(Object target) {
            this.target = target;
            this.cache = new HashMap<>();
        }

        public static <T> T create(Object target, Class<T> interfaceClass) {
            return (T) Proxy.newProxyInstance(
                interfaceClass.getClassLoader(),
                new Class<?>[] {interfaceClass},
                new CacheProxy(target)
            );
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            String methodName = method.getName();
            if (cache.containsKey(methodName)) {
                return cache.get(methodName);
            } else {
                Object result = method.invoke(target, args);
                cache.put(methodName, result);
                return result;
            }
        }
    }
}
