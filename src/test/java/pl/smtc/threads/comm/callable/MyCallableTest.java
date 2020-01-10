package pl.smtc.threads.comm.callable;

import org.junit.jupiter.api.Test;
import pl.smtc.base.BaseTestOut;

import static org.junit.jupiter.api.Assertions.*;

class MyCallableTest extends BaseTestOut {
    MyCallable myCallable;

    @Override
    protected void setUp() {
        myCallable = new MyCallable(50);
    }

    @Test
    void callShouldInvokeMyCallableThreadSimTime() throws Exception {
        myCallable.call();
        String output = getOutput();
        assertTrue(output.contains("MyCallable -> start"));
        assertTrue(output.contains("MyCallable -> stop (execution time: "));
    }
}