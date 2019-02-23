package pl.smtc.patterns.structural.decorator.decorators;

import pl.smtc.patterns.structural.decorator.components.Car;

public class GPS extends CarOption {
    private double price = 3_000;

    public GPS(Car parentCar) {
        super(parentCar);
    }

    @Override
    public double getPrice() {
        return parentCar.getPrice() + price;
    }

    @Override
    public String getName() {
        return parentCar.getName() + " + GPS";
    }
}
