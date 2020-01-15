package pl.smtc.basics.operators.relational;

import pl.smtc.menu.ConsoleExample;

public class ConditionalOperators implements ConsoleExample {
    @Override
    public void execute() {
        boolean boolTrue = true;
        boolean boolFalse = false;
        boolean and = boolTrue && boolFalse;
        System.out.println("Operator AND: " + boolTrue + " && " + boolFalse + " = " + and);
        boolean or = boolTrue || boolFalse;
        System.out.println("Operator OR: " + boolTrue + " || " + boolFalse + " = " + or);
        String ternary = or ? "OR operator is true" : "AND operator is true";
        System.out.println("Ternary operator: " + ternary);
    }

    @Override
    public String getName() {
        return "Conditional operators";
    }
}
