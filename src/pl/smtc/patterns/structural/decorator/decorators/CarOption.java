package pl.smtc.patterns.structural.decorator.decorators;

import pl.smtc.patterns.structural.decorator.components.Car;

public abstract class CarOption extends Car {
    protected Car parentCar;

    public CarOption(Car parentCar) {
        this.parentCar = parentCar;
    }
}
