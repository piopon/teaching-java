package pl.smtc.patterns.creational.SimpleFactory.factory;

import pl.smtc.patterns.creational.SimpleFactory.product.ILamp;

import java.util.HashMap;
import java.util.Map;

public class LampFactory {
    public static Map<Lamps, ILamp> availableLamps = new HashMap<>();

    public static void registerLamp(ILamp lamp) {
        availableLamps.put(lamp.getType(), lamp);
    }

    public static String getRegisteredLamps() {
        return availableLamps.keySet().toString();
    }

    public static ILamp createLamp(Lamps type) {
        return availableLamps.get(type);
    }

    public static void clearRegisteredLamps() {
        availableLamps.clear();
    }
}
