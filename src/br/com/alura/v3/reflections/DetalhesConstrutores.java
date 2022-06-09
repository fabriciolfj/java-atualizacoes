package br.com.alura.v3.reflections;

import java.lang.reflect.Constructor;
import java.lang.reflect.Parameter;
import java.util.stream.Stream;

public class DetalhesConstrutores {

    public static void main(String[] args) {
        Class<Car> clazz = Car.class;
        Constructor<?>[] cnstrs = clazz.getConstructors();

        for (Constructor<?> cnstr : cnstrs) {
            int paramCount = cnstr.getParameterCount();
            Parameter[] params = cnstr.getParameters();
            Class<?>[] types = cnstr.getParameterTypes();

            System.out.println(paramCount);
            Stream.of(params).forEach(v ->  System.out.println(v.getName()));
            Stream.of(types).forEach(v ->  System.out.println(v.getName()));
        }
    }
}
