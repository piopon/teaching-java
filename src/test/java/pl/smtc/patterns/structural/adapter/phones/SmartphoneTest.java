package pl.smtc.patterns.structural.adapter.phones;

import org.junit.jupiter.api.Test;
import pl.smtc.base.BaseTestOut;

import static org.junit.jupiter.api.Assertions.*;

class SmartphoneTest extends BaseTestOut {
    private final static String TEST_MODEL = "Sony Ultra-NEW";
    private Smartphone smartphone;

    @Override
    protected void setUp() {
        smartphone = new Smartphone(TEST_MODEL);
    }

    @Test
    void wwwShouldInvokeSmartphoneWwwMethodIfBatteryIsPresent() {
        String url = "www.test.url";
        smartphone.www(url);
        String output = getOutput();
        assertTrue(output.contains(TEST_MODEL.toUpperCase() + " - showing www page: " + url));
    }

    @Test
    void wwwShouldReturnChargeWarningIfNoBatteryLeft() {
        String url = "www.test.url";
        smartphone.updateBattery(-100.0);
        smartphone.www(url);
        String output = getOutput();
        assertTrue(output.contains(TEST_MODEL.toUpperCase() + " - battery empty. Charge it."));
    }

    @Test
    void chargeUsbShouldInvokeChargingMethodAndUpdateBatteryState() {
        smartphone.chargeUsb();
        String output = getOutput();
        assertTrue(output.contains(TEST_MODEL.toUpperCase() + " - USB general standard plug inputted. Charging..."));
        assertEquals(100.0, smartphone.getBattery());
    }

    @Test
    void callShouldInvokeSmartphoneCallMethodIfBatteryIsPresent() {
        String number = "(+48) 601 601 601";
        smartphone.call(number);
        String output = getOutput();
        assertTrue(output.contains(TEST_MODEL.toUpperCase() + " - calling number: " + number + " [LTE]"));
    }

    @Test
    void callShouldReturnChargeWarningIfNoBatteryLeft() {
        String number = "(+48) 601 601 601";
        smartphone.updateBattery(-100.0);
        smartphone.call(number);
        String output = getOutput();
        assertTrue(output.contains(TEST_MODEL.toUpperCase() + " - battery empty. Charge it."));
    }

    @Test
    void textShouldInvokeSmartphoneTextMethodIfBatteryIsPresent() {
        String number = "(+48) 601 601 601";
        String message = "TEST";
        smartphone.text(number, message);
        String output = getOutput();
        assertTrue(output.contains(TEST_MODEL.toUpperCase() + " - sending text: \"" + message + "\" to: " + number));
    }

    @Test
    void textShouldReturnChargeWarningIfNoBatteryLeft() {
        String number = "(+48) 601 601 601";
        String message = "TEST";
        smartphone.updateBattery(-100.0);
        smartphone.text(number, message);
        String output = getOutput();
        assertTrue(output.contains(TEST_MODEL.toUpperCase() + " - battery empty. Charge it."));
    }


    @Test
    void getNameShouldReturnSmartphoneModelName() {
        assertEquals(TEST_MODEL.toUpperCase(), smartphone.getName());
    }

    @Test
    void getBatteryShouldReturnCorrectAmountOfBatteryLeft() {
        assertEquals(70.0, smartphone.getBattery());
    }

    @Test
    void updateBatteryShouldDecreaseBatteryIfNegativeNumberInputted() {
        smartphone.updateBattery(-15.0);
        assertEquals(55.0, smartphone.getBattery());
    }

    @Test
    void updateBatteryShouldReturnZeroIfBigNegativeNumberInputted() {
        smartphone.updateBattery(-150.0);
        assertEquals(0.0, smartphone.getBattery());
    }

    @Test
    void updateBatteryShouldIncreaseBatteryIfPositiveNumberInputted() {
        smartphone.updateBattery(15.0);
        assertEquals(85.0, smartphone.getBattery());
    }

    @Test
    void updateBatteryShouldReturnHundredIfBigPositiveNumberInputted() {
        smartphone.updateBattery(150.0);
        assertEquals(100.0, smartphone.getBattery());
    }
}