package pl.smtc.basics.flow.examples;

import pl.smtc.menu.ConsoleExample;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class AllFactors implements ConsoleExample {
    @Override
    public void execute() {
        System.out.print("Input number (positive): ");
        int number = new Scanner(System.in).nextInt();
        var factors = getAllFactors(number);
        System.out.println("Factors for number " + number + ": " + factors);
    }

    @Override
    public String getName() {
        return "All number factors";
    }

    protected List<Integer> getAllFactors(int number) {
        if(number < 1) {
            return Collections.emptyList();
        }
        List<Integer> result = new ArrayList<>();
        int lastFactor = 1;
        while (lastFactor <= number) {
            if (number % lastFactor == 0) {
                result.add(lastFactor);
            }
            lastFactor++;
        }
        return result;
    }
}
