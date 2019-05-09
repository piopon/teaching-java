package pl.smtc.patterns.structural.composite;

import pl.smtc.menu.ConsoleExample;
import pl.smtc.patterns.structural.composite.support.FileCommand;
import pl.smtc.patterns.structural.composite.support.FileManager;

import java.util.*;

public class CompositePattern implements ConsoleExample {

    @Override
    public void execute() {
        Scanner input = new Scanner(System.in);
        FileManager fileManager = new FileManager();
        FileCommand currentCommand;
        do {
            System.out.print("> user@" + fileManager.getCurrentDir() + ": ");
            String cmdString = input.nextLine().toLowerCase();
            currentCommand = new FileCommand(cmdString);
        } while (!fileManager.executeCommand(currentCommand));
    }

    @Override
    public String getName() {
        return "Composite pattern";
    }
}
