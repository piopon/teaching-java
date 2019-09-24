package pl.smtc.patterns.creational.factory.method;

import pl.smtc.menu.ConsoleExample;
import pl.smtc.patterns.creational.factory.method.factory.ILampFactory;
import pl.smtc.patterns.creational.factory.method.factory.IndoorLampFactory;
import pl.smtc.patterns.creational.factory.method.factory.Lamps;
import pl.smtc.patterns.creational.factory.method.factory.OutdoorLampFactory;
import pl.smtc.patterns.creational.factory.method.product.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FactoryMethodPattern implements ConsoleExample {
    protected boolean endOrder = false;
    private List<ILampFactory> lampFactories = new ArrayList<>();
    private List<Lamp> lampsOrder = new ArrayList<>();

    @Override
    public void execute() {
        Scanner input = new Scanner(System.in);
        while (!endOrder) {
            ILampFactory factory = chooseFactory(input);
            List<Lamp> currentOrder = createOrder(input, factory);
            lampsOrder.addAll(currentOrder);
        }
        System.out.println("======================================");
        System.out.println("Order (total " + lampsOrder.size() + " lamps)");
        for (int i = 0; i < lampsOrder.size(); i++) {
            System.out.println("---  " + (i + 1) + "  ---------");
            System.out.println(lampsOrder.get(i).getDescription());
            lampsOrder.get(i).power(true);
            lampsOrder.get(i).power(false);
        }
    }

    @Override
    public String getName() {
        return "Factory method";
    }

    protected ILampFactory chooseFactory(Scanner inputSource) {
        registerLamps();
        System.out.print("Select factory [" + getFactoryNames() + ", Q]: ");
        String inputFactory = inputSource.nextLine();
        return lampFactories.stream()
                .filter(factory -> factory.getName().contains(inputFactory))
                .findFirst()
                .orElse(null);
    }

    protected List<Lamp> createOrder(Scanner inputSource, ILampFactory factory) {
        List<Lamp> lampsToCreate = new ArrayList<>();
        try {
            while (true) {
                String options = factory.getRegisteredLamps().replace("]", ", E]");
                System.out.print(factory.getName() + ": what to create? " + options + ": ");
                String lampType = inputSource.nextLine();
                if (lampType.equalsIgnoreCase("e")) {
                    break;
                }
                lampsToCreate.add(factory.createLamp(Lamps.valueOf(lampType)));
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Error! Cannot create lamp of specified type...");
        } catch (NullPointerException e) {
            endOrder = true;
        }
        return lampsToCreate;
    }

    private void registerLamps() {
        if (lampFactories.isEmpty()) {
            registerIndoorLamps();
            registerOutdoorLamps();
        }
    }

    private void registerIndoorLamps() {
        ILampFactory indoorLampFactory = new IndoorLampFactory();
        indoorLampFactory.registerLamp(new CeilingLamp("DOWELS", "230V"));
        indoorLampFactory.registerLamp(new WallLamp("SCREWS", "230V"));
        indoorLampFactory.registerLamp(new DesktopLamp("STAND", "100V-230V"));
        lampFactories.add(indoorLampFactory);
    }

    private void registerOutdoorLamps() {
        ILampFactory outdoorLampFactory = new OutdoorLampFactory();
        outdoorLampFactory.registerLamp(new GardenLamp("SPIKE", "24V"));
        outdoorLampFactory.registerLamp(new WallLamp("DOWELS", "230V"));
        outdoorLampFactory.registerLamp(new StreetLamp("ANCHORS", "230V"));
        lampFactories.add(outdoorLampFactory);
    }

    private String getFactoryNames() {
        return lampFactories.stream()
                .map(ILampFactory::getName)
                .collect(Collectors.joining(", "));
    }
}
