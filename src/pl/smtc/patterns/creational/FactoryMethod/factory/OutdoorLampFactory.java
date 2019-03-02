package pl.smtc.patterns.creational.FactoryMethod.factory;

import pl.smtc.patterns.creational.FactoryMethod.product.Lamp;

import java.util.HashMap;
import java.util.Map;

public class OutdoorLampFactory implements ILampFactory {
    protected Map<Lamps, Lamp> registeredLamps = new HashMap<>();

    @Override
    public void registerLamp(Lamp lamp) {
        registeredLamps.put(lamp.getType(), lamp);
    }

    @Override
    public String getRegisteredLamps() {
        return registeredLamps.keySet().toString();
    }

    @Override
    public String getName() {
        return "OUTDOOR LAMP FACTORY";
    }

    @Override
    public Lamp createLamp(Lamps type) throws NullPointerException {
        Lamp created = registeredLamps.get(type);
        created.setCase("IP67", "BLACK");

        return created;
    }
}
