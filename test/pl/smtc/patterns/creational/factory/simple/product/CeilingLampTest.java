package pl.smtc.patterns.creational.factory.simple.product;

import org.junit.jupiter.api.Test;
import pl.smtc.patterns.creational.factory.simple.factory.Lamps;

import static org.junit.jupiter.api.Assertions.*;

class CeilingLampTest {
    private static final String TEST_MOUNTING = "test_mount";
    private static final String TEST_SUPPLY = "test_supply";
    private CeilingLamp ceilingLamp = new CeilingLamp(TEST_MOUNTING, TEST_SUPPLY);

    @Test
    void getDescriptionShouldReturnCeilingLampDescriptionString() {
        String details = "[mount: " + TEST_MOUNTING + ", power supply: " + TEST_SUPPLY + "]";
        assertEquals("CEILING LAMP " + details, ceilingLamp.getDescription());
    }

    @Test
    void getTypeShouldReturnCeilingLampType() {
        assertEquals(Lamps.CEILING, ceilingLamp.getType());
    }
}