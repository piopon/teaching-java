package pl.smtc.patterns.behavioral.nullobject;

import org.junit.jupiter.api.Test;
import pl.smtc.base.BaseTestInOut;
import pl.smtc.patterns.behavioral.nullobject.base.Shape;
import pl.smtc.patterns.behavioral.nullobject.nil.NullShape;
import pl.smtc.patterns.behavioral.nullobject.real.Circle;
import pl.smtc.patterns.behavioral.nullobject.real.Rectangle;
import pl.smtc.patterns.behavioral.nullobject.real.Triangle;

import static org.junit.jupiter.api.Assertions.*;

class NullObjectPatternTest extends BaseTestInOut {
    private NullObjectPattern nullObjectPattern;

    @Override
    protected void setUp() {
        nullObjectPattern = new NullObjectPattern();
    }

    @Test
    void executeShouldInvokeNullObjectPatternExample() {
        simulateCommaInput("circle, rectangle, triangle, trapezoid, Q");
        nullObjectPattern.execute();
        String output = getOutput();
        assertTrue(output.contains("SHAPE BASIC INFORMATION"));
        assertTrue(output.contains("Input shape type [Q to quit]: "));
        assertTrue(output.contains("Drawing a circle"));
        assertTrue(output.contains("PERIMETER: 15.707963267948966"));
        assertTrue(output.contains("AREA: 19.634954084936208"));
        assertTrue(output.contains("Drawing a rectangle"));
        assertTrue(output.contains("PERIMETER: 23.0"));
        assertTrue(output.contains("AREA: 15.0"));
        assertTrue(output.contains("Drawing a triangle"));
        assertTrue(output.contains("PERIMETER: 12.0"));
        assertTrue(output.contains("AREA: 6.0"));
        assertTrue(output.contains("Cannot draw trapezoid shape!"));
        assertTrue(output.contains("PERIMETER: 0.0"));
        assertTrue(output.contains("AREA: 0.0"));
    }

    @Test
    void getNameShouldReturnNullObjectPatternString() {
        assertEquals("Null object pattern", nullObjectPattern.getName());
    }

    @Test
    void createShapeShouldCreateCircleIfCircleStringInputted() {
        Shape current = nullObjectPattern.createShape("circle");
        Shape expected = new Circle(2.5);
        assertEquals(expected, current);
    }

    @Test
    void createShapeShouldCreateRectangleIfRectangleStringInputted() {
        Shape current = nullObjectPattern.createShape("rectangle");
        Shape expected = new Rectangle(10.0, 1.5);
        assertEquals(expected, current);
    }

    @Test
    void createShapeShouldCreateTriangleIfTriangleStringInputted() {
        Shape current = nullObjectPattern.createShape("triangle");
        Shape expected = new Triangle(3.0, 4.0, 5.0);
        assertEquals(expected, current);
    }

    @Test
    void createShapeShouldCreateNullShapeIfUnknownStringInputted() {
        String unknownShape = "square";
        Shape current = nullObjectPattern.createShape(unknownShape);
        Shape expected = new NullShape(unknownShape);
        assertEquals(expected, current);
    }
}