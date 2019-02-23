package pl.smtc.patterns.structural.decorator.decorators;

import pl.smtc.patterns.structural.decorator.components.Car;

public class MetallicPaint extends CarOption {
    private double price = 8_500;

    public MetallicPaint(Car parentCar) {
        super(parentCar);
    }

    @Override
    public double getPrice() {
        return parentCar.getPrice() + price;
    }

    @Override
    public String getName() {
        return parentCar.getName() + " + METALLIC PAINT";
    }
}
