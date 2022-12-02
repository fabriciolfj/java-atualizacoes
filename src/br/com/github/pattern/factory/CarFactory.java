package br.com.github.pattern.factory;

public class CarFactory extends MotorVehicleFactory {

    @Override
    protected MotorVehicle createMotorVehicle() {
        return new Car();
    }
}
