package pl.smtc.patterns.structural.composite.support;

import org.junit.jupiter.api.Test;
import pl.smtc.patterns.structural.composite.components.File;

import static org.junit.jupiter.api.Assertions.*;

class FileCommandTest {
    private FileCommand testCommand;

    @Test
    void getNameShouldReturnFirstComponentIfCommandContainsKeyValue() {
        testCommand = new FileCommand("test command");
        assertEquals("test", testCommand.getName());
    }

    @Test
    void getNameShouldReturnFirstComponentIfCommandContainsOnlyKey() {
        testCommand = new FileCommand("testCommand");
        assertEquals("testCommand", testCommand.getName());
    }

    @Test
    void getValueShouldReturnSecondComponentIfCommandContainsKeyValue() {
        testCommand = new FileCommand("test command");
        assertEquals("command", testCommand.getValue());
    }

    @Test
    void getNameShouldReturnEmptyStringIfCommandContainsOnlyKey() {
        testCommand = new FileCommand("testCommand");
        assertEquals("", testCommand.getValue());
    }
}