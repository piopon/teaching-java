package pl.smtc.patterns.creational.factory.FactoryMethod.product;

import org.junit.jupiter.api.Test;
import pl.smtc.base.BaseTestOut;
import pl.smtc.patterns.creational.factory.FactoryMethod.factory.Lamps;

import static org.junit.jupiter.api.Assertions.*;

class DesktopLampTest extends BaseTestOut {
    private DesktopLamp desktopLamp;

    @Override
    protected void setUp() {
        desktopLamp = new DesktopLamp("TEST_MOUNT", "TEST_SUPPLY");
    }

    @Test
    void powerOnShouldInvokePowerOnAlgorithmAndOutputCorrectMessage() {
        desktopLamp.power(true);
        String output = getOutput();
        assertTrue(output.contains("DESKTOP LAMP: WARM 2700K LED -> POWER ON"));
    }

    @Test
    void powerOffShouldInvokePowerOffAlgorithmAndOutputCorrectMessage() {
        desktopLamp.power(false);
        String output = getOutput();
        assertTrue(output.contains("DESKTOP LAMP: WARM 2700K LED -> POWER OFF"));
    }

    @Test
    void getDescriptionShouldReturnCorrectString() {
        String description = desktopLamp.getDescription();
        assertTrue(description.contains(" DESKTOP LAMP - "));
        assertTrue(description.contains("mount: TEST_MOUNT, power: TEST_SUPPLY, protect: "));
    }

    @Test
    void setCaseShouldUpdateCase() {
        desktopLamp.setCase("IP_100","BLUE");
        String description = desktopLamp.getDescription();
        assertTrue(description.contains("BLUE DESKTOP LAMP - "));
        assertTrue(description.contains("mount: TEST_MOUNT, power: TEST_SUPPLY, protect: IP_100"));
    }

    @Test
    void getTypeShouldReturnLampsCeilingType() {
        assertEquals(Lamps.DESKTOP, desktopLamp.getType());
    }
}