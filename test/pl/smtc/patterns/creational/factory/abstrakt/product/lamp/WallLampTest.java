package pl.smtc.patterns.creational.factory.abstrakt.product.lamp;

import org.junit.jupiter.api.Test;
import pl.smtc.base.BaseTestOut;
import pl.smtc.patterns.creational.factory.abstrakt.product.mount.DowelsMounting;
import pl.smtc.patterns.creational.factory.abstrakt.product.mount.Mounting;
import pl.smtc.patterns.creational.factory.abstrakt.product.source.NeonSource;
import pl.smtc.patterns.creational.factory.abstrakt.product.source.Source;

import static org.junit.jupiter.api.Assertions.*;

class WallLampTest extends BaseTestOut {
    private static final int TEST_LIGHT = 4000;
    private static final String TEST_COLOR = "Red";
    private static final String TEST_IP = "IP1234";
    private static final Source TEST_SOURCE = new NeonSource(TEST_LIGHT);
    private static final Mounting TEST_MOUNT = new DowelsMounting();
    private WallLamp testLamp;

    @Override
    protected void setUp() {
        testLamp = new WallLamp(TEST_COLOR);
    }

    @Test
    void powerOnShouldReturnFalseAndOutputOnStatusWithErrorWhenNoSourceAdded() {
        assertFalse(testLamp.power(true));
        String output = getOutput();
        assertTrue(output.contains("************"));
        assertTrue(output.contains("WALL LAMP - POWER ON"));
        assertTrue(output.contains("Error: no light source equipped."));
    }

    @Test
    void powerOffShouldReturnFalseAndOutputOffStatusWithErrorWhenNoSourceAdded() {
        assertFalse(testLamp.power(false));
        String output = getOutput();
        assertTrue(output.contains("************"));
        assertTrue(output.contains("WALL LAMP - POWER OFF"));
        assertTrue(output.contains("Error: no light source equipped."));
    }

    @Test
    void powerOnShouldReturnTrueAndOutputOnStatusWithSourceDescription() {
        testLamp.setSource(TEST_SOURCE);
        assertTrue(testLamp.power(true));
        String output = getOutput();
        assertTrue(output.contains("************"));
        assertTrue(output.contains("WALL LAMP - POWER ON"));
        assertTrue(output.contains(TEST_SOURCE.getType() + " SOURCE - " + TEST_LIGHT + "[K]"));
    }

    @Test
    void powerOffShouldReturnTrueAndOutputOffStatusWithSourceDescription() {
        testLamp.setSource(TEST_SOURCE);
        assertTrue(testLamp.power(false));
        String output = getOutput();
        assertTrue(output.contains("************"));
        assertTrue(output.contains("WALL LAMP - POWER OFF"));
        assertTrue(output.contains(TEST_SOURCE.getType() + " SOURCE - " + TEST_LIGHT + "[K]"));
    }

    @Test
    void setMountingShouldUpdateMountingVariable() {
        testLamp.setMounting(TEST_MOUNT);
        assertTrue(testLamp.getDescription().contains("mount with: " + TEST_MOUNT.getDescription()));
    }

    @Test
    void setSourceShouldUpdateSourceVariable() {
        testLamp.setSource(TEST_SOURCE);
        assertTrue(testLamp.getDescription().contains("light source: " + TEST_SOURCE.getDescription()));
    }

    @Test
    void getDescriptionShouldReturnRawDescriptionStringWhenNoDataUpdated() {
        String expected = TEST_COLOR + " WALL LAMP [null] - mount with: error, light source: error";
        assertEquals(expected, testLamp.getDescription());
    }

    @Test
    void getDescriptionShouldReturnCorrectDescription() {
        testLamp.setSource(TEST_SOURCE);
        testLamp.setMounting(TEST_MOUNT);
        testLamp.setCaseProtection(TEST_IP);
        String info = "mount with: " + TEST_MOUNT.getDescription() + ", light source: " + TEST_SOURCE.getDescription();
        String expected = TEST_COLOR + " WALL LAMP [" + TEST_IP + "] - " + info;
        assertEquals(expected, testLamp.getDescription());
    }

    @Test
    void getTypeShouldReturnWallLampType() {
        assertEquals(ELamp.WALL, testLamp.getType());
    }

    @Test
    void setCaseProtectionShouldUpdateCaseProtection() {
        testLamp.setCaseProtection(TEST_IP);
        assertTrue(testLamp.getDescription().contains("[" + TEST_IP + "]"));
    }

    @Test
    void mountShouldReturnFalseAndOutputErrorWhenNoMountingIsSet() {
        assertFalse(testLamp.mount());
        String output = getOutput();
        assertTrue(output.contains("Error: no mounting elements equipped with lamp."));
    }

    @Test
    void mountShouldReturnTrueAndOutputMountInstructionWhenMountingIsSet() {
        testLamp.setMounting(TEST_MOUNT);
        assertTrue(testLamp.mount());
        String output = getOutput();
        assertTrue(output.contains("************"));
        assertTrue(output.contains("WALL LAMP - MOUNT INSTRUCTIONS"));
        assertTrue(output.contains("Requires: medium size ladder"));
        assertTrue(output.contains("Tools: " + TEST_MOUNT.getTools()));
    }
}