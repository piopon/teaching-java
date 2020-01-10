package pl.smtc.patterns.behavioral.command.actions;

import org.junit.jupiter.api.Test;
import pl.smtc.patterns.behavioral.command.receiver.Editor;
import pl.smtc.patterns.behavioral.command.receiver.IEditor;

import static org.junit.jupiter.api.Assertions.*;

class UnderlineTextCommandTest {
    private final static String START_TEXT = "start text";
    private final static String END_TEXT = "[u]start text[/u]";

    @Test
    void executeShouldAddUnderlineTagsToTextEditor() {
        IEditor testEditor = new Editor(START_TEXT);
        UnderlineTextCommand testCommand = new UnderlineTextCommand(testEditor);
        testCommand.execute();
        assertEquals(END_TEXT, testEditor.getText());
    }

    @Test
    void unexecuteShouldUndoLastAddedUnderlineTagsToTextEditor() {
        IEditor testEditor = new Editor(START_TEXT);
        UnderlineTextCommand testCommand = new UnderlineTextCommand(testEditor);
        testCommand.execute();
        testCommand.unexecute();
        assertEquals(START_TEXT, testEditor.getText());
    }
}