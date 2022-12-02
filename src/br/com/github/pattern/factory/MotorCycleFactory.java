package br.com.github.pattern.factory;

public class MotorCycleFactory extends MotorVehicleFactory {

    @Override
    protected MotorVehicle createMotorVehicle() {
        return new MotorCycle();
    }
}
