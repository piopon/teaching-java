package pl.smtc.patterns.behavioral.nullobject.real;

import pl.smtc.patterns.behavioral.nullobject.base.Shape;

import java.util.Objects;

public class Triangle implements Shape {
    private final static String INVALID = "Cannot create triangle from inputted sides!";
    private final double sideA;
    private final double sideB;
    private final double sideC;
    private final boolean triangleValid;

    public Triangle(double sideA, double sideB, double sideC) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
        triangleValid = sidesValid(sideA, sideB, sideC);
    }

    @Override
    public double getArea() {
        if (!triangleValid) {
            System.out.println(INVALID);
            return 0;
        }
        double semiPerimeter = 0.5 * (sideA + sideB + sideC);
        double heronSideA = (semiPerimeter - sideA);
        double heronSideB = (semiPerimeter - sideB);
        double heronSideC = (semiPerimeter - sideC);

        return Math.sqrt(semiPerimeter * heronSideA * heronSideB * heronSideC);
    }

    @Override
    public double getPerimeter() {
        if (!triangleValid) {
            System.out.println(INVALID);
            return 0;
        }
        return sideA + sideB + sideC;
    }

    @Override
    public void draw() {
        if (!triangleValid) {
            System.out.println(INVALID);
        }
        System.out.println("Drawing a triangle");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Triangle triangle = (Triangle) o;
        return Double.compare(triangle.sideA, sideA) == 0 &&
                Double.compare(triangle.sideB, sideB) == 0 &&
                Double.compare(triangle.sideC, sideC) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(sideA, sideB, sideC);
    }

    private boolean sidesValid(double a, double b, double c) {
        return !(a + b <= c || a + c <= b || b + c <= a);
    }
}
