package pl.smtc.patterns.creational.FactoryMethod.product;

import org.junit.jupiter.api.Test;
import pl.smtc.base.BaseTestOut;
import pl.smtc.patterns.creational.FactoryMethod.factory.Lamps;

import static org.junit.jupiter.api.Assertions.*;

class CeilingLampTest extends BaseTestOut {
    private CeilingLamp ceilingLamp;

    @Override
    protected void setUp() {
        ceilingLamp = new CeilingLamp("TEST_MOUNT", "TEST_SUPPLY");
    }

    @Test
    void powerOnShouldInvokePowerOnAlgorithmAndOutputCorrectMessage() {
        ceilingLamp.power(true);
        String output = getOutput();
        assertTrue(output.contains("CEILING FLUORESCENT LAMP -> POWER ON"));
    }

    @Test
    void powerOffShouldInvokePowerOffAlgorithmAndOutputCorrectMessage() {
        ceilingLamp.power(false);
        String output = getOutput();
        assertTrue(output.contains("CEILING FLUORESCENT LAMP -> POWER OFF"));
    }

    @Test
    void getDescriptionShouldReturnCorrectString() {
        String description = ceilingLamp.getDescription();
        assertTrue(description.contains(" CEILING LAMP - "));
        assertTrue(description.contains("mount: TEST_MOUNT, power: TEST_SUPPLY, protect: "));
    }

    @Test
    void setCaseShouldUpdateCase() {
        ceilingLamp.setCase("IP_TEST","YELLOW");
        String description = ceilingLamp.getDescription();
        assertTrue(description.contains("YELLOW CEILING LAMP - "));
        assertTrue(description.contains("mount: TEST_MOUNT, power: TEST_SUPPLY, protect: IP_TEST"));
    }

    @Test
    void getTypeShouldReturnLampsCeilingType() {
        assertEquals(Lamps.CEILING, ceilingLamp.getType());
    }
}