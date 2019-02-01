package pl.smtc.patterns;

import org.junit.jupiter.api.Test;
import pl.smtc.base.BaseTestInOut;

import static org.junit.jupiter.api.Assertions.*;

class DesignPatternsExamplesTest extends BaseTestInOut {
    private DesignPatternsExamples designPatterns;

    @Override
    protected void setUp() {
        designPatterns = new DesignPatternsExamples();
    }

    @Test
    void execute() {
        simulateUserInput("0");
        designPatterns.execute();
        String output = getOutput();
        assertTrue(output.contains("DESIGN PATTERNS"));
    }

    @Test
    void getName() {
        assertEquals("Design patterns", designPatterns.getName());
    }


}