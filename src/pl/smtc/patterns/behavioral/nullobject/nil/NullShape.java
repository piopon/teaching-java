package pl.smtc.patterns.behavioral.nullobject.nil;

import pl.smtc.patterns.behavioral.nullobject.base.Shape;

import java.util.Objects;

public class NullShape implements Shape {
    private final String shapeName;

    public NullShape(String shapeName) {
        this.shapeName = shapeName;
    }

    @Override
    public double getArea() {
        return 0;
    }

    @Override
    public double getPerimeter() {
        return 0;
    }

    @Override
    public void draw() {
        System.out.println("Cannot draw " + shapeName + " shape!");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NullShape nullShape = (NullShape) o;
        return Objects.equals(shapeName, nullShape.shapeName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(shapeName);
    }
}
