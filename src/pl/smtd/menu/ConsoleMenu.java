package pl.smtd.menu;

import java.util.*;

public class ConsoleMenu {
    private static String SEPARATOR_BOLD = "=";
    private static String SEPARATOR_LITE = "-";
    private static String FRAME = "|";
    private static int DEFAULT_WIDTH = 50;
    private static int INDENTATION = 2;

    private Map<Integer, ConsoleExample> items;
    private Scanner input = new Scanner(System.in);
    private String title;
    private int width;

    public ConsoleMenu(String title, int width, Map<Integer, ConsoleExample> items) {
        this.title = title;
        this.items = items;
        this.width = adjustWidth(width);
    }

    public void show() {
        while (true) {
            System.out.println(separator(SEPARATOR_BOLD));
            System.out.println(title());
            System.out.println(separator(SEPARATOR_BOLD));

            for (int i = 0; i < items.size(); i++) {
                System.out.println(option(i + 1, items.get(i).getName()));
            }
            System.out.println(separator(SEPARATOR_LITE));
            System.out.println(option(0,"Quit"));
            System.out.println(separator(SEPARATOR_BOLD));

            System.out.print(FRAME + " SELECT: ");
            if (input.hasNextInt()) {
                int userChoice = input.nextInt() - 1;
                if (userChoice == -1) {
                    break;
                } else if (userChoice >= 0 && userChoice < items.size()) {
                    System.out.println(" ");
                    items.get(userChoice).execute();
                    System.out.println(" ");
                } else {
                    printError("Bad input... Please try again.");
                }
            }
        }
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
                .align(ConsoleAlign.CENTER)
                .frame(FRAME)
                .print()
                .toUpperCase();
    }

    private String option(int index, String text) {
        return new ConsoleText(index + ") " + text, width)
                .trim()
                .align(ConsoleAlign.LEFT)
                .indent(index > 9 ? INDENTATION : INDENTATION + 1)
                .frame(FRAME)
                .print();
    }

    private String error(String text) {
        return new ConsoleText(text, width)
                .trim()
                .align(ConsoleAlign.LEFT)
                .indent(INDENTATION)
                .frame("!")
                .print();
    }

    private void printError(String text) {
        System.out.println(" ");
        System.out.println(error("ERROR:"));
        System.out.println(error(text));
        System.out.println(" ");
    }

    private int adjustWidth(int initialWidth) {
        int titleLen = title.length();
        int maxLen = items.values().stream()
                .mapToInt(item -> item.getName().length())
                .max()
                .orElse(DEFAULT_WIDTH);
        int minWidth = ((titleLen > maxLen) ? titleLen : maxLen) + 8;

        return (minWidth < initialWidth) ? initialWidth : minWidth;
    }
}
