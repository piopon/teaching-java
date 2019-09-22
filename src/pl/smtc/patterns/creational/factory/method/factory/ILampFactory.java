package pl.smtc.patterns.creational.factory.method.factory;

import pl.smtc.patterns.creational.factory.method.product.Lamp;

public interface ILampFactory {
    void registerLamp(Lamp lamp);

    String getRegisteredLamps();

    String getName();

    Lamp createLamp(Lamps type) throws NullPointerException;
}
