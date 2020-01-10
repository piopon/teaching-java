package pl.smtc.patterns.behavioral.nullobject.real;

import org.junit.jupiter.api.Test;
import pl.smtc.base.BaseTestOut;

import static org.junit.jupiter.api.Assertions.*;

class RectangleTest extends BaseTestOut {
    private Rectangle testShape;

    @Override
    protected void setUp() {
        testShape = new Rectangle(2.0, 5.0);
    }

    @Test
    void getAreaShouldReturnCorrectRectangleArea() {
        assertEquals(10.0, testShape.getArea());
    }

    @Test
    void getPerimeterShouldReturnCorrectRectanglePerimeter() {
        assertEquals(14.0, testShape.getPerimeter());
    }

    @Test
    void drawShouldInvokeRectangleDrawAlgorithm() {
        testShape.draw();
        String output = getOutput();
        assertTrue(output.contains("Drawing a rectangle"));
    }

    @Test
    void equalsShouldReturnTrueForTheSameObject() {
        assertEquals(testShape, new Rectangle(2.0, 5.0));
    }

    @Test
    void equalsShouldReturnFalseForDifferentObject() {
        assertNotEquals(testShape, new Rectangle(1.99, 5.00));
    }

    @Test
    void hashCodeShouldReturnCorrectValue() {
        assertEquals(1311681, testShape.hashCode());
    }
}