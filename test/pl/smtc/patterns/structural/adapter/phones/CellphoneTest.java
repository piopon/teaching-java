package pl.smtc.patterns.structural.adapter.phones;

import org.junit.jupiter.api.Test;
import pl.smtc.base.BaseTestOut;

import static org.junit.jupiter.api.Assertions.*;

class CellphoneTest extends BaseTestOut {
    private final static String TEST_MODEL = "Motorola Old-Model";
    private Cellphone cellphone;

    @Override
    protected void setUp() {
        cellphone = new Cellphone(TEST_MODEL);
    }

    @Test
    void chargeShouldInvokeChargingMethodAndUpdateBatteryState() {
        cellphone.charge();
        String output = getOutput();
        assertTrue(output.contains(TEST_MODEL.toUpperCase() + " - cellphone vendor plug inputted. Charging..."));
        assertEquals(85.0, cellphone.getBattery());
    }

    @Test
    void callShouldInvokeCellphoneCallMethodIfBatteryIsPresent() {
        String number = "(+48) 601 601 601";
        cellphone.call(number);
        String output = getOutput();
        assertTrue(output.contains(TEST_MODEL.toUpperCase() + " - calling number: " + number + " [EDGE]"));
    }

    @Test
    void callShouldReturnChargeWarningIfNoBatteryLeft() {
        String number = "(+48) 601 601 601";
        cellphone.updateBattery(-100.0);
        cellphone.call(number);
        String output = getOutput();
        assertTrue(output.contains(TEST_MODEL.toUpperCase() + " - battery empty. Charge it."));
    }

    @Test
    void textShouldInvokeCellphoneTextMethodIfBatteryIsPresent() {
        String number = "(+48) 601 601 601";
        String message = "TEST";
        cellphone.text(number, message);
        String output = getOutput();
        assertTrue(output.contains(TEST_MODEL.toUpperCase() + " - sending text: \"" + message + "\" to: " + number));
    }

    @Test
    void textShouldReturnChargeWarningIfNoBatteryLeft() {
        String number = "(+48) 601 601 601";
        String message = "TEST";
        cellphone.updateBattery(-100.0);
        cellphone.text(number, message);
        String output = getOutput();
        assertTrue(output.contains(TEST_MODEL.toUpperCase() + " - battery empty. Charge it."));
    }

    @Test
    void getNameShouldReturnCellphoneModelName() {
        assertEquals(TEST_MODEL.toUpperCase(), cellphone.getName());
    }

    @Test
    void getBatteryShouldReturnCorrectAmountOfBatteryLeft() {
        assertEquals(35.0, cellphone.getBattery());
    }

    @Test
    void updateBatteryShouldDecreaseBatteryIfNegativeNumberInputted() {
        cellphone.updateBattery(-15.0);
        assertEquals(20.0, cellphone.getBattery());
    }

    @Test
    void updateBatteryShouldReturnZeroIfBigNegativeNumberInputted() {
        cellphone.updateBattery(-150.0);
        assertEquals(0.0, cellphone.getBattery());
    }

    @Test
    void updateBatteryShouldIncreaseBatteryIfPositiveNumberInputted() {
        cellphone.updateBattery(15.0);
        assertEquals(50.0, cellphone.getBattery());
    }

    @Test
    void updateBatteryShouldReturnHundredIfBigPositiveNumberInputted() {
        cellphone.updateBattery(150.0);
        assertEquals(100.0, cellphone.getBattery());
    }
}