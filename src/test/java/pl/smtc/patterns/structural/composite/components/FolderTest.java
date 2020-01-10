package pl.smtc.patterns.structural.composite.components;

import org.junit.jupiter.api.Test;
import pl.smtc.base.BaseTestOut;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class FolderTest extends BaseTestOut {
    private final static String DIR_NAME = "testDirName";
    private final Folder parent = new Folder("parent", null);
    private Folder testDir;

    @Override
    protected void setUp() {
        testDir = new Folder(DIR_NAME, parent);
    }

    @Test
    void printShouldOutputFolderNameWithDirInfo() {
        testDir.print(0);
        String output = getOutput();
        assertTrue(output.contains("- " + DIR_NAME + "  [dir]"));
    }

    @Test
    void getNameShouldReturnTestFolderName() {
        assertEquals(DIR_NAME, testDir.getName());
    }

    @Test
    void getParentShouldReturnTestFolderParent() {
        assertEquals(parent, testDir.getParent());
    }

    @Test
    void addShouldAddChildrenComponentsToTestDirectory() {
        File childFile = new File("childFile", testDir);
        testDir.add(childFile);
        Folder childDir = new Folder("childDir", testDir);
        testDir.add(childDir);
        assertEquals(2, testDir.contents.size());
        assertEquals(childFile, testDir.contents.get(0));
        assertEquals(childDir, testDir.contents.get(1));
    }

    @Test
    void getDirectoryShouldReturnTestDirectoryIfDotInputted() {
        assertEquals(testDir, testDir.getDirectory("."));
    }

    @Test
    void getDirectoryShouldReturnParentIfDoubleDotInputted() {
        assertEquals(parent, testDir.getDirectory(".."));
    }

    @Test
    void getDirectoryShouldReturnChildDirectoryIfExistent() {
        Folder childDir = new Folder("childDir", testDir);
        testDir.add(childDir);
        assertEquals(childDir, testDir.getDirectory("childDir"));
    }

    @Test
    void getDirectoryShouldThrowIfInputtedElementIsAFile() {
        File childFile = new File("childFile", testDir);
        testDir.add(childFile);
        assertThrows(IllegalArgumentException.class, () -> testDir.getDirectory("childFile"));
    }

    @Test
    void getDirectoryShouldThrowIfInputtedDirectoryDoesNotExist() {
        Folder childDir = new Folder("childDir", testDir);
        testDir.add(childDir);
        assertThrows(IllegalArgumentException.class, () -> testDir.getDirectory("notExistentDir"));
    }

}