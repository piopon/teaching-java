package pl.smtc.patterns.structural.decorator.components;

public class Ford extends Car {
    public Ford(String name, double price) {
        super(name, price);
    }

    @Override
    public String getName() {
        return "Ford " + super.getName();
    }
}
