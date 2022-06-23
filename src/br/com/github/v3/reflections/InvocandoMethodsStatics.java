package br.com.github.v3.reflections;

import br.com.github.entities.Melon;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

public class InvocandoMethodsStatics {

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        List<Method> methods = new ArrayList<>();
        var clazz = Melon.class.getDeclaredMethods();

        for (Method method : clazz) {
            if (Modifier.isStatic(method.getModifiers())) {
                methods.add(method);
            }
        }

        for(Method method: methods) {
            method.invoke( null, 4);
        }
    }
}
