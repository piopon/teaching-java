package pl.smtc.patterns.creational.FactoryMethod.factory;

import pl.smtc.patterns.creational.FactoryMethod.product.Lamp;

import java.util.*;

public class IndoorLampFactory implements ILampFactory {
    protected Map<Lamps, Lamp> registeredLamps = new HashMap<>();
    private final static List<String> COLORS = Arrays.asList("WHITE", "GREEN", "BLUE", "RED");

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
        return "INDOOR LAMP FACTORY";
    }

    @Override
    public Lamp createLamp(Lamps type) throws NullPointerException {
        Lamp created = registeredLamps.get(type);
        created.setCase("IP20", getColor());

        return created;
    }

    protected String getColor() {
        return COLORS.get(new Random().nextInt(4));
    }
}
