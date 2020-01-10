package pl.smtc.patterns.creational.factory.simple.product;

import org.junit.jupiter.api.Test;
import pl.smtc.patterns.creational.factory.simple.factory.Lamps;

import static org.junit.jupiter.api.Assertions.*;

class WallLampTest {
    private static final String TEST_MOUNTING = "test_mount";
    private static final String TEST_SUPPLY = "test_supply";
    private WallLamp wallLamp = new WallLamp(TEST_MOUNTING, TEST_SUPPLY);

    @Test
    void getDescriptionShouldReturnWallLampDescriptionString() {
        String details = "[mount: " + TEST_MOUNTING + ", power supply: " + TEST_SUPPLY + "]";
        assertEquals("WALL LAMP " + details, wallLamp.getDescription());
    }

    @Test
    void getTypeShouldReturnWallLampType() {
        assertEquals(Lamps.WALL, wallLamp.getType());
    }
}