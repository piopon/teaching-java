package pl.smtc.patterns.structural.adapter.adapters;

import pl.smtc.patterns.structural.adapter.chargers.VendorChargeable;
import pl.smtc.patterns.structural.adapter.chargers.UsbChargeable;

public class UsbToVendorPlug implements UsbChargeable {
    private VendorChargeable vendorOutput;

    public UsbToVendorPlug(VendorChargeable vendorOutput) {
        this.vendorOutput = vendorOutput;
    }

    @Override
    public void chargeUsb() {
        System.out.println("Applying USB -> vendor plug adapter.");
        vendorOutput.charge();
    }
}
