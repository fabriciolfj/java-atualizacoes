package br.com.alura.v2.proxydinamico;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Simulacao {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        final Object proxy = Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(), new Class<?>[]{ HelloWorld.class},
                (prox, method, arg) -> {
                    if (method.isDefault()) {
                        return InvocationHandler.invokeDefault(prox, method, arg);
                    }

                    return null;
                });

        final Method method = proxy.getClass().getMethod("hello");
        System.out.println(method.invoke(proxy));
    }
}
