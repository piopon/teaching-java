package pl.smtc.patterns.structural.composite.support;

import org.junit.jupiter.api.Test;
import pl.smtc.base.BaseTestOut;

import static org.junit.jupiter.api.Assertions.*;

class FileManagerTest extends BaseTestOut {
    private FileManager fileManager;

    @Override
    protected void setUp() {
        fileManager = new FileManager();
    }

    @Test
    void executeCommandShouldReturnFalseAndShowErrorIfBadInput() {
        FileCommand testCommand = new FileCommand("unknown command");
        assertFalse(fileManager.executeCommand(testCommand));
        String output = getOutput();
        assertTrue(output.contains("UNKNOWN COMMAND!"));
    }

    @Test
    void executeCommandShouldReturnFalseAndOutputCommandStatusIfCorrectInput() {
        FileCommand testCommand = new FileCommand("show");
        assertFalse(fileManager.executeCommand(testCommand));
        String output = getOutput();
        assertTrue(output.contains("- root  [dir]"));
    }

    @Test
    void executeCommandShouldReturnTrueIfExitInput() {
        FileCommand testCommand = new FileCommand("exit");
        assertTrue(fileManager.executeCommand(testCommand));
    }

    @Test
    void getCurrentDirShouldReturnCurrentDirectory() {
        assertEquals("root", fileManager.getCurrentDir());
    }

}