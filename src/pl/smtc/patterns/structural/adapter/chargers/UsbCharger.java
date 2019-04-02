package pl.smtc.patterns.structural.adapter.chargers;

public class UsbCharger {
    public void charge(UsbChargeable phone) {
        phone.chargeUsb();
    }
}
