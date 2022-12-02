package br.com.github.pattern.factory;

public class MotorCycle implements MotorVehicle {
    @Override
    public void build() {
        System.out.println("Build motorcycle");
    }
}
