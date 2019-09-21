package pl.smtc.patterns.creational.factory.AbstractFactory.factory;

import pl.smtc.patterns.creational.factory.AbstractFactory.product.lamp.ELamp;
import pl.smtc.patterns.creational.factory.AbstractFactory.product.lamp.Lamp;
import pl.smtc.patterns.creational.factory.AbstractFactory.product.mount.EMounting;
import pl.smtc.patterns.creational.factory.AbstractFactory.product.mount.Mounting;
import pl.smtc.patterns.creational.factory.AbstractFactory.product.source.ESource;
import pl.smtc.patterns.creational.factory.AbstractFactory.product.source.Source;

public class OutdoorLampFactory extends LampFactory {
    private final static int MOUNTING_ELEMENTS_NO = 8;

    @Override
    public String getName() {
        return "OUTDOOR LAMP FACTORY";
    }

    @Override
    public Lamp createLamp(ELamp lamp) throws NullPointerException {
        Lamp created = registeredLamps.get(lamp);
        created.setCaseProtection("IP67");

        return created;
    }

    @Override
    public Mounting createMounting(EMounting mounting) throws NullPointerException {
        Mounting created = registeredMountings.get(mounting);
        created.setMountElementsNumber(MOUNTING_ELEMENTS_NO);

        return created;
    }

    @Override
    public Source createSource(ESource source) throws NullPointerException {
        Source created = registeredSources.get(source);
        created.setGlassShade("TRANSPARENT");

        return created;
    }
}
