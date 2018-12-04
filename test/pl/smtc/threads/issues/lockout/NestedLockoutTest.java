package pl.smtc.threads.issues.lockout;

import org.junit.jupiter.api.Test;
import pl.smtc.base.BaseTestInOut;

import static org.junit.jupiter.api.Assertions.*;

class NestedLockoutTest extends BaseTestInOut {
    NestedLockout nestedLockout;

    @Override
    protected void setUp() {
        nestedLockout = new NestedLockout(10,10,100);
    }

    @Test
    void executeShouldInvokeNestedLockoutExample() {
        simulateUserInput(System.lineSeparator());
        nestedLockout.execute();
        String output = getOutput();
        assertTrue(output.contains("timeout reached = nested lockout!"));
    }

    @Test
    void getNameShouldReturnNestedMonitorLockout() {
        assertEquals("Nested monitor lockout", nestedLockout.getName());
    }
}