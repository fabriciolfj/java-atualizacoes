package br.com.alura.v3.reflections;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class InstanciarClasseConstrutorPrivado {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<Util> utilClass = Util.class;
        Constructor<Util> constructor = utilClass.getDeclaredConstructor();
        constructor.setAccessible(true);

        var util = constructor.newInstance();
        util.setValue("fabricio");

        System.out.println(util);
    }
}
