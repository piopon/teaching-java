package pl.smtc.basics.primitives.floating;

import pl.smtc.menu.ConsoleExample;

public class FloatingPointTypes implements ConsoleExample {
    @Override
    public void execute() {
        float floatValue1 = 10;
        float floatValue2 = 20f;
        float floatValue3 = (float)30.25; // = 30.0 will give an error since double is the default
        System.out.println("Float values:");
        System.out.println(" - floatValue1 = " + floatValue1);
        System.out.println(" - floatValue2 = " + floatValue2);
        System.out.println(" - floatValue3 = " + floatValue3);

        double doubleValue1 = 10;
        double doubleValue2 = 20d;
        double doubleValue3 = 30.25; // no error because double is the default
        System.out.println("Double values:");
        System.out.println(" - doubleValue1 = " + doubleValue1);
        System.out.println(" - doubleValue2 = " + doubleValue2);
        System.out.println(" - doubleValue3 = " + doubleValue3);

        System.out.println("float vs double: 10.0 / 3.0");
        System.out.println(" - float  = " + 10.0f/3.0f);
        System.out.println(" - double = " + 10.0d/3.0d);

        printSummary();
    }

    @Override
    public String getName() {
        return "Floating point types";
    }

    private void printSummary() {
        System.out.println("-------------------------------------------");
        System.out.println("Floating point types summary");
        System.out.println(getTypeSummary("float", Float.SIZE, Float.BYTES, Float.MIN_VALUE, Float.MAX_VALUE));
        System.out.println(getTypeSummary("double", Double.SIZE, Double.BYTES, Double.MIN_VALUE, Double.MAX_VALUE));
    }

    private String getTypeSummary(String title, int size, int bytes, double min, double max) {
        String values = "\tsize = " + size + ", bytes = " + bytes + ", min value = " + min + ", max value = " + max;
        return " - " + title + ": " + values;
    }
}
