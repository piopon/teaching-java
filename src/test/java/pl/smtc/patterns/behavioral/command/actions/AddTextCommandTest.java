package pl.smtc.patterns.behavioral.command.actions;

import org.junit.jupiter.api.Test;
import pl.smtc.patterns.behavioral.command.receiver.Editor;
import pl.smtc.patterns.behavioral.command.receiver.IEditor;

import static org.junit.jupiter.api.Assertions.*;

class AddTextCommandTest {
    private final static String START_TEXT = "start";
    private final static String ADD_TEXT = "&new";

    @Test
    void executeShouldAddTextToEditor() {
        IEditor testEditor = new Editor(START_TEXT);
        AddTextCommand testCommand = new AddTextCommand(testEditor, ADD_TEXT);
        testCommand.execute();
        assertEquals(START_TEXT + ADD_TEXT, testEditor.getText());
    }

    @Test
    void unexecuteShouldUndoLastAddedTextToEditor() {
        IEditor testEditor = new Editor(START_TEXT);
        AddTextCommand testCommand = new AddTextCommand(testEditor, ADD_TEXT);
        testCommand.execute();
        testCommand.unexecute();
        assertEquals(START_TEXT, testEditor.getText());
    }
}