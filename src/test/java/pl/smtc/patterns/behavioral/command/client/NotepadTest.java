package pl.smtc.patterns.behavioral.command.client;

import org.junit.jupiter.api.Test;
import pl.smtc.base.BaseTestOut;

import static org.junit.jupiter.api.Assertions.*;

class NotepadTest extends BaseTestOut {
    private Notepad notepad;

    @Override
    protected void setUp() {
        notepad = new Notepad();
        notepad.add("test text");
    }

    @Test
    void addMethodAddsInputTextToNotepad() {
        notepad.add(" with extra one");
        assertEquals("test text with extra one", getOutputText());
    }

    @Test
    void boldMethodAddsBoldTagsToWholeText() {
        notepad.bold();
        assertEquals("[b]test text[/b]", getOutputText());
    }

    @Test
    void italicMethodAddsItalicTagsToWholeText() {
        notepad.italic();
        assertEquals("[i]test text[/i]", getOutputText());
    }

    @Test
    void underlineMethodAddsUnderlineTagsToWholeText() {
        notepad.underline();
        assertEquals("[u]test text[/u]", getOutputText());
    }

    @Test
    void undoBacksUpLastNotepadCommand() {
        notepad.add(" to undo");
        notepad.undo();
        assertEquals("test text", getOutputText());
    }

    @Test
    void redoRepeatsLastUndoneNotepadCommand() {
        notepad.add(" to undo and redo :)");
        notepad.undo();
        notepad.redo();
        assertEquals("test text to undo and redo :)", getOutputText());
    }

    @Test
    void showOutputPrintsOutCurrentNotepadOutput() {
        notepad.showOutput();
        String output = getOutput();
        assertTrue(output.contains("test text"));
    }

    private String getOutputText() {
        notepad.showOutput();
        return getOutput().replace(System.lineSeparator(), "");
    }
}