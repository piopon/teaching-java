package pl.smtc.basics.flow;

import org.junit.jupiter.api.Test;
import pl.smtc.base.BaseTestInOut;

import static org.junit.jupiter.api.Assertions.*;

class ControlFlowTest extends BaseTestInOut {
    private ControlFlow controlFlowMenu;

    @Override
    protected void setUp() {
        controlFlowMenu = new ControlFlow();
    }

    @Test
    void executeShouldInvokeControlFlowMenu() {
        simulateUserInput("0");
        controlFlowMenu.execute();
        String output = getOutput();
        assertTrue(output.contains("CONTROL FLOW"));
        assertTrue(output.contains("1) If-ElseIf-Else statement"));
        assertTrue(output.contains("2) Switch-Case statement"));
        assertTrue(output.contains("3) For loop"));
        assertTrue(output.contains("4) While loop"));
        assertTrue(output.contains("5) Do-While loop"));
        assertTrue(output.contains("6) Break from loop"));
        assertTrue(output.contains("7) Continue loop from start"));
        assertTrue(output.contains("8) Return from loop"));
    }

    @Test
    void getNameShouldReturnControlFlowString() {
        assertEquals("Control flow", controlFlowMenu.getName());
    }
}