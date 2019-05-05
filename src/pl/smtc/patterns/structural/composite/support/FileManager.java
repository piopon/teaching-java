package pl.smtc.patterns.structural.composite.support;

import pl.smtc.patterns.structural.composite.components.File;
import pl.smtc.patterns.structural.composite.components.Folder;

import java.util.Map;
import java.util.function.Consumer;

public class FileManager {
    private final Map<String, Consumer<String>> availableCommands = createCommands();
    private final Folder root = new Folder("root", null);
    private boolean exitStatus = false;
    private Folder currentDir = root;

    public boolean executeCommand(FileCommand command) {
        if(availableCommands.containsKey(command.getName())) {
            availableCommands.get(command.getName()).accept(command.getValue());
        } else {
            System.out.println("UNKNOWN COMMAND!");
        }
        return exitStatus;
    }

    public String getCurrentDir() {
        return currentDir.getName();
    }

    private Map<String, Consumer<String>> createCommands() {
        return Map.of("file", this::createFile,
                "dir", this::createDir,
                "show", this::printDir,
                "cd", this::changeDir,
                "exit", this::exit);
    }

    private void createFile(String fileName) {
        if (!fileName.isEmpty()) {
            currentDir.add(new File(fileName, currentDir));
        } else {
            System.out.println("Error: no file name inputted!");
        }
    }

    private void createDir(String dirName) {
        if (!dirName.isEmpty()) {
            currentDir.add(new Folder(dirName, currentDir));
        } else {
            System.out.println("Error: no directory name inputted!");
        }
    }

    private void changeDir(String dirName) {
        try {
            if (dirName.equals("~")) {
                currentDir = root;
            }
            if (!dirName.isEmpty()) {
                currentDir = currentDir.getDirectory(dirName);
            } else {
                System.out.println("Error: no directory name inputted!");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private void printDir(String command) {
        currentDir.print(0);
    }

    private void exit(String command) {
        exitStatus = true;
    }
}
