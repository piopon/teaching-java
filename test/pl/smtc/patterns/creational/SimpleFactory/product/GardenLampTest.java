package pl.smtc.patterns.creational.SimpleFactory.product;

import org.junit.jupiter.api.Test;
import pl.smtc.patterns.creational.SimpleFactory.factory.Lamps;

import static org.junit.jupiter.api.Assertions.*;

class GardenLampTest {
    private static final String TEST_MOUNTING = "test_mount";
    private static final String TEST_SUPPLY = "test_supply";
    private GardenLamp gardenLamp = new GardenLamp(TEST_MOUNTING, TEST_SUPPLY);

    @Test
    void getDescriptionShouldReturnGardenLampDescriptionString() {
        String details = "[mount: " + TEST_MOUNTING + ", power supply: " + TEST_SUPPLY + "]";
        assertEquals("GARDEN LAMP " + details, gardenLamp.getDescription());
    }

    @Test
    void getTypeShouldReturnGardenLampType() {
        assertEquals(Lamps.GARDEN, gardenLamp.getType());
    }
}