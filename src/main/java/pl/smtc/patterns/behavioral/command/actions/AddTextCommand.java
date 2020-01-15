package pl.smtc.patterns.behavioral.command.actions;

import pl.smtc.patterns.behavioral.command.receiver.IEditor;

public class AddTextCommand implements ICommand {
    private IEditor editor;
    private String newText;
    private Integer newTextPos;

    public AddTextCommand(IEditor editor, String newText) {
        this.editor = editor;
        this.newText = newText;
        this.newTextPos = editor.getText().length();
    }

    @Override
    public void execute() {
        editor.setText(editor.getText() + newText);
    }

    @Override
    public void unexecute() {
        String text = editor.getText().substring(0, newTextPos);
        editor.setText(text);
    }
}
