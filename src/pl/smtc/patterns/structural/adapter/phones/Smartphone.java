package pl.smtc.patterns.structural.adapter.phones;

import pl.smtc.patterns.structural.adapter.chargers.UsbChargeable;

public class Smartphone extends Phone implements UsbChargeable {

    public Smartphone(String model) {
        super(model.toUpperCase(), 70.0, "LTE");
    }

    public void www(String url) {
        if (getBattery() > 0.0) {
            System.out.println(getName() + " - showing www page: " + url);
            updateBattery(-40.0);
        } else {
            System.out.println(getName() + " - battery empty. Charge it.");
        }
    }

    @Override
    public void chargeUsb() {
        System.out.println(getName() + " - USB general standard plug inputted. Charging...");
        updateBattery(50.0);
    }
}
