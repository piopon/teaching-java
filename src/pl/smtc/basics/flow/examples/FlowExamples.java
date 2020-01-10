package pl.smtc.basics.flow.examples;

import pl.smtc.menu.ConsoleExample;
import pl.smtc.menu.ConsoleMenu;

import java.util.HashMap;
import java.util.Map;

public class FlowExamples implements ConsoleExample {
    private Map<Integer, ConsoleExample> flowExamples = new HashMap<>();
    private int menuWidth = 35;

    @Override
    public void execute() {
        addExamples(new SumOddNumbers(), new PalindromeNumber(), new BoundsDigitsSum(),
                    new AllFactors(), new PerfectNumber(), new DiagonalStar(), new DaysInMonth());

        ConsoleMenu examplesMenu = new ConsoleMenu(getName(), menuWidth, flowExamples);
        examplesMenu.show();
    }

    @Override
    public String getName() {
        return "Examples";
    }

    private void addExamples(ConsoleExample... examples) {
        for(int i = 0; i < examples.length; i++) {
            flowExamples.put(i, examples[i]);
        }
    }
}
