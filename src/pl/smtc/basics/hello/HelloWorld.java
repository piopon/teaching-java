package pl.smtc.basics.hello;

import pl.smtc.menu.ConsoleExample;

public class HelloWorld implements ConsoleExample {
    @Override
    public void execute() {
        System.out.println("Hello word!");
    }

    @Override
    public String getName() {
        return "Hello world";
    }
}
