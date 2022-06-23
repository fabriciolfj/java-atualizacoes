package br.com.github.v3.reflections;

import br.com.github.entities.Melon;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;


public class PegandoCampos {

    public static void main(String[] args) throws NoSuchMethodException {
        Field[] fields = Melon.class.getDeclaredFields();

        for (int i = 0; i < fields.length; i++) {
            var name = fields[i].getName();
            var type = fields[i].getType();
            var field = "set" + name.substring(0, 1).toUpperCase() + name.substring(1);

            Method method = Melon.class.getDeclaredMethod(field, type);

            System.out.println(field);
            System.out.println(type);
            System.out.println(method);
            System.out.println(method.getParameterCount());
            var parameters = method.getParameterTypes();

            for (int index = 0; i < parameters.length; i++) {
                System.out.println(parameters[i]);

                var annotations = parameters[i].getAnnotations();

                for(Annotation annotation: annotations) {
                    System.out.println("Annotation: " + annotation);
                }
            }
        }
    }
}
