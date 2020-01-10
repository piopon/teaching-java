package pl.smtc.patterns.structural.composite.support;

public class FileCommand {
    private String commandName;
    private String commandValue;

    public FileCommand(String fullCommand) {
        int whitespaceIndex = fullCommand.indexOf(" ");
        commandName = whitespaceIndex < 0 ? fullCommand : fullCommand.substring(0, whitespaceIndex);
        if (whitespaceIndex < commandName.length()) {
            commandValue = "";
        } else {
            commandValue = fullCommand.substring(whitespaceIndex + 1);
        }
    }

    public String getName() {
        return commandName;
    }

    public String getValue() {
        return commandValue;
    }
}
