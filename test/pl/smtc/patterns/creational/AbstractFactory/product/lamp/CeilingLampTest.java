package pl.smtc.patterns.creational.AbstractFactory.product.lamp;

import org.junit.jupiter.api.Test;
import pl.smtc.base.BaseTestOut;
import pl.smtc.patterns.creational.AbstractFactory.product.mount.Mounting;
import pl.smtc.patterns.creational.AbstractFactory.product.mount.ScrewsMounting;
import pl.smtc.patterns.creational.AbstractFactory.product.source.LedSource;
import pl.smtc.patterns.creational.AbstractFactory.product.source.Source;

import static org.junit.jupiter.api.Assertions.*;

class CeilingLampTest extends BaseTestOut {
    private static final int TEST_LIGHT = 4000;
    private static final String TEST_COLOR = "Red";
    private static final String TEST_IP = "IP1234";
    private static final Source TEST_SOURCE = new LedSource(TEST_LIGHT);
    private static final Mounting TEST_MOUNT = new ScrewsMounting();
    private CeilingLamp testLamp;

    @Override
    protected void setUp() {
        testLamp = new CeilingLamp(TEST_COLOR);
    }

    @Test
    void powerOnShouldReturnFalseAndOutputOnStatusWithErrorWhenNoSourceAdded() {
        assertFalse(testLamp.power(true));
        String output = getOutput();
        assertTrue(output.contains("************"));
        assertTrue(output.contains("CEILING LAMP - POWER ON"));
        assertTrue(output.contains("Error: no light source equipped."));
    }

    @Test
    void powerOffShouldReturnFalseAndOutputOffStatusWithErrorWhenNoSourceAdded() {
        assertFalse(testLamp.power(false));
        String output = getOutput();
        assertTrue(output.contains("************"));
        assertTrue(output.contains("CEILING LAMP - POWER OFF"));
        assertTrue(output.contains("Error: no light source equipped."));
    }

    @Test
    void powerOnShouldReturnTrueAndOutputOnStatusWithSourceDescription() {
        testLamp.setSource(TEST_SOURCE);
        assertTrue(testLamp.power(true));
        String output = getOutput();
        assertTrue(output.contains("************"));
        assertTrue(output.contains("CEILING LAMP - POWER ON"));
        assertTrue(output.contains(TEST_SOURCE.getType() + " SOURCE - " + TEST_LIGHT + "[K]"));
    }

    @Test
    void powerOffShouldReturnTrueAndOutputOffStatusWithSourceDescription() {
        testLamp.setSource(TEST_SOURCE);
        assertTrue(testLamp.power(false));
        String output = getOutput();
        assertTrue(output.contains("************"));
        assertTrue(output.contains("CEILING LAMP - POWER OFF"));
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
        String expected = TEST_COLOR + " CEILING LAMP [null] - mount with: error, light source: error";
        assertEquals(expected, testLamp.getDescription());
    }

    @Test
    void getDescriptionShouldReturnCorrectDescription() {
        testLamp.setSource(TEST_SOURCE);
        testLamp.setMounting(TEST_MOUNT);
        testLamp.setCaseProtection(TEST_IP);
        String info = "mount with: " + TEST_MOUNT.getDescription() + ", light source: " + TEST_SOURCE.getDescription();
        String expected = TEST_COLOR + " CEILING LAMP [" + TEST_IP + "] - " + info;
        assertEquals(expected, testLamp.getDescription());
    }

    @Test
    void getTypeShouldReturnCeilingLampType() {
        assertEquals(ELamp.CEILING, testLamp.getType());
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
        assertTrue(output.contains("CEILING LAMP - MOUNT INSTRUCTIONS"));
        assertTrue(output.contains("Requires: tall ladder, box for elements"));
        assertTrue(output.contains("Tools: " + TEST_MOUNT.getTools()));
    }
}