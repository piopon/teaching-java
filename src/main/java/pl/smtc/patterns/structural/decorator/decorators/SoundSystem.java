package pl.smtc.patterns.structural.decorator.decorators;

import pl.smtc.patterns.structural.decorator.components.Car;

public class SoundSystem extends CarOption {
    private double price = 2_150;

    public SoundSystem(Car parentCar) {
        super(parentCar);
    }

    @Override
    public double getPrice() {
        return parentCar.getPrice() + price;
    }

    @Override
    public String getName() {
        return parentCar.getName() + " + SOUND SYSTEM";
    }
}
