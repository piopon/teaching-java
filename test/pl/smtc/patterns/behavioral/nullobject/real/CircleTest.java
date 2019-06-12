package pl.smtc.patterns.behavioral.nullobject.real;

import org.junit.jupiter.api.Test;
import pl.smtc.base.BaseTestOut;

import static org.junit.jupiter.api.Assertions.*;

class CircleTest extends BaseTestOut {
    private Circle testShape;

    @Override
    protected void setUp() {
        testShape = new Circle(2.0);
    }

    @Test
    void getAreaShouldReturnCorrectCircleArea() {
        assertEquals(12.566370614359172, testShape.getArea());
    }

    @Test
    void getPerimeterShouldReturnCorrectCirclePerimeter() {
        assertEquals(12.566370614359172, testShape.getPerimeter());
    }

    @Test
    void drawShouldInvokeCircleDrawAlgorithm() {
        testShape.draw();
        String output = getOutput();
        assertTrue(output.contains("Drawing a circle"));
    }

    @Test
    void equalsShouldReturnTrueForTheSameObject() {
        assertEquals(testShape, new Circle(2.0));
    }

    @Test
    void equalsShouldReturnFalseForDifferentObject() {
        assertNotEquals(testShape, new Circle(1.99));
    }

    @Test
    void hashCodeShouldReturnCorrectValue() {
        assertEquals(1.073741855E9, testShape.hashCode());
    }
}