package pl.smtc.patterns.structural.composite.components;

import org.junit.jupiter.api.Test;
import pl.smtc.base.BaseTestOut;

import static org.junit.jupiter.api.Assertions.*;

class FileTest extends BaseTestOut {
    private final static String FILE_NAME = "testFileName";
    private final Folder parent = new Folder("parent", null);
    private File testFile;

    @Override
    protected void setUp() {
        testFile = new File(FILE_NAME, parent);
    }

    @Test
    void printShouldOutputFileNameWithRandomSizeInKB() {
        testFile.print(0);
        String output = getOutput();
        assertTrue(output.contains("- " + FILE_NAME + " ["));
        assertTrue(output.contains("KB]"));
    }

    @Test
    void getNameShouldReturnTestFileName() {
        assertEquals(FILE_NAME, testFile.getName());
    }

    @Test
    void getParentShouldReturnTestFileParent() {
        assertEquals(parent, testFile.getParent());
    }

}