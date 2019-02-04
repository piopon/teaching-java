package pl.smtc.patterns.behavioral.command.actions;

import pl.smtc.patterns.behavioral.command.receiver.IEditor;

public class ItalicTextCommand implements ICommand {
    private static final String START_TAG = "[i]";
    private static final String END_TAG = "[/i]";
    private IEditor editor;

    public ItalicTextCommand(IEditor editor) {
        this.editor = editor;
    }

    @Override
    public void execute() {
        editor.setText(START_TAG + editor.getText() + END_TAG);
    }

    @Override
    public void unexecute() {
        String currentText = editor.getText();
        editor.setText(currentText.substring(START_TAG.length(), currentText.length() - END_TAG.length()));
    }
}
