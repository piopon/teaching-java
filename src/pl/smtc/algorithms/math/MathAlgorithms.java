package pl.smtc.algorithms.math;

import pl.smtc.algorithms.math.binomial.BinomialCoefficient;
import pl.smtc.algorithms.math.sieve.EratosthenesSieve;
import pl.smtc.menu.ConsoleExample;
import pl.smtc.menu.ConsoleMenu;

import java.util.HashMap;
import java.util.Map;

public class MathAlgorithms implements ConsoleExample {
    private Map<Integer, ConsoleExample> mathAlgorithms = new HashMap<>();
    private int menuWidth = 35;

    @Override
    public void execute() {
        addExamples(new BinomialCoefficient(), new EratosthenesSieve());

        ConsoleMenu mathAlgorithmsMenu = new ConsoleMenu(getName(), menuWidth, mathAlgorithms);
        mathAlgorithmsMenu.show();
    }

    @Override
    public String getName() {
        return "Math algorithms";
    }

    private void addExamples(ConsoleExample... examples) {
        for (int i = 0; i < examples.length; i++) {
            mathAlgorithms.put(i, examples[i]);
        }
    }
}
