package pl.smtc.patterns.creational.SimpleFactory.product;

import org.junit.jupiter.api.Test;
import pl.smtc.patterns.creational.SimpleFactory.factory.Lamps;

import static org.junit.jupiter.api.Assertions.*;

class DesktopLampTest {
    private static final String TEST_MOUNTING = "test_mount";
    private static final String TEST_SUPPLY = "test_supply";
    private DesktopLamp desktopLamp = new DesktopLamp(TEST_MOUNTING, TEST_SUPPLY);

    @Test
    void getDescriptionShouldReturnDesktopLampDescriptionString() {
        String details = "[mount: " + TEST_MOUNTING + ", power supply: " + TEST_SUPPLY + "]";
        assertEquals("DESKTOP LAMP " + details, desktopLamp.getDescription());
    }

    @Test
    void getTypeShouldReturnDesktopLampType() {
        assertEquals(Lamps.DESKTOP, desktopLamp.getType());
    }
}