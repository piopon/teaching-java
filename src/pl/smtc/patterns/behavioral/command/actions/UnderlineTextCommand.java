package pl.smtc.patterns.behavioral.command.actions;

import pl.smtc.patterns.behavioral.command.receiver.IEditor;

public class UnderlineTextCommand implements ICommand {
    private static final String START_TAG = "[u]";
    private static final String END_TAG = "[/u]";
    private IEditor editor;

    public UnderlineTextCommand(IEditor editor) {
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
