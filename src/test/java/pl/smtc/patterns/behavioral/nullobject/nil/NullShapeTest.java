package pl.smtc.patterns.behavioral.nullobject.nil;

import org.junit.jupiter.api.Test;
import pl.smtc.base.BaseTestOut;

import static org.junit.jupiter.api.Assertions.*;

class NullShapeTest extends BaseTestOut {
    private final static String SHAPE_NAME = "pentagon";
    private NullShape testShape;

    @Override
    protected void setUp() {
        testShape = new NullShape(SHAPE_NAME);
    }

    @Test
    void getAreaShouldReturnZeroForNullShape() {
        assertEquals(0, testShape.getArea());
    }

    @Test
    void getPerimeterShouldReturnZeroForNullShape() {
        assertEquals(0, testShape.getPerimeter());
    }

    @Test
    void drawShouldReturnCantDrawMessage() {
        testShape.draw();
        String output = getOutput();
        assertTrue(output.contains("Cannot draw " + SHAPE_NAME + " shape!"));
    }

    @Test
    void equalsShouldReturnTrueForTheSameObject() {
        assertEquals(testShape, new NullShape(SHAPE_NAME));
    }

    @Test
    void equalsShouldReturnFalseForDifferentObject() {
        assertNotEquals(testShape, new NullShape("different"));
    }

    @Test
    void hashCodeShouldReturnCorrectValue() {
        assertEquals(329147807, testShape.hashCode());
    }
}