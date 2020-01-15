package pl.smtc.patterns.structural.composite;

import org.junit.jupiter.api.Test;
import pl.smtc.base.BaseTestInOut;

import static org.junit.jupiter.api.Assertions.*;

class CompositePatternTest extends BaseTestInOut {
    private CompositePattern compositePattern;

    @Override
    protected void setUp() {
        compositePattern = new CompositePattern();
    }

    @Test
    void executeShouldInvokeCompositePatternExample() {
        String rootCreate = "dir folder1, file file2";
        String childCreate = "cd folder1, dir folder11, file file12";
        String showAndExit = "cd ., cd .., show, exit";
        simulateCommaInput(rootCreate + ", " + childCreate + ", " + showAndExit);
        compositePattern.execute();
        String output = getOutput();
        assertTrue(output.contains("> user@root:"));
        assertTrue(output.contains("> user@folder1:"));
        assertTrue(output.contains("- root  [dir]"));
        assertTrue(output.contains("  - folder1  [dir]"));
        assertTrue(output.contains("    - folder11  [dir]"));
        assertTrue(output.contains("    - file12 ["));
        assertTrue(output.contains("  - file2 ["));
    }

    @Test
    void getNameShouldReturnCompositePatternString() {
        assertEquals("Composite pattern", compositePattern.getName());
    }


}