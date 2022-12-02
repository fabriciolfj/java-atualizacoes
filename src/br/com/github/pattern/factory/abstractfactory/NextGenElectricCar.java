package br.com.github.pattern.factory.abstractfactory;

public class NextGenElectricCar implements EletricVehicle {

    @Override
    public void build() {
        System.out.println("next gen electric car");
    }
}
