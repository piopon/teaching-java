package pl.smtc.patterns.creational.AbstractFactory.support;

import org.junit.jupiter.api.Test;
import pl.smtc.patterns.creational.AbstractFactory.product.lamp.CeilingLamp;
import pl.smtc.patterns.creational.AbstractFactory.product.lamp.Lamp;

import static org.junit.jupiter.api.Assertions.*;

class ShippingItemTest {
    private static final int TEST_QUANTITY = 100;
    private static final String TEST_FACTORY = "Test Factory";
    private static final Lamp TEST_LAMP = new CeilingLamp("RED");
    private ShippingItem testItem = new ShippingItem(TEST_LAMP, TEST_QUANTITY, TEST_FACTORY);

    @Test
    void getDescriptionShouldReturnCorrectDescription() {
        String expected = TEST_QUANTITY + "x " + TEST_LAMP.getDescription() + " [from: " + TEST_FACTORY + "]";
        assertEquals(expected, testItem.getDescription());
    }

    @Test
    void getLampShouldReturnCorrectLamp() {
        Lamp result = testItem.getLamp();
        assertEquals(TEST_LAMP.getDescription(), result.getDescription());
        assertEquals(TEST_LAMP.getType(), result.getType());
    }
}