package pl.smtc.basics.flow.examples;

import pl.smtc.menu.ConsoleExample;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class DaysInMonth implements ConsoleExample {
    @Override
    public void execute() {
        System.out.print("Select month and year [format mm/yyyy]: ");
        String input = new Scanner(System.in).nextLine();
        List<String> parts = Arrays.asList(input.split("/"));
        if (parts.size() == 2) {
            try {
                int days = getDaysInMonth(Integer.parseInt(parts.get(0)), Integer.parseInt(parts.get(1)));
                System.out.println("Days in " + input + ": " + days);
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            }
        } else {
            System.out.println("Bad input: " + input);
        }
    }

    @Override
    public String getName() {
        return "Days in month";
    }

    protected int getDaysInMonth(int month, int year) {
        if (month < 1 || month > 12 || year < 1 || year > 9999) {
            throw new NumberFormatException("Bad input: " + month + "/" + year);
        }
        if (month == 2) {
            return isLeapYear(year) ? 29 : 28;
        }
        boolean oddMonth = month % 2 == 1;
        return (month > 7) ? (oddMonth ? 30 : 31) : (oddMonth ? 31 : 30);
    }

    private boolean isLeapYear(int year) {
        if (year < 1 || year > 9999) {
            return false;
        }
        boolean divBy4Not100 = (year % 4 == 0) && (year % 100 != 0);
        boolean divBy400 = (year % 400 == 0);
        return (divBy4Not100 || divBy400);
    }
}
