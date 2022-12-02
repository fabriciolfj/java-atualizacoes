package br.com.github.pattern.factory;

public class Car implements MotorVehicle {

    @Override
    public void build() {
        System.out.println("Build car");
    }
}
