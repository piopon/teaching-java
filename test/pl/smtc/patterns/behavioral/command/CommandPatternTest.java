package pl.smtc.patterns.behavioral.command;

import org.junit.jupiter.api.Test;
import pl.smtc.base.BaseTestOut;

import static org.junit.jupiter.api.Assertions.*;

class CommandPatternTest extends BaseTestOut {
    private CommandPattern commandPattern;

    @Override
    protected void setUp() {
        commandPattern = new CommandPattern();
    }

    @Test
    void executeShouldInvokeCommandPatternExample() {
        commandPattern.execute();
        String output = getOutput();
        assertTrue(output.contains("COMMAND PATTERN OUTPUT:"));
        assertTrue(output.contains("[u][b]command pattern[/b]_output![/u]"));
    }

    @Test
    void getNameShouldReturnCommandPatternString() {
        assertEquals("Command pattern", commandPattern.getName());
    }
}