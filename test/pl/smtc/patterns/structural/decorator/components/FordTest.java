package pl.smtc.patterns.structural.decorator.components;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FordTest {
    private final static double TEST_PRICE = 80_000.00;
    private final static String TEST_MODEL = "Fiesta RC";
    private Ford ford = new Ford(TEST_MODEL, TEST_PRICE);

    @Test
    void getNameShouldReturnFordAndInputtedModel() {
        assertEquals("Ford " + TEST_MODEL, ford.getName());
    }

    @Test
    void getPriceShouldReturnCarPrice() {
        assertEquals(TEST_PRICE, ford.getPrice());
    }
}