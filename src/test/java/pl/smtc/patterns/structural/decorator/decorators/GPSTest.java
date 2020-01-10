package pl.smtc.patterns.structural.decorator.decorators;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.smtc.patterns.structural.decorator.components.Car;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class GPSTest {
    private final static double CAR_PRICE = 100_000.0;
    private final static String CAR_NAME = "Mock car";
    private GPS gps;

    @BeforeEach
    void setup() {
        Car carMock = mock(Car.class);
        when(carMock.getName()).thenReturn(CAR_NAME);
        when(carMock.getPrice()).thenReturn(CAR_PRICE);
        gps = new GPS(carMock);
    }

    @Test
    void getPriceShouldReturnCarPriceIncreasedByOptionPrice() {
        assertEquals(CAR_PRICE + 3_000.0, gps.getPrice());
    }

    @Test
    void getNameShouldReturnCarNamePlusOptionName() {
        assertEquals(CAR_NAME + " + GPS", gps.getName());
    }
}