package pl.smtc.basics.flow;

import pl.smtc.basics.flow.decision.IfElseifElseExample;
import pl.smtc.basics.flow.decision.SwitchCaseExample;
import pl.smtc.menu.ConsoleExample;
import pl.smtc.menu.ConsoleMenu;

import java.util.HashMap;
import java.util.Map;

public class ControlFlow implements ConsoleExample {
    private Map<Integer, ConsoleExample> controlFlowExamples = new HashMap<>();
    private int menuWidth = 35;

    @Override
    public void execute() {
        addExamples(new IfElseifElseExample(), new SwitchCaseExample());

        ConsoleMenu controlFlowMenu = new ConsoleMenu(getName(), menuWidth, controlFlowExamples);
        controlFlowMenu.show();
    }

    @Override
    public String getName() {
        return "Control flow";
    }

    private void addExamples(ConsoleExample... examples) {
        for(int i = 0; i < examples.length; i++) {
            controlFlowExamples.put(i, examples[i]);
        }
    }
}
