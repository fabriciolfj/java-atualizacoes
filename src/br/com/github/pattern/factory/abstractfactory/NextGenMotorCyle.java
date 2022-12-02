package br.com.github.pattern.factory.abstractfactory;

import br.com.github.pattern.factory.MotorVehicle;

public class NextGenMotorCyle implements MotorVehicle {

    @Override
    public void build() {
        System.out.println("nextgen motorcycle");
    }
}
