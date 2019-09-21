package pl.smtc.patterns.creational.factory.AbstractFactory.factory;

import pl.smtc.patterns.creational.factory.AbstractFactory.product.lamp.ELamp;
import pl.smtc.patterns.creational.factory.AbstractFactory.product.lamp.Lamp;
import pl.smtc.patterns.creational.factory.AbstractFactory.product.mount.EMounting;
import pl.smtc.patterns.creational.factory.AbstractFactory.product.mount.Mounting;
import pl.smtc.patterns.creational.factory.AbstractFactory.product.source.ESource;
import pl.smtc.patterns.creational.factory.AbstractFactory.product.source.Source;

import java.util.HashMap;
import java.util.Map;

public abstract class LampFactory {
    protected Map<ELamp, Lamp> registeredLamps = new HashMap<>();
    protected Map<EMounting, Mounting> registeredMountings = new HashMap<>();
    protected Map<ESource, Source> registeredSources = new HashMap<>();

    public void registerLamp(Lamp lamp) {
        registeredLamps.put(lamp.getType(), lamp);
    }

    public void registerMounting(Mounting mounting) {
        registeredMountings.put(mounting.getType(), mounting);
    }

    public void registerSource(Source supply) {
        registeredSources.put(supply.getType(), supply);
    }

    public String getRegisteredData(EComponent component) {
        if(component == EComponent.LAMP) {
            return registeredLamps.keySet().toString();
        } else if (component == EComponent.MOUNTING) {
            return registeredMountings.keySet().toString();
        } else if (component == EComponent.SOURCE) {
            return registeredSources.keySet().toString();
        } else {
            return "UNKNOWN COMPONENT";
        }
    }

    public abstract String getName();

    public abstract Lamp createLamp(ELamp lamp) throws NullPointerException;

    public abstract Mounting createMounting(EMounting mounting) throws NullPointerException;

    public abstract Source createSource(ESource source) throws NullPointerException;
}
