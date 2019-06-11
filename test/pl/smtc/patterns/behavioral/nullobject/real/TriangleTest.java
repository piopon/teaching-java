package pl.smtc.patterns.behavioral.nullobject.real;

import org.junit.jupiter.api.Test;
import pl.smtc.base.BaseTestOut;

import static org.junit.jupiter.api.Assertions.*;

class TriangleTest extends BaseTestOut {
    private Triangle validTestShape;
    private Triangle invalidTestShape;

    @Override
    protected void setUp() {
        validTestShape = new Triangle(3.0, 4.0, 5.0);
        invalidTestShape = new Triangle(1.0,10.0,12.0);
    }

    @Test
    void getAreaShouldReturnTriangleAreaIfSidesAreValid() {
        assertEquals(6.0, validTestShape.getArea());
    }

    @Test
    void getAreaShouldReturnZeroIfSidesAreInvalid() {
        assertEquals(0.0, invalidTestShape.getArea());
    }

    @Test
    void getPerimeterShouldReturnTrianglePerimeterIfSidesAreValid() {
        assertEquals(12.0, validTestShape.getPerimeter());
    }

    @Test
    void getPerimeterShouldReturnZeroIfSidesAreInvalid() {
        assertEquals(0.0, invalidTestShape.getPerimeter());
    }

    @Test
    void drawShouldInvokeTriangleDrawAlgorithmIfSidesAreValid() {
        validTestShape.draw();
        String output = getOutput();
        assertTrue(output.contains("Drawing a triangle"));
    }

    @Test
    void drawShouldShowErrorIfSidesAreInvalid() {
        invalidTestShape.draw();
        String output = getOutput();
        assertTrue(output.contains("Cannot create triangle from inputted sides!"));
    }

    @Test
    void equalsShouldReturnTrueForTheSameObject() {
        assertEquals(validTestShape, new Triangle(3.0, 4.0, 5.0));
    }

    @Test
    void equalsShouldReturnFalseForDifferentObject() {
        assertNotEquals(validTestShape, new Triangle(3.0, 4.0, 5.01));
    }

    @Test
    void hashCodeShouldReturnCorrectValue() {
        assertEquals(1.611428959E9, validTestShape.hashCode());
    }
}