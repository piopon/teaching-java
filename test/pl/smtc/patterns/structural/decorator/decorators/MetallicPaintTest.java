package pl.smtc.patterns.structural.decorator.decorators;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.smtc.patterns.structural.decorator.components.Car;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class MetallicPaintTest {
    private final static double CAR_PRICE = 100_000.0;
    private final static String CAR_NAME = "Mock car";
    private MetallicPaint metallicPaint;

    @BeforeEach
    void setup() {
        Car carMock = mock(Car.class);
        when(carMock.getName()).thenReturn(CAR_NAME);
        when(carMock.getPrice()).thenReturn(CAR_PRICE);
        metallicPaint = new MetallicPaint(carMock);
    }

    @Test
    void getPriceShouldReturnCarPriceIncreasedByOptionPrice() {
        assertEquals(CAR_PRICE + 8_500.0, metallicPaint.getPrice());
    }

    @Test
    void getNameShouldReturnCarNamePlusOptionName() {
        assertEquals(CAR_NAME + " + METALLIC PAINT", metallicPaint.getName());
    }
}