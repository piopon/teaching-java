package pl.smtc.patterns.behavioral.state;

import pl.smtc.menu.ConsoleExample;
import pl.smtc.patterns.behavioral.state.context.Printer;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class StatePattern implements ConsoleExample {
    private Printer printer;
    private int docCounter = 0;

    public StatePattern() {
        printer = new Printer();
        printer.initialize();
    }

    public StatePattern(int simPrintTime) {
        printer = new Printer(simPrintTime);
        printer.initialize();
    }

    @Override
    public void execute() {
        Scanner input = new Scanner(System.in);
        Map<String, Runnable> options = getAvailableOptions();
        String userDecision = "";
        while (!userDecision.equals("quit")) {
            System.out.print("Action " + options.keySet().toString().toUpperCase() + ": ");
            userDecision = input.nextLine().toLowerCase();
            if (options.containsKey(userDecision)) {
                options.get(userDecision).run();
            }
        }
    }

    @Override
    public String getName() {
        return "State pattern";
    }

    private Map<String, Runnable> getAvailableOptions() {
        Map<String, Runnable> options = new HashMap<>();
        options.put("print", () -> printer.print("document" + (++docCounter) + ".txt"));
        options.put("cancel", () -> printer.cancel());
        options.put("quit", () -> printer.waitForAllPrints());

        return options;
    }
}
