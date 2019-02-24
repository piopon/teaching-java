package pl.smtc.patterns.structural.decorator;

import pl.smtc.menu.ConsoleExample;
import pl.smtc.patterns.structural.decorator.components.Car;
import pl.smtc.patterns.structural.decorator.decorators.*;

import java.util.*;

public class DecoratorPattern implements ConsoleExample {
    private DecoratorPatternResources data;
    private Scanner input;

    @Override
    public void execute() {
        try {
            initDataResources();
            Car car = optionsSelection(carSelection());
            System.out.println("==========================");
            System.out.println(" - SELECTED:   " + car.getName());
            System.out.println(" - TOTAL COST: " + car.getPrice());
        } catch(IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public String getName() {
        return "Decorator pattern";
    }

    private Car carSelection() throws IllegalArgumentException {
        Map<String, Car> cars = data.createCarsDatabase();
        String carType = getInput("Select car", cars.keySet());
        if (!cars.containsKey(carType)) {
            String text = (data.isAbortCommand(carType)) ? "User cancelled" : carType + " - not in stock.";
            throw new IllegalArgumentException(text);
        }
        return cars.get(carType);
    }

    private Car optionsSelection(Car car) {
        while (true) {
            Map<String, CarOption> options = data.createOptionsDatabase(car);
            String option = getInput("Add option", options.keySet());
            if (data.isAbortCommand(option)) {
                break;
            }
            if (!options.containsKey(option)) {
                throw new IllegalArgumentException(option + " - not in stock.");
            }
            System.out.println("Added option: " + option);
            car = options.get(option);
        }
        return car;
    }

    private String getInput(String title, Collection<String> items) {
        StringBuilder prompt = new StringBuilder(title.toUpperCase());
        prompt.append("  [options: ");
        for(String item : items) {
            prompt.append(item).append(", ");
        }
        prompt.append(data.getAbortCommand()).append("] > ");
        System.out.print(prompt);

        return input.nextLine();
    }

    private void initDataResources() {
        data = new DecoratorPatternResources();
        input = new Scanner(System.in);
    }
}
