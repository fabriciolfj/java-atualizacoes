package br.com.github.pattern.factory.abstractfactory;

import br.com.github.pattern.factory.MotorVehicle;

public class NextGenCorporation extends Corporation {

    @Override
    public MotorVehicle createMotorVehicle() {
        return new NextGenMotorCyle();
    }

    @Override
    public EletricVehicle createElectricVehicle() {
        return new NextGenElectricCar();
    }
}
