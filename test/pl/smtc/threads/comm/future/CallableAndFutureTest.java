package pl.smtc.threads.comm.future;

import org.junit.jupiter.api.Test;
import pl.smtc.base.BaseTestInOut;

import static org.junit.jupiter.api.Assertions.*;

class CallableAndFutureTest extends BaseTestInOut {
    CallableAndFuture callableAndFuture;

    @Override
    protected void setUp() {
        callableAndFuture = new CallableAndFuture(1, 100);
    }

    @Test
    void executeShouldInvokeCallableAndFutureExample() {
        simulateUserInput(System.lineSeparator());
        callableAndFuture.execute();
        String output = getOutput();
        assertTrue(output.contains("> thread finished - result: "));
    }

    @Test
    void executeShouldInvokeCallableAndFutureWithErrorMessage() {
        CallableAndFuture callableAndFutureBad = new CallableAndFuture(10, 0);
        simulateUserInput(System.lineSeparator());
        callableAndFutureBad.execute();
        String output = getOutput();
        assertTrue(output.contains("> callable exception: "));
    }

    @Test
    void getNameShouldReturnCallableAndFuture() {
        assertEquals("Callable and Future", callableAndFuture.getName());
    }
}