package pl.smtc.patterns.creational.factory.FactoryMethod.product;

import org.junit.jupiter.api.Test;
import pl.smtc.base.BaseTestOut;
import pl.smtc.patterns.creational.factory.FactoryMethod.factory.Lamps;

import static org.junit.jupiter.api.Assertions.*;

class StreetLampTest extends BaseTestOut {
    private StreetLamp streetLamp;

    @Override
    protected void setUp() {
        streetLamp = new StreetLamp("TEST_MOUNT", "TEST_SUPPLY");
    }

    @Test
    void powerOnShouldInvokePowerOnAlgorithmAndOutputCorrectMessage() {
        streetLamp.power(true);
        String output = getOutput();
        assertTrue(output.contains("STREET LAMP: POWER ON = WARMING UP..."));
    }

    @Test
    void powerOffShouldInvokePowerOffAlgorithmAndOutputCorrectMessage() {
        streetLamp.power(false);
        String output = getOutput();
        assertTrue(output.contains("STREET LAMP: POWER OFF = COOLING DOWN..."));
    }

    @Test
    void getDescriptionShouldReturnCorrectString() {
        String description = streetLamp.getDescription();
        assertTrue(description.contains(" STREET LAMP - "));
        assertTrue(description.contains("mount: TEST_MOUNT, power: TEST_SUPPLY, protect: "));
    }

    @Test
    void setCaseShouldUpdateCase() {
        streetLamp.setCase("IP_TEST","KHAKI");
        String description = streetLamp.getDescription();
        assertTrue(description.contains("KHAKI STREET LAMP - "));
        assertTrue(description.contains("mount: TEST_MOUNT, power: TEST_SUPPLY, protect: IP_TEST"));
    }

    @Test
    void getTypeShouldReturnLampsCeilingType() {
        assertEquals(Lamps.STREET, streetLamp.getType());
    }
}