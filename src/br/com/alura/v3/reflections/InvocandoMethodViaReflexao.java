package br.com.alura.v3.reflections;

import br.com.alura.entities.Melon;

import java.lang.reflect.InvocationTargetException;

public class InvocandoMethodViaReflexao {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        var method = Melon.class.getDeclaredMethod("cultivar", String.class, int.class);
        var instance = Melon.class.getDeclaredConstructor().newInstance();
        var result = method.invoke(instance, "gac", 5);

        System.out.println(result);
    }
}
