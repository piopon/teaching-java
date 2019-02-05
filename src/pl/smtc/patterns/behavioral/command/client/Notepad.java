package pl.smtc.patterns.behavioral.command.client;

import pl.smtc.patterns.behavioral.command.actions.AddTextCommand;
import pl.smtc.patterns.behavioral.command.actions.BoldTextCommand;
import pl.smtc.patterns.behavioral.command.actions.ItalicTextCommand;
import pl.smtc.patterns.behavioral.command.actions.UnderlineTextCommand;
import pl.smtc.patterns.behavioral.command.invokers.CommandManager;
import pl.smtc.patterns.behavioral.command.receiver.Editor;

public class Notepad {
    private CommandManager commandManager = new CommandManager();
    private Editor textEditor = new Editor("");

    public void add(String newText) {
        commandManager.exe(new AddTextCommand(textEditor, newText));
    }

    public void bold() {
        commandManager.exe(new BoldTextCommand(textEditor));
    }

    public void italic() {
        commandManager.exe(new ItalicTextCommand(textEditor));
    }

    public void underline() {
        commandManager.exe(new UnderlineTextCommand(textEditor));
    }

    public void undo() {
        commandManager.undo();
    }

    public void redo() {
        commandManager.redo();
    }

    public void showOutput() {
        System.out.println(textEditor.getText());
    }
}
