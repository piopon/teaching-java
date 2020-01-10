package pl.smtc.patterns.behavioral.template;

import org.junit.jupiter.api.Test;
import pl.smtc.base.BaseTestOut;

import static org.junit.jupiter.api.Assertions.*;

class TemplateMethodPatternTest extends BaseTestOut {
    private TemplateMethodPattern templateMethodPattern;

    @Override
    protected void setUp() {
        templateMethodPattern = new TemplateMethodPattern();
    }

    @Test
    void executeShouldInvokeTemplateMethodPatternExample() {
        templateMethodPattern.execute();
        String output = getOutput();
        assertTrue(output.contains("------------------"));
        assertTrue(output.contains("Inserted new disc: Avatar"));
        assertTrue(output.contains("Spinning disc with BluRay speed: 4X."));
        assertTrue(output.contains("Turning 405nm laser on. Reading data from BluRay disc."));
        assertTrue(output.contains("Playing HD movie from BluRay disc."));
        assertTrue(output.contains("Inserted new disc: 8. Mile"));
        assertTrue(output.contains("Spinning disc with default speed: 8X."));
        assertTrue(output.contains("Turning 650nm laser on. Reading data from DVD-ROM."));
        assertTrue(output.contains("Playing movie from DVD-ROM."));
        assertTrue(output.contains("Inserted new disc: Eminem - Kamikaze"));
        assertTrue(output.contains("Spinning disc with CD-ROM speed: 48X."));
        assertTrue(output.contains("Turning 780nm laser on. Reading data from CD-ROM."));
        assertTrue(output.contains("Playing music from CD-ROM."));
    }

    @Test
    void getNameShouldReturnTemplateMethodPatternString() {
        assertEquals("Template method pattern", templateMethodPattern.getName());
    }
}