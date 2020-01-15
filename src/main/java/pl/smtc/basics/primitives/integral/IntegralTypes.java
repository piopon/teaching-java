package pl.smtc.basics.primitives.integral;

import pl.smtc.menu.ConsoleExample;

public class IntegralTypes implements ConsoleExample {
    @Override
    public void execute() {
        byte byteValue = 127;       // values >= 128 will produce error
        short shortValue = 32767;   // values >= 32768 will produce error
        int intValue = 2147483647;  // values >= 2147483647 will produce error
        long longSum = 1000L + 10 * (byteValue + shortValue + intValue);
        System.out.println("LONG sum of created integral types: " + longSum);
        short shortSum = (short)(1000L + 10 * (byteValue + shortValue + intValue));
        System.out.println("SHORT sum of created integral types: " + shortSum);
        printSummary();
    }

    @Override
    public String getName() {
        return "Integral types";
    }

    private void printSummary() {
        System.out.println("-------------------------------------------");
        System.out.println("Integral types summary");
        System.out.println(getTypeSummary("byte", Byte.SIZE, Byte.BYTES, Byte.MIN_VALUE, Byte.MAX_VALUE));
        System.out.println(getTypeSummary("short", Short.SIZE, Short.BYTES, Short.MIN_VALUE, Short.MAX_VALUE));
        System.out.println(getTypeSummary("int", Integer.SIZE, Integer.BYTES, Integer.MIN_VALUE, Integer.MAX_VALUE));
        System.out.println(getTypeSummary("long", Long.SIZE, Long.BYTES, Long.MIN_VALUE, Long.MAX_VALUE));
    }

    private String getTypeSummary(String title, int size, int bytes, long min, long max) {
        String values = "\tsize = " + size + ", bytes = " + bytes + ", min value = " + min + ", max value = " + max;
        return " - " + title + ": " + values;
    }
}
