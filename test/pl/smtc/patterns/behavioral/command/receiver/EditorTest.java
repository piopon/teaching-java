package pl.smtc.patterns.behavioral.command.receiver;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EditorTest {
    private String startText = "start_state";
    private Editor editor = new Editor(startText);

    @Test
    void setText() {
        String newText = "set_text_state";
        editor.setText(newText);
        assertEquals(newText, editor.getText());
    }

    @Test
    void getText() {
        assertEquals(startText, editor.getText());
    }
}