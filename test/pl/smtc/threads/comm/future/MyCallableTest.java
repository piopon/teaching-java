package pl.smtc.threads.comm.future;

import org.junit.jupiter.api.Test;
import pl.smtc.base.BaseTestOut;

import static org.junit.jupiter.api.Assertions.*;

class MyCallableTest extends BaseTestOut {
    MyCallable callableOK;

    @Override
    protected void setUp() {
        callableOK = new MyCallable(1,100);
    }

    @Test
    void callShouldReturnIfMaxWaitTimeIsBiggerThenExceptionTime() throws Exception {
        callableOK.call();
        String output = getOutput();
        assertTrue(output.contains("MyCallable -> start"));
        assertTrue(output.contains("MyCallable -> stop (execution time: "));
        assertFalse(output.contains("current wait time ("));
        assertFalse(output.contains(") is to big!"));
    }

    @Test
    void callShouldThrowIfMaxWaitTimeIsSmallerThenExceptionTime() throws Exception {
        MyCallable callableNOK = new MyCallable(100, 1);
        assertThrows(IllegalArgumentException.class, () -> callableNOK.call());
    }
}