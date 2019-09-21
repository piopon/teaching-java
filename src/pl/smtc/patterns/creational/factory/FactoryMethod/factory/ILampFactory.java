package pl.smtc.patterns.creational.factory.FactoryMethod.factory;

import pl.smtc.patterns.creational.factory.FactoryMethod.product.Lamp;

public interface ILampFactory {
    void registerLamp(Lamp lamp);

    String getRegisteredLamps();

    String getName();

    Lamp createLamp(Lamps type) throws NullPointerException;
}
