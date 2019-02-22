package pl.smtc.patterns.structural.decorator.components;

public class Toyota extends Car {
    public Toyota(String name, double initialPrice) {
        super(name, initialPrice);
    }

    @Override
    public String getName() {
        return "Toyota " + super.getName();
    }
}
