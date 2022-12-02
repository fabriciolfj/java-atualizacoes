package br.com.github.pattern.factory.abstractfactory;

public class FutureVehicleEletricCar implements EletricVehicle {

    @Override
    public void build() {
        System.out.println("future vehicle eletric car");
    }
}
