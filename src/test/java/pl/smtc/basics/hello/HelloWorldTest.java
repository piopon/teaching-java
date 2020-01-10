package pl.smtc.basics.hello;

import org.junit.jupiter.api.Test;
import pl.smtc.base.BaseTestOut;

import static org.junit.jupiter.api.Assertions.*;

class HelloWorldTest extends BaseTestOut {
    private HelloWorld helloWorld;

    @Override
    protected void setUp() {
        helloWorld = new HelloWorld();
    }

    @Test
    void executeShouldInvokeHelloWorldExample() {
        helloWorld.execute();
        String output = getOutput();
        assertTrue(output.contains("Hello world!"));
    }

    @Test
    void getNameShouldReturnHelloWorldString() {
        assertEquals("Hello world", helloWorld.getName());
    }
}