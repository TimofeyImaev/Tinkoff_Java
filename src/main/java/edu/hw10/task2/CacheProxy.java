package edu.hw10.task2;

import edu.hw1.Pair;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;

public class CacheProxy implements InvocationHandler {
    private Object target;
    private HashMap<Pair<String, Object[]>, Object> cache;

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
        Pair<String, Object[]> key = new Pair<>(methodName, args);

        if (cache.containsKey(key)) {
            return cache.get(key);
        } else {
            Object result = method.invoke(target, args);
            cache.put(key, result);
            return result;
        }
    }
}
