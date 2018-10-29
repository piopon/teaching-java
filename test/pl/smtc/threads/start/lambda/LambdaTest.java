package pl.smtc.threads.start.lambda;

import org.junit.jupiter.api.Test;
import pl.smtc.base.BaseTestInOut;

import static org.junit.jupiter.api.Assertions.*;

class LambdaTest extends BaseTestInOut {
    private Lambda lambdaThread;

    @Override
    protected void setUp() {
        lambdaThread = new Lambda(10, false);
    }

    @Test
    void executeShouldRunLambdaThreadExample() {
        simulateUserInput(System.lineSeparator() + " " + System.lineSeparator());
        lambdaThread.execute();
        String output = getOutput();
        assertTrue(output.contains("> second thread is running!"));
        assertTrue(output.contains("> second thread has stopped!"));
    }

    @Test
    void getNameShouldReturnLambdaExpressionUsage() {
        assertEquals("Lambda expression usage", lambdaThread.getName());
    }
}