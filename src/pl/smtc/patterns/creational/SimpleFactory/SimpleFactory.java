package pl.smtc.patterns.creational.SimpleFactory;

import pl.smtc.menu.ConsoleExample;
import pl.smtc.patterns.creational.SimpleFactory.factory.LampFactory;
import pl.smtc.patterns.creational.SimpleFactory.factory.Lamps;
import pl.smtc.patterns.creational.SimpleFactory.product.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SimpleFactory implements ConsoleExample {
    static {
        LampFactory.clearRegisteredLamps();
        LampFactory.registerLamp(new CeilingLamp("DOWELS", "100-230V"));
        LampFactory.registerLamp(new WallLamp("SCREWS", "230V"));
        LampFactory.registerLamp(new DesktopLamp("STAND", "100-230V"));
        LampFactory.registerLamp(new GardenLamp("SPIKE", "24V"));
        LampFactory.registerLamp(new StreetLamp("ANCHORS", "230V"));
    }

    @Override
    public void execute() {
        List<ILamp> createdLamps = createLampOrder(new Scanner(System.in));
        System.out.println("==============================");
        System.out.println("TOTAL " + createdLamps.size() + " LAMPS TO BE MANUFACTURED");
        createdLamps.forEach(lamp -> System.out.println(" * " + lamp.getDescription()));
    }

    @Override
    public String getName() {
        return "Simple factory";
    }

    protected List<ILamp> createLampOrder(Scanner inputSource) {
        List<ILamp> lampsToCreate = new ArrayList<>();
        try {
            while (true) {
                System.out.print("What lamp to create? " + showAvailableOptions() + ": ");
                String lampType = inputSource.nextLine();
                if (lampType.equalsIgnoreCase("q")) {
                    break;
                }
                lampsToCreate.add(LampFactory.createLamp(Lamps.valueOf(lampType)));
            }
        } catch(IllegalArgumentException e) {
            System.out.println("Error! Cannot create lamp of specified type.");
        }
        return lampsToCreate;
    }

    private String showAvailableOptions() {
        return LampFactory.getRegisteredLamps().replace("]", ", Q]");
    }
}
