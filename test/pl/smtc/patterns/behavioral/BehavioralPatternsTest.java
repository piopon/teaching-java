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
    }

    @Test
    void getName() {
        assertEquals("Behavioral patterns", behavioralPatterns.getName());
    }

}