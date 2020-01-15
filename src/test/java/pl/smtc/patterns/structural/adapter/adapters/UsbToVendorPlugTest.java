package pl.smtc.patterns.structural.adapter.adapters;

import org.junit.jupiter.api.Test;
import pl.smtc.base.BaseTestOut;
import pl.smtc.patterns.structural.adapter.chargers.VendorChargeable;

import static org.junit.jupiter.api.Assertions.*;

class UsbToVendorPlugTest extends BaseTestOut {
    private final static String CHARGE_STRING = "TEST VENDOR CHARGE METHOD";
    private UsbToVendorPlug testPlug;

    @Override
    protected void setUp() {
        testPlug = new UsbToVendorPlug(() -> System.out.println(CHARGE_STRING));
    }

    @Test
    void chargeUsbShouldUseAdapterAndInvokeVendorChargeMethod() {
        testPlug.chargeUsb();
        String output = getOutput();
        assertTrue(output.contains("Applying USB -> vendor plug adapter."));
        assertTrue(output.contains(CHARGE_STRING));
    }
}