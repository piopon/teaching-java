package pl.smtc.patterns.creational.factory.simple.product;

import org.junit.jupiter.api.Test;
import pl.smtc.patterns.creational.factory.simple.factory.Lamps;

import static org.junit.jupiter.api.Assertions.*;

class StreetLampTest {
    private static final String TEST_MOUNTING = "test_mount";
    private static final String TEST_SUPPLY = "test_supply";
    private StreetLamp streetLamp = new StreetLamp(TEST_MOUNTING, TEST_SUPPLY);

    @Test
    void getDescriptionShouldReturnStreetLampDescriptionString() {
        String details = "[mount: " + TEST_MOUNTING + ", power supply: " + TEST_SUPPLY + "]";
        assertEquals("STREET LAMP " + details, streetLamp.getDescription());
    }

    @Test
    void getTypeShouldReturnStreetLampType() {
        assertEquals(Lamps.STREET, streetLamp.getType());
    }
}