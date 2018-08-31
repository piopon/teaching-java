package pl.smtd.menu;

import java.util.*;

public class ConsoleMenu {
    private static String SEPARATOR_BOLD = "=";
    private static String SEPARATOR_LITE = "-";
    private static String FRAME = "|";

    private Map<Integer, String> items = new HashMap<>();
    private Scanner input = new Scanner(System.in);
    private String title;
    private int width;

    public ConsoleMenu(String title, int width, List<String> items) {
        this.title = title;
        this.width = width;
        this.items.put(0, "quit");
        for (int i = 0; i < items.size(); i++) {
            this.items.put(i + 1, items.get(i));
        }
    }

    public String show() {
        String selectedMethod = "";
        while (selectedMethod.isEmpty()) {
            System.out.println(separator(SEPARATOR_BOLD));
            System.out.println(title());
            System.out.println(separator(SEPARATOR_BOLD));

            for (int i = 1; i < items.size(); i++) {
                System.out.println(menuLine(i + ") " + items.get(i)));
            }
            System.out.println(separator(SEPARATOR_LITE));
            System.out.println(menuLine("0) quit"));
            System.out.println(separator(SEPARATOR_BOLD));

            System.out.print("SELECT: ");
            if (input.hasNextInt()) {
                int userChoice = input.nextInt();
                if (userChoice >= 0 && userChoice < items.size()) {
                    selectedMethod = items.get(userChoice);
                }
            }

            if (selectedMethod.isEmpty()) {
                System.out.println("Bad input! Please try again.");
                System.out.println(" ");
            }
        }
        return selectedMethod;
    }

    private String separator(String str) {
        return new ConsoleText(str, width)
                .trim()
                .repeat(width)
                .frame(FRAME)
                .print();
    }

    private String title() {
        return new ConsoleText(title, width)
                .trim()
                .align(ConsoleText.CENTER)
                .frame(FRAME)
                .print();
    }

    private String menuLine(String text) {
        return new ConsoleText(text, width)
                .trim()
                .align(ConsoleText.LEFT)
                .indent(2)
                .frame(FRAME)
                .print();
    }
}
