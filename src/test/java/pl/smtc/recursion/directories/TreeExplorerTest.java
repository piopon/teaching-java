package pl.smtc.recursion.directories;

import org.junit.jupiter.api.Test;
import pl.smtc.base.BaseTestOut;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

class TreeExplorerTest extends BaseTestOut {
    private static TreeExplorer treeExplorer;
    private static Path sourceDir;

    @Override
    protected void setUp() {
        treeExplorer = new TreeExplorer();
        sourceDir = Paths.get(new File("").getAbsolutePath(),
                "src", "main", "java", "pl", "smtc", "recursion");
    }

    @Test
    void executeOutputsCurrentDirAndStructure() {
        treeExplorer.execute();
        String output = getOutput();
        assertTrue(output.contains(sourceDir.toString()));
        assertTrue(output.contains("TreeExplorer.java"));
        assertTrue(output.contains("RecursionExamples.java"));
    }

    @Test
    void getNameShouldReturnDirectoryExplorer() {
        String currentName = treeExplorer.getName();
        assertEquals("Directory explorer", currentName);
    }

    @Test
    void getCurrentDirectoryReturnsProjectDirectory() {
        String currentDirectory = treeExplorer.getCurrentDirectory();
        assertEquals(sourceDir.toString(), currentDirectory);
    }

    @Test
    void scanDirectoryOutputsNonEmptyDirectoryStructure() {
        treeExplorer.scanDirectory(sourceDir.toString());
        String output = getOutput();
        assertFalse(output.isEmpty());
    }

    @Test
    void scanDirectoryOutputsCorrectDirectoryStructure() {
        treeExplorer.scanDirectory(sourceDir.toString());
        String output = getOutput();
        assertTrue(output.contains("directories"));
        assertTrue(output.contains("TreeExplorer.java"));
        assertTrue(output.contains("TreeFormatter.java"));
        assertTrue(output.contains("RecursionExamples.java"));
    }
}