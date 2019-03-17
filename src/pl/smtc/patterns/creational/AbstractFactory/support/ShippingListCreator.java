package pl.smtc.patterns.creational.AbstractFactory.support;

import pl.smtc.patterns.creational.AbstractFactory.factory.EComponent;
import pl.smtc.patterns.creational.AbstractFactory.factory.LampFactory;
import pl.smtc.patterns.creational.AbstractFactory.product.lamp.ELamp;
import pl.smtc.patterns.creational.AbstractFactory.product.lamp.Lamp;
import pl.smtc.patterns.creational.AbstractFactory.product.mount.EMounting;
import pl.smtc.patterns.creational.AbstractFactory.product.mount.Mounting;
import pl.smtc.patterns.creational.AbstractFactory.product.source.ESource;
import pl.smtc.patterns.creational.AbstractFactory.product.source.Source;

import java.util.*;

public class ShippingListCreator {
    private final static String COMMAND_QUIT = "quit";
    private final static String COMMAND_FACTORY = "change factory";
    private final static String COMMAND_ITEM = "next item";
    private FactoriesDataProvider data;

    public ShippingListCreator(FactoriesDataProvider data) {
        this.data = data;
    }

    public ShippingList create(Scanner input) {
        ShippingList shipList = new ShippingList();
        String continuationState = "";
        LampFactory factory = data.getFactory("OUTDOOR");
        while (!continuationState.equalsIgnoreCase(COMMAND_QUIT)) {
            continuationState = userDecision(input, factory.getName(), shipList.size());
            if (continuationState.equalsIgnoreCase(COMMAND_FACTORY)) {
                factory = selectFactory(input);
            }
            if (continuationState.equalsIgnoreCase(COMMAND_ITEM)) {
                ShippingItem item = selectItem(input, factory);
                shipList.addItem(item);
                System.out.println("[OK] Item added to list." + System.lineSeparator());
            }
        }
        return shipList;
    }

    private LampFactory selectFactory(Scanner input) {
        String errorMessage = "Bad input. Select correct factory.";
        while(true) {
            System.out.print("Select factory [" + data.getFactoryNames() + "]: ");
            String selected = input.nextLine().toUpperCase();
            if (!data.getFactoryNames().contains(selected)) {
                System.out.println(errorMessage);
                continue;
            }
            LampFactory factory = data.getFactory(selected);
            if (factory == null) {
                System.out.println(errorMessage);
                continue;
            }
            System.out.println("[OK] Factory selected." + System.lineSeparator());
            return factory;
        }
    }

    private ShippingItem selectItem(Scanner input, LampFactory factory) {
        Lamp newLamp = selectLamp(input, factory);
        newLamp.setMounting(selectMounting(input, factory));
        newLamp.setSource(selectSource(input, factory));
        int quantity = selectQuantity(input);

        return new ShippingItem(newLamp, quantity, factory.getName());
    }

    private Lamp selectLamp(Scanner input, LampFactory factory) {
        String availableLamps = factory.getRegisteredData(EComponent.LAMP);
        while (true) {
            System.out.print("Select lamp " + availableLamps + ": ");
            String selected = input.nextLine().toUpperCase();
            if (availableLamps.contains(selected)) {
                return factory.createLamp(ELamp.valueOf(selected));
            } else {
                System.out.println("Bad input. Select correct lamp.");
            }
        }
    }

    private Mounting selectMounting(Scanner input, LampFactory factory) {
        String availableMountings = factory.getRegisteredData(EComponent.MOUNTING);
        while (true) {
            System.out.print("Select mounting " + availableMountings + ": ");
            String selected = input.nextLine().toUpperCase();
            if (availableMountings.contains(selected)) {
                return factory.createMounting(EMounting.valueOf(selected));
            } else {
                System.out.println("Bad input. Select correct mounting.");
            }
        }
    }

    private Source selectSource(Scanner input, LampFactory factory) {
        String availableSources = factory.getRegisteredData(EComponent.SOURCE);
        while (true) {
            System.out.print("Select source " + availableSources + ": ");
            String selected = input.nextLine().toUpperCase();
            if (availableSources.contains(selected)) {
                return factory.createSource(ESource.valueOf(selected));
            } else {
                System.out.println("Bad input. Select correct source.");
            }
        }
    }

    private int selectQuantity(Scanner input) {
        while(true) {
            System.out.print("How many lamps to ship? ");
            try {
                return Integer.parseInt(input.nextLine());
            } catch(NumberFormatException e) {
                System.out.println("Type any integer.");
            }
        }
    }

    private String userDecision(Scanner input, String factoryName, int listSize) {
        String errorMessage = "Wrong input. Type selected option number.";
        Map<Integer, String> userOptions = new HashMap<>() {{
            put(0, COMMAND_QUIT);
            put(1, COMMAND_ITEM);
            put(2, COMMAND_FACTORY);
        }};
        while (true) {
            System.out.println("+--------------------------------------------");
            System.out.println("| SHIPPING LIST CREATOR");
            System.out.println("+--------------------------------------------");
            System.out.println("| current factory: " + factoryName);
            System.out.println("| current list size: " + listSize);
            System.out.println("+--------------------------------------------");
            System.out.println("| options: " + formatOptions(userOptions));
            System.out.println("+--------------------------------------------");
            System.out.print("> action: ");
            try {
                int option = Integer.parseInt(input.nextLine());
                if (userOptions.containsKey(option)) {
                    System.out.println(" ");
                    return userOptions.get(option);
                } else {
                    System.out.println(System.lineSeparator() + errorMessage + System.lineSeparator());
                }
            } catch (NumberFormatException e) {
                System.out.println(System.lineSeparator() + errorMessage + System.lineSeparator());
            }
        }
    }

    private String formatOptions(Map<?,?> optionsMap) {
        return optionsMap.toString()
                .replace("{", "")
                .replace("}", "");
    }
}
