package pl.smtc.patterns.structural.adapter.phones;

import pl.smtc.patterns.structural.adapter.chargers.VendorChargeable;
import pl.smtc.patterns.structural.adapter.phones.Phone;

public class Cellphone extends Phone implements VendorChargeable {

    public Cellphone(String model) {
        super(model.toUpperCase(), 35.0, "EDGE");
    }

    @Override
    public void charge() {
        System.out.println(getName() + " - cellphone vendor plug inputted. Charging...");
        updateBattery(50.0);
    }
}
