package pl.smtc.patterns.behavioral.command.receiver;

public class Editor implements IEditor {
    private String editorText;

    public Editor(String text) {
        this.editorText = text;
    }

    public void setText(String text) {
        editorText = text;
    }

    public String getText() {
        return editorText;
    }
}
