package pl.smtc.patterns.behavioral;

import org.junit.jupiter.api.Test;
import pl.smtc.base.BaseTestInOut;

import static org.junit.jupiter.api.Assertions.*;

class BehavioralPatternsTest extends BaseTestInOut {
    private BehavioralPatterns behavioralPatterns;

    @Override
    protected void setUp() {
        behavioralPatterns = new BehavioralPatterns();
    }

    @Test
    void execute() {
        simulateUserInput("0");
        behavioralPatterns.execute();
        String output = getOutput();
        assertTrue(output.contains("BEHAVIORAL PATTERNS"));
        assertTrue(output.contains("1) Command pattern"));
        assertTrue(output.contains("2) Strategy pattern"));
        assertTrue(output.contains("3) Observer pattern"));
        assertTrue(output.contains("4) Template method pattern"));
        assertTrue(output.contains("5) Iterator pattern"));
        assertTrue(output.contains("6) State pattern"));
        assertTrue(output.contains("7) Null object pattern"));
    }

    @Test
    void getName() {
        assertEquals("Behavioral patterns", behavioralPatterns.getName());
    }

}