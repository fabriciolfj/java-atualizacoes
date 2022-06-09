package br.com.alura.v3.reflections;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class InstanciandoViaReflexaoConstructor {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<Car> clazz = Car.class;
        Constructor<Car> vazio = clazz.getConstructor();
        Constructor<Car> idNome = clazz.getConstructor(int.class, String.class);
        Constructor<Car> idNomeColor = clazz.getConstructor(int.class, String.class, Color.class);

        Car carroVazio = vazio.newInstance();
        Car carroIdNome = idNome.newInstance(1, "Fusca");
        Car carroIdNomeCor = idNomeColor.newInstance(1, "Brasilia", Color.AMARELO);

        System.out.println(carroVazio);
        System.out.println(carroIdNome);
        System.out.println(carroIdNomeCor);
    }
}
