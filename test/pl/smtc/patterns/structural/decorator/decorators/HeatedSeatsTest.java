package pl.smtc.patterns.structural.decorator.decorators;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.smtc.patterns.structural.decorator.components.Car;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class HeatedSeatsTest {
    private final static double CAR_PRICE = 100_000.0;
    private final static String CAR_NAME = "Mock car";
    private HeatedSeats heatedSeats;

    @BeforeEach
    void setup() {
        Car carMock = mock(Car.class);
        when(carMock.getName()).thenReturn(CAR_NAME);
        when(carMock.getPrice()).thenReturn(CAR_PRICE);
        heatedSeats = new HeatedSeats(carMock);
    }

    @Test
    void getPriceShouldReturnCarPriceIncreasedByOptionPrice() {
        assertEquals(CAR_PRICE + 10_000.0, heatedSeats.getPrice());
    }

    @Test
    void getNameShouldReturnCarNamePlusOptionName() {
        assertEquals(CAR_NAME + " + HEATED SEATS", heatedSeats.getName());
    }
}