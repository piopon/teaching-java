package pl.smtc.patterns.behavioral.command.actions;

import org.junit.jupiter.api.Test;
import pl.smtc.patterns.behavioral.command.receiver.Editor;
import pl.smtc.patterns.behavioral.command.receiver.IEditor;

import static org.junit.jupiter.api.Assertions.*;

class ItalicTextCommandTest {
    private final static String START_TEXT = "start text";
    private final static String END_TEXT = "[i]start text[/i]";

    @Test
    void executeShouldAddItalicTagsToTextEditor() {
        IEditor testEditor = new Editor(START_TEXT);
        ItalicTextCommand testCommand = new ItalicTextCommand(testEditor);
        testCommand.execute();
        assertEquals(END_TEXT, testEditor.getText());
    }

    @Test
    void unexecuteShouldUndoLastAddedItalicTagsToTextEditor() {
        IEditor testEditor = new Editor(START_TEXT);
        ItalicTextCommand testCommand = new ItalicTextCommand(testEditor);
        testCommand.execute();
        testCommand.unexecute();
        assertEquals(START_TEXT, testEditor.getText());
    }
}