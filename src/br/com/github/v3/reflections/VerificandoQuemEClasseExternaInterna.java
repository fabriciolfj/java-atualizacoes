package br.com.github.v3.reflections;

import br.com.github.entities.Melon;

public class VerificandoQuemEClasseExternaInterna {

    public static void main(String[] args) {
        Class<Car> clazzCar = Car.class;
        Class<Melon> clazzMelon = Melon.class;

        Class<Car.Engine> clazzEngine = Car.Engine.class;

        Class<?> nestClazzCar = clazzEngine.getNestHost();

        System.out.println("Classe externa: " + nestClazzCar);
        System.out.println("Class interna: " + clazzEngine.isMemberClass());

        //verificando se as classes fazem parte do ninho
        System.out.println(clazzCar.isNestmateOf(clazzCar));
        System.out.println(clazzEngine.isNestmateOf(clazzCar));
        System.out.println(clazzEngine.isNestmateOf(clazzEngine));
        System.out.println(clazzCar.isNestmateOf(clazzMelon));
    }
}
