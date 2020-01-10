package pl.smtc.patterns.behavioral.command;

import pl.smtc.menu.ConsoleExample;
import pl.smtc.patterns.behavioral.command.client.Notepad;

public class CommandPattern implements ConsoleExample {

    @Override
    public void execute() {
        Notepad notepad = new Notepad();
        System.out.println("COMMAND PATTERN OUTPUT:");
        printPredefinedExample(notepad);
    }

    @Override
    public String getName() {
        return "Command pattern";
    }

    private void printPredefinedExample(final Notepad notepad) {
        notepad.add("command");
        notepad.add("_");
        notepad.undo();
        notepad.add(" pattern");
        notepad.italic();
        notepad.undo();
        notepad.bold();
        notepad.add("_output");
        notepad.undo();
        notepad.redo();
        notepad.add("!");
        notepad.underline();
        notepad.showOutput();
        System.out.println(System.lineSeparator());
    }
}
