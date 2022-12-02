package br.com.github.pattern.factory.abstractfactory;

import br.com.github.pattern.factory.MotorVehicle;

public abstract class Corporation {

    public abstract MotorVehicle createMotorVehicle();
    public abstract EletricVehicle createElectricVehicle();
}
