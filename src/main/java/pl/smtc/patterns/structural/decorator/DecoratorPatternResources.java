package pl.smtc.patterns.structural.decorator;

import pl.smtc.patterns.structural.decorator.components.Car;
import pl.smtc.patterns.structural.decorator.components.Ford;
import pl.smtc.patterns.structural.decorator.components.Toyota;
import pl.smtc.patterns.structural.decorator.decorators.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DecoratorPatternResources {
    private static final String ABORT_COMMAND = "END";

    public Map<String, Car> createCarsDatabase() {
        Map<String, Car> carsDb  = new HashMap<>();
        carsDb.put("Ford Mustang", new Ford("Mustang", 100_000.00));
        carsDb.put("Ford Focus", new Ford("Focus", 63_500.00));
        carsDb.put("Toyota RAV4", new Toyota("RAV4", 85_000.00));

        return carsDb;
    }

    public Map<String, CarOption> createOptionsDatabase(Car car) {
        Map<String, CarOption> optionsDb = new HashMap<>();
        optionsDb.put("GPS", new GPS(car));
        optionsDb.put("Heated seats", new HeatedSeats(car));
        optionsDb.put("Metallic paint", new MetallicPaint(car));
        optionsDb.put("Sound system", new SoundSystem(car));

        return optionsDb;
    }

    public String getAbortCommand() {
        return ABORT_COMMAND;
    }

    public boolean isAbortCommand(String command) {
        return command.equals(ABORT_COMMAND);
    }

}
