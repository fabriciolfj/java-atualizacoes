package br.com.github.pattern.factory.abstractfactory;

import br.com.github.pattern.factory.MotorVehicle;

public class FutureVehicleCorporation extends Corporation {

    @Override
    public MotorVehicle createMotorVehicle() {
        return new FutureVehicleMotorCycle();
    }

    @Override
    public EletricVehicle createElectricVehicle() {
        return new FutureVehicleEletricCar();
    }
}
