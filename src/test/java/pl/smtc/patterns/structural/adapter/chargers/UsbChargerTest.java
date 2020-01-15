package pl.smtc.patterns.structural.adapter.chargers;

import org.junit.jupiter.api.Test;
import pl.smtc.base.BaseTestOut;

import static org.junit.jupiter.api.Assertions.*;

class UsbChargerTest extends BaseTestOut {
    private final static String CHARGE_STRING = "Test chargeUsb method called!";
    private UsbChargeable testChargeable = () -> System.out.println(CHARGE_STRING);
    private UsbCharger testCharger;

    @Override
    protected void setUp() {
        testCharger = new UsbCharger();
    }

    @Test
    void chargeShouldInvokeChargeUsbMethodFromChargeable() {
        testCharger.charge(testChargeable);
        String output = getOutput();
        assertTrue(output.equalsIgnoreCase(CHARGE_STRING + System.lineSeparator()));
    }
}