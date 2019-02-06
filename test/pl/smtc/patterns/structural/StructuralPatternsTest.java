package pl.smtc.patterns.structural;

import org.junit.jupiter.api.Test;
import pl.smtc.base.BaseTestInOut;
import pl.smtc.patterns.creational.CreationalPatterns;

import static org.junit.jupiter.api.Assertions.*;

class StructuralPatternsTest extends BaseTestInOut {
    private StructuralPatterns structuralPatterns;

    @Override
    protected void setUp() {
        structuralPatterns = new StructuralPatterns();
    }

    @Test
    void execute() {
        simulateUserInput("0");
        structuralPatterns.execute();
        String output = getOutput();
        assertTrue(output.contains("STRUCTURAL PATTERNS"));
    }

    @Test
    void getName() {
        assertEquals("Structural patterns", structuralPatterns.getName());
    }
}