package pl.smtc.patterns.creational.factory.abstrakt.support;

import pl.smtc.patterns.creational.factory.abstrakt.factory.IndoorLampFactory;
import pl.smtc.patterns.creational.factory.abstrakt.factory.LampFactory;
import pl.smtc.patterns.creational.factory.abstrakt.factory.OutdoorLampFactory;
import pl.smtc.patterns.creational.factory.abstrakt.product.lamp.*;
import pl.smtc.patterns.creational.factory.abstrakt.product.mount.*;
import pl.smtc.patterns.creational.factory.abstrakt.product.source.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FactoriesDataProvider {
    private List<LampFactory> lampFactories = new ArrayList<>();

    public FactoriesDataProvider() {
        registerIndoorProducts();
        registerOutdoorProducts();
    }

    public String getFactoryNames() {
        return lampFactories.stream()
                .map(LampFactory::getName)
                .collect(Collectors.joining(", "));
    }

    public LampFactory getFactory(String name) {
        return lampFactories.stream()
                .filter(factory -> factory.getName().contains(name))
                .findFirst()
                .orElse(null);
    }

    private void registerIndoorProducts() {
        LampFactory indoorFactory = new IndoorLampFactory();
        registerLamps(indoorFactory, new CeilingLamp("RED"),
                new DesktopLamp("BLUE"), new WallLamp("GREEN"));
        registerMountings(indoorFactory, new ScrewsMounting(),
                new DowelsMounting(), new StandMounting());
        registerSources(indoorFactory, new LedSource(3000),
                new FluorescentSource(5000), new CdmSource(3200));
        lampFactories.add(indoorFactory);
    }

    private void registerOutdoorProducts() {
        LampFactory outdoorFactory = new OutdoorLampFactory();
        registerLamps(outdoorFactory, new GardenLamp("BLACK"),
                new StreetLamp("SILVER"), new WallLamp("WHITE"));
        registerMountings(outdoorFactory, new ScrewsMounting(),
                new AnchorsMounting(), new SpikeMounting());
        registerSources(outdoorFactory, new LedSource(3000),
                new HmiSource(3500), new NeonSource(4500));
        lampFactories.add(outdoorFactory);
    }

    private void registerLamps(LampFactory factory, Lamp... lamps) {
        for (Lamp lamp : lamps) {
            factory.registerLamp(lamp);
        }
    }

    private void registerMountings(LampFactory factory, Mounting... mountings) {
        for (Mounting mounting: mountings) {
            factory.registerMounting(mounting);
        }
    }

    private void registerSources(LampFactory factory, Source... sources) {
        for (Source source : sources) {
            factory.registerSource(source);
        }
    }
}
