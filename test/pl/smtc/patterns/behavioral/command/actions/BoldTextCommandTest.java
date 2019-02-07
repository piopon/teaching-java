package pl.smtc.patterns.behavioral.command.actions;

import org.junit.jupiter.api.Test;
import pl.smtc.patterns.behavioral.command.receiver.Editor;
import pl.smtc.patterns.behavioral.command.receiver.IEditor;

import static org.junit.jupiter.api.Assertions.*;

class BoldTextCommandTest {
    private final static String START_TEXT = "start text";
    private final static String END_TEXT = "[b]start text[/b]";

    @Test
    void executeShouldAddBoldTagsToTextEditor() {
        IEditor testEditor = new Editor(START_TEXT);
        BoldTextCommand testCommand = new BoldTextCommand(testEditor);
        testCommand.execute();
        assertEquals(END_TEXT, testEditor.getText());
    }

    @Test
    void unexecuteShouldUndoLastAddedBoldTagsToTextEditor() {
        IEditor testEditor = new Editor(START_TEXT);
        BoldTextCommand testCommand = new BoldTextCommand(testEditor);
        testCommand.execute();
        testCommand.unexecute();
        assertEquals(START_TEXT, testEditor.getText());
    }
}