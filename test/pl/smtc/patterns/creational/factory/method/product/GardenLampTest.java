package pl.smtc.patterns.creational.factory.method.product;

import org.junit.jupiter.api.Test;
import pl.smtc.base.BaseTestOut;
import pl.smtc.patterns.creational.factory.method.factory.Lamps;

import static org.junit.jupiter.api.Assertions.*;

class GardenLampTest extends BaseTestOut {
    private GardenLamp gardenLamp;

    @Override
    protected void setUp() {
        gardenLamp = new GardenLamp("TEST_MOUNT","TEST_SUPPLY");
    }

    @Test
    void powerOnShouldInvokePowerOnAlgorithmAndOutputCorrectMessage() {
        gardenLamp.power(true);
        String output = getOutput();
        assertTrue(output.contains("GARDEN LAMP: ON [STORED ENERGY: 100.0%]"));
    }

    @Test
    void powerOffShouldInvokePowerOffAlgorithmAndOutputCorrectMessage() {
        gardenLamp.power(false);
        String output = getOutput();
        assertTrue(output.contains("GARDEN LAMP: OFF [STORED ENERGY: 100.0%]"));
    }

    @Test
    void powerOnAndOffShouldDrainStoredEnergyOut() {
        int powerToggles = 5;
        for (int i = 0; i < powerToggles; i++) {
            gardenLamp.power(true);
            gardenLamp.power(false);
        }
        String output = getOutput();
        assertTrue(output.contains("GARDEN LAMP: ON [STORED ENERGY: 100.0%]"));
        assertTrue(output.contains("GARDEN LAMP: OFF [STORED ENERGY: 75.0%]"));
        assertTrue(output.contains("GARDEN LAMP: ON [STORED ENERGY: 75.0%]"));
        assertTrue(output.contains("GARDEN LAMP: OFF [STORED ENERGY: 50.0%]"));
        assertTrue(output.contains("GARDEN LAMP: ON [STORED ENERGY: 50.0%]"));
        assertTrue(output.contains("GARDEN LAMP: OFF [STORED ENERGY: 25.0%]"));
        assertTrue(output.contains("GARDEN LAMP: ON [STORED ENERGY: 25.0%]"));
        assertTrue(output.contains("NO LIGHT - STORED ENERGY: 0.0%"));
    }

    @Test
    void getDescriptionShouldReturnCorrectString() {
        String description = gardenLamp.getDescription();
        assertTrue(description.contains(" GARDEN LAMP - "));
        assertTrue(description.contains("mount: TEST_MOUNT, power: TEST_SUPPLY, protect: "));
    }

    @Test
    void setCaseShouldUpdateCase() {
        gardenLamp.setCase("IP_TEST","LIME");
        String description = gardenLamp.getDescription();
        assertTrue(description.contains("LIME GARDEN LAMP - "));
        assertTrue(description.contains("mount: TEST_MOUNT, power: TEST_SUPPLY, protect: IP_TEST"));
    }

    @Test
    void getTypeShouldReturnLampsCeilingType() {
        assertEquals(Lamps.GARDEN, gardenLamp.getType());
    }
}