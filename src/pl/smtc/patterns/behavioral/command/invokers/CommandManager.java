package pl.smtc.patterns.behavioral.command.invokers;

import pl.smtc.patterns.behavioral.command.actions.ICommand;

import java.util.ArrayList;
import java.util.List;

public class CommandManager {
    protected List<ICommand> history = new ArrayList<>();
    protected int lastCommand = -1;

    public void exe(ICommand command) {
        lastCommand++;
        history.add(command);
        if (lastCommand != history.size()-1) {
            history.remove(lastCommand);
        }
        command.execute();
    }

    public void undo() {
        if (lastCommand > 0) {
            history.get(lastCommand).unexecute();
            lastCommand--;
        }
    }

    public void redo() {
        if (lastCommand < history.size()-1) {
            lastCommand++;
            history.get(lastCommand).execute();
        }
    }

}
