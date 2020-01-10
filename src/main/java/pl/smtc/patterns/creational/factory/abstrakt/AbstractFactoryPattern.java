package pl.smtc.patterns.creational.factory.abstrakt;

import pl.smtc.menu.ConsoleExample;
import pl.smtc.patterns.creational.factory.abstrakt.support.FactoriesDataProvider;
import pl.smtc.patterns.creational.factory.abstrakt.support.ShippingList;
import pl.smtc.patterns.creational.factory.abstrakt.support.ShippingListCreator;

import java.util.Scanner;

public class AbstractFactoryPattern implements ConsoleExample {
    private ShippingListCreator shipping = new ShippingListCreator(new FactoriesDataProvider());

    @Override
    public void execute() {
        Scanner inputSource = new Scanner(System.in);
        ShippingList shipList = shipping.create(inputSource);
        shipList.printList();
        qualityCheck(inputSource, shipList);
    }

    @Override
    public String getName() {
        return "Abstract factory";
    }

    private void qualityCheck(Scanner scanner, ShippingList list) {
        if (list.size() == 0) {
            return;
        }
        String checkDecision = "";
        while (!checkDecision.equalsIgnoreCase("q")) {
            System.out.println(" ");
            System.out.print("Which item number to test? [P = print list, Q = quit] ");
            checkDecision = scanner.nextLine();
            if (checkDecision.matches("\\d+")) {
                list.testItem(Integer.parseInt(checkDecision));
            } else if (checkDecision.equalsIgnoreCase("p")) {
                list.printList();
            } else if (!checkDecision.equalsIgnoreCase("q")) {
                System.out.println("Not recognized input [" + checkDecision + "].");
            }
        }
    }
}
