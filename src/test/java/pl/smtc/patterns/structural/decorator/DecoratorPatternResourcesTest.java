package pl.smtc.patterns.structural.decorator;

import org.junit.jupiter.api.Test;
import pl.smtc.base.BaseTestInOut;
import pl.smtc.patterns.structural.decorator.components.Car;
import pl.smtc.patterns.structural.decorator.decorators.CarOption;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class DecoratorPatternResourcesTest extends BaseTestInOut {
    private DecoratorPatternResources testResources;

    @Override
    protected void setUp() {
        testResources = new DecoratorPatternResources();
    }

    @Test
    void createCarsDatabaseReturnsCollectionWithCarsObjects() {
        Map<String, Car> result = testResources.createCarsDatabase();
        assertEquals(3, result.size());
        assertTrue(result.containsKey("Ford Mustang"));
        assertTrue(result.containsKey("Ford Focus"));
        assertTrue(result.containsKey("Toyota RAV4"));
    }

    @Test
    void createOptionsDatabaseReturnsCollectionWithCarOptions() {
        Car mockCar = mock(Car.class);
        Map<String, CarOption> result = testResources.createOptionsDatabase(mockCar);
        assertEquals(4, result.size());
        assertTrue(result.containsKey("GPS"));
        assertTrue(result.containsKey("Heated seats"));
        assertTrue(result.containsKey("Metallic paint"));
        assertTrue(result.containsKey("Sound system"));
    }

    @Test
    void getAbortCommandReturnsCommandEnd() {
        assertEquals("END", testResources.getAbortCommand());
    }

    @Test
    void isAbortCommandReturnsTrueIfEndCommandIsInputted() {
        assertTrue(testResources.isAbortCommand("END"));
    }

    @Test
    void isAbortCommandReturnsFalseIfNotEndCommandIsInputted() {
        assertFalse(testResources.isAbortCommand("ABORT"));
    }
}