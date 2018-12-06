package pl.smtc.threads.issues.lockout;

import org.junit.jupiter.api.Test;
import pl.smtc.base.BaseTestInOut;

import java.util.stream.Stream;

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
        String correctEndLogs[] = { "receive procedure [stop]", "send procedure [stop]" };
        boolean correctCondition = outputContainsAnyOf(output, correctEndLogs);
        boolean nestedLockoutCondition = output.contains("timeout reached = nested lockout!");

        assertTrue(correctCondition || nestedLockoutCondition );
    }

    @Test
    void getNameShouldReturnNestedMonitorLockout() {
        assertEquals("Nested monitor lockout", nestedLockout.getName());
    }

    private boolean outputContainsAnyOf(String current, String... expected) {
        return Stream.of(expected).anyMatch(currentString -> current.contains(currentString));
    }
}