package pl.smtc.threads.comm.callable;

import org.junit.jupiter.api.Test;
import pl.smtc.base.BaseTestInOut;

import static org.junit.jupiter.api.Assertions.*;

class ImplementsCallableTest extends BaseTestInOut {
    ImplementsCallable implementsCallable;

    @Override
    protected void setUp() {
        implementsCallable = new ImplementsCallable(50);
    }

    @Test
    void executeShouldInvokeImplementCallableExample() {
        simulateUserInput(System.lineSeparator());
        implementsCallable.execute();
        String output = getOutput();
        assertTrue(output.contains("> thread finished - got result: "));
    }

    @Test
    void getNameShouldReturnImplementCallableInterface() {
        assertEquals("Implement Callable interface", implementsCallable.getName());
    }
}