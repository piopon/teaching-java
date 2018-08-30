package pl.smtd.menu;

import java.util.*;

public class ConsoleMenu {
    private Map<Integer, String> items = new HashMap<>();
    private String title;
    private Scanner input = new Scanner(System.in);

    public ConsoleMenu(String title, List<String> items) {
        this.title = title;
        this.items.put(0, "quit");
        for (int i = 0; i < items.size(); i++) {
            this.items.put(i + 1, items.get(i));
        }
    }

    public String show() {
        String selectedMethod = "";
        while (selectedMethod.isEmpty()) {
            System.out.println("===========================");
            System.out.println(title);
            System.out.println("===========================");

            for (int i = 1; i < items.size(); i++) {
                System.out.println(i + ") " + items.get(i));
            }
            System.out.println("---------------------------");
            System.out.println("0) quit");
            System.out.println("===========================");

            System.out.print("SELECT: ");
            if (input.hasNextInt()) {
                int userChoice = input.nextInt();
                if (userChoice >= 0 && userChoice < items.size()) {
                    selectedMethod = items.get(userChoice);
                }
            }

            if(selectedMethod.isEmpty()) {
                System.out.println("Bad input! Please try again.");
                System.out.println(" ");
            }
        }
        return selectedMethod;
    }
}
