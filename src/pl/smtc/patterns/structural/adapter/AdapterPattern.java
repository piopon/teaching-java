package pl.smtc.patterns.structural.adapter;

import pl.smtc.menu.ConsoleExample;
import pl.smtc.patterns.structural.adapter.adapters.UsbToVendorPlug;
import pl.smtc.patterns.structural.adapter.chargers.UsbCharger;
import pl.smtc.patterns.structural.adapter.phones.Cellphone;
import pl.smtc.patterns.structural.adapter.phones.Smartphone;

public class AdapterPattern implements ConsoleExample {
    @Override
    public void execute() {
        UsbCharger charger = new UsbCharger();

        Smartphone samsung = new Smartphone("Samsung Galaxy S7");
        samsung.www("google.com");
        samsung.call("600-000-001");
        samsung.text("823-100-100", "Hello");
        charger.charge(samsung);

        Cellphone nokia = new Cellphone("Nokia 3310");
        nokia.call("512-123-456");
        nokia.text("601-111-111", "Buy milk");
        charger.charge(new UsbToVendorPlug(nokia));
    }

    @Override
    public String getName() {
        return "Adapter pattern";
    }
}
