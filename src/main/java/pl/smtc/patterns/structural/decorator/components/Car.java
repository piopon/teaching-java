package pl.smtc.patterns.structural.decorator.components;

public abstract class Car {
    private String name;
    private double initialPrice;

    public Car(String name, double initialPrice) {
        this.name = name;
        this.initialPrice = initialPrice;
    }

    protected Car() {
        this.name = "";
        this.initialPrice = 0.0;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return initialPrice;
    }
}
