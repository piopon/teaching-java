package pl.smtc.basics.string.conversions;

import pl.smtc.menu.ConsoleExample;

public class StringFromObject implements ConsoleExample {
    @Override
    public void execute() {
        String objectString = String.valueOf(new TestClass());
        System.out.println("TestClass to String: " + objectString);
    }

    @Override
    public String getName() {
        return "Object to string";
    }

    private class TestClass {
        @Override
        public String toString() {
            return "This is TestClass toString() method";
        }
    }
}
