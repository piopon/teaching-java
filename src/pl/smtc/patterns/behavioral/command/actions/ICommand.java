package pl.smtc.patterns.behavioral.command.actions;

public interface ICommand {
    void execute();

    void unexecute();
}
