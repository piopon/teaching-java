package pl.smtc.patterns.creational.factory.method.product;

import org.junit.jupiter.api.Test;
import pl.smtc.base.BaseTestOut;
import pl.smtc.patterns.creational.factory.method.factory.Lamps;

import static org.junit.jupiter.api.Assertions.*;

class WallLampTest extends BaseTestOut {
    private WallLamp wallLamp;

    @Override
    protected void setUp() {
        wallLamp = new WallLamp("TEST_MOUNT", "TEST_SUPPLY");
    }

    @Test
    void powerOnShouldInvokePowerOnAlgorithmAndOutputCorrectMessage() {
        wallLamp.power(true);
        String output = getOutput();
        assertTrue(output.contains("WALL LAMP -> POWER ON"));
    }

    @Test
    void powerOffShouldInvokePowerOffAlgorithmAndOutputCorrectMessage() {
        wallLamp.power(false);
        String output = getOutput();
        assertTrue(output.contains("WALL LAMP -> POWER OFF"));
    }

    @Test
    void getDescriptionShouldReturnCorrectString() {
        String description = wallLamp.getDescription();
        assertTrue(description.contains(" WALL LAMP - "));
        assertTrue(description.contains("mount: TEST_MOUNT, power: TEST_SUPPLY, protect: "));
    }

    @Test
    void setCaseShouldUpdateCase() {
        wallLamp.setCase("IP_50","ORANGE");
        String description = wallLamp.getDescription();
        assertTrue(description.contains("ORANGE WALL LAMP - "));
        assertTrue(description.contains("mount: TEST_MOUNT, power: TEST_SUPPLY, protect: IP_50"));
    }

    @Test
    void getTypeShouldReturnLampsCeilingType() {
        assertEquals(Lamps.WALL, wallLamp.getType());
    }
}