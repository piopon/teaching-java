package pl.smtc.recursion.directories;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintStream;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

class TreeExplorerTest {
    private static TreeExplorer treeExplorer;
    private static Path sourceDir;
    private static final ByteArrayOutputStream OUTPUT_STREAM = new ByteArrayOutputStream();

    @BeforeAll
    static void setup() {
        treeExplorer = new TreeExplorer();
        System.setOut(new PrintStream(OUTPUT_STREAM));
        sourceDir = Paths.get(new File("").getAbsolutePath(), "src", "pl", "smtc", "recursion");
    }

    @AfterAll
    static void tearDown() {
        System.setOut(System.out);
        OUTPUT_STREAM.reset();
    }

    @Test
    void executeOutputsCurrentDirAndStructure() {
        treeExplorer.execute();
        String output = OUTPUT_STREAM.toString();
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
        String output = OUTPUT_STREAM.toString();
        assertFalse(output.isEmpty());
    }

    @Test
    void scanDirectoryOutputsCorrectDirectoryStructure() {
        treeExplorer.scanDirectory(sourceDir.toString());
        String output = OUTPUT_STREAM.toString();
        assertTrue(output.contains("directories"));
        assertTrue(output.contains("TreeExplorer.java"));
        assertTrue(output.contains("TreeFormatter.java"));
        assertTrue(output.contains("RecursionExamples.java"));
    }
}