package pl.smtc.patterns.structural.decorator.decorators;

import pl.smtc.patterns.structural.decorator.components.Car;

public class HeatedSeats extends CarOption {
    private double price = 10_000;

    public HeatedSeats(Car parentCar) {
        super(parentCar);
    }

    @Override
    public double getPrice() {
        return parentCar.getPrice() + price;
    }

    @Override
    public String getName() {
        return parentCar.getName() + " + HEATED SEATS";
    }
}
