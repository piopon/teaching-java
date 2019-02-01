package pl.smtc.patterns.creational;

import org.junit.jupiter.api.Test;
import pl.smtc.base.BaseTestInOut;

import static org.junit.jupiter.api.Assertions.*;

class CreationalPatternsTest extends BaseTestInOut {
    private CreationalPatterns creationalPatterns;

    @Override
    protected void setUp() {
        creationalPatterns = new CreationalPatterns();
    }

    @Test
    void execute() {
        simulateUserInput("0");
        creationalPatterns.execute();
        String output = getOutput();
        assertTrue(output.contains("CREATIONAL PATTERNS"));
    }

    @Test
    void getName() {
        assertEquals("Creational patterns", creationalPatterns.getName());
    }

}