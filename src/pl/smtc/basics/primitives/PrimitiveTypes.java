package pl.smtc.basics.primitives;

import pl.smtc.basics.primitives.character.CharacterTypes;
import pl.smtc.basics.primitives.examples.PrimitivesExamples;
import pl.smtc.basics.primitives.floating.FloatingPointTypes;
import pl.smtc.basics.primitives.integral.IntegralTypes;
import pl.smtc.menu.ConsoleExample;
import pl.smtc.menu.ConsoleMenu;

import java.util.HashMap;
import java.util.Map;

public class PrimitiveTypes implements ConsoleExample {
    private Map<Integer, ConsoleExample> primitivesExamples = new HashMap<>();
    private int menuWidth = 35;

    @Override
    public void execute() {
        addExamples(new IntegralTypes(), new FloatingPointTypes(), new CharacterTypes(),
                    new PrimitivesExamples());

        ConsoleMenu primitivesMenu = new ConsoleMenu(getName(), menuWidth, primitivesExamples);
        primitivesMenu.show();
    }

    @Override
    public String getName() {
        return "Primitive types";
    }

    private void addExamples(ConsoleExample... examples) {
        for(int i = 0; i < examples.length; i++) {
            primitivesExamples.put(i, examples[i]);
        }
    }
}
