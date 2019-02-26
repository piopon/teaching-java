package pl.smtc.patterns.structural.decorator.components;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ToyotaTest {
    private final static double TEST_PRICE = 72_123.99;
    private final static String TEST_MODEL = "Corolla Verso";
    private Toyota toyota = new Toyota(TEST_MODEL, TEST_PRICE);

    @Test
    void getNameShouldReturnToyotaAndInputtedModel() {
        assertEquals("Toyota " + TEST_MODEL, toyota.getName());
    }

    @Test
    void getPriceShouldReturnCarPrice() {
        assertEquals(TEST_PRICE, toyota.getPrice());
    }
}