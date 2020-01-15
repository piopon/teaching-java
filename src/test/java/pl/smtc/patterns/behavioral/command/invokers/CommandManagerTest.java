package pl.smtc.patterns.behavioral.command.invokers;

import org.junit.jupiter.api.Test;
import pl.smtc.patterns.behavioral.command.actions.ICommand;
import pl.smtc.patterns.behavioral.command.receiver.Editor;
import pl.smtc.patterns.behavioral.command.receiver.IEditor;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CommandManagerTest {
    private enum CommandId {
        TEST1, TEST2
    }

    private CommandManager commandManager = new CommandManager();
    private Map<CommandId, ICommand>  testCommands = createTestCommands();
    private IEditor testEditor = new Editor("");

    @Test
    void exeShouldInvokeSelectedCommand() {
        commandManager.exe(testCommands.get(CommandId.TEST2));

        assertEquals(1, commandManager.history.size());
        assertEquals(0, commandManager.lastCommand);
        assertEquals("TEST2",testEditor.getText());
    }

    @Test
    void undoShouldRevertLastInvokedCommand() {
        commandManager.exe(testCommands.get(CommandId.TEST1));
        commandManager.exe(testCommands.get(CommandId.TEST2));
        commandManager.undo();

        assertEquals(2, commandManager.history.size());
        assertEquals(0, commandManager.lastCommand);
        assertEquals("TEST1",testEditor.getText());
    }

    @Test
    void redoShouldInvokeLastUndoneCommand() {
        commandManager.exe(testCommands.get(CommandId.TEST1));
        commandManager.exe(testCommands.get(CommandId.TEST2));
        commandManager.undo();
        commandManager.redo();

        assertEquals(2, commandManager.history.size());
        assertEquals(1, commandManager.lastCommand);
        assertEquals("TEST1TEST2",testEditor.getText());
    }

    private Map<CommandId, ICommand> createTestCommands() {
        Map<CommandId, ICommand> result = new HashMap<>();
        result.put(CommandId.TEST1, createCommand(CommandId.TEST1.toString()));
        result.put(CommandId.TEST2, createCommand(CommandId.TEST2.toString()));

        return result;
    }

    private ICommand createCommand(String commandString) {
        return new ICommand() {
            @Override
            public void execute() {
                testEditor.setText(testEditor.getText() + commandString);
            }

            @Override
            public void unexecute() {
                int addedTextPos = testEditor.getText().indexOf(commandString);
                testEditor.setText(testEditor.getText().substring(0, addedTextPos));
            }
        };
    }
}