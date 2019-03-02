package pl.smtc.patterns.creational.FactoryMethod.factory;

import pl.smtc.patterns.creational.FactoryMethod.product.Lamp;

public interface ILampFactory {
    void registerLamp(Lamp lamp);

    String getRegisteredLamps();

    String getName();

    Lamp createLamp(Lamps type) throws NullPointerException;
}
