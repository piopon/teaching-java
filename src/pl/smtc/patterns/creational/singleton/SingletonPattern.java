package pl.smtc.patterns.creational.singleton;

import pl.smtc.menu.ConsoleExample;
import pl.smtc.patterns.creational.singleton.implementations.ApplicationLogger;
import pl.smtc.patterns.creational.singleton.implementations.RemoteResource;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SingletonPattern implements ConsoleExample {
    private static final String EXIT_OPTION = "Q";
    private Map<String, Runnable> options = new HashMap<>();

    @Override
    public void execute() {
        options.put("RESOURCE", this::checkResource);
        options.put("LOGGER", this::checkLogger);
        String decision;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.print("Select option " + getOptions() + ": ");
            decision = scanner.nextLine();
            if (options.containsKey(decision)) {
                options.get(decision).run();
                System.out.print(System.lineSeparator());
            } else if (!userExit(decision)) {
                System.out.println("Unknown command: " + decision);
                System.out.print(System.lineSeparator());
            }
        } while(!userExit(decision));
    }

    @Override
    public String getName() {
        return "Singleton pattern";
    }

    protected void checkResource() {
        if (RemoteResource.getInstance().isOpened()) {
            RemoteResource.getInstance().close();
        }
        RemoteResource resource = RemoteResource.getInstance();
        resource.open();
        resource.send("data1");
        resource.send("data2");
        resource.close();
        resource.send("data3");
    }

    protected void checkLogger() {
        ApplicationLogger logger = ApplicationLogger.getInstance();
        logger.logInfo("info1");
        logger.logWarning("warning2");
        logger.logInfo("info3");
        logger.logError("error4");
        logger.logInfo("info5");
        logger.logWarning("warning6");
        logger.logWarning("warning7");
        logger.logInfo("info8");
        logger.logError("error10");
        logger.logInfo("info9");
        logger.logInfo("info11");
        logger.printLastMessages();
    }

    private String getOptions() {
        String result = options.keySet().toString();

        return result.replace("]", ", " + EXIT_OPTION + "]");
    }

    private boolean userExit(String input) {
        return input.equalsIgnoreCase(EXIT_OPTION);
    }
}
