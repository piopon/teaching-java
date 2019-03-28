package pl.smtc.patterns.creational.Singleton.implementations;

import java.util.ArrayList;
import java.util.List;

public class ApplicationLogger {
    private static ApplicationLogger instance;
    private List<Message> messages;
    private int logCapacity;

    private ApplicationLogger() {
        logCapacity = 10;
        messages = new ArrayList<>(logCapacity);
    }

    public static ApplicationLogger getInstance() {
        if (instance == null) {
            instance = new ApplicationLogger();
        }
        return instance;
    }

    public void logError(String message) {
        log(LogType.ERROR, message);
    }

    public void logWarning(String message) {
        log(LogType.WARNING, message);
    }

    public void logInfo(String message) {
        log(LogType.INFO, message);
    }

    public void printLastMessages() {
        for(int i = 0; i < messages.size(); i++) {
            System.out.println(i + 1 + ") " + messages.get(i));
        }
    }

    private void log(LogType type, String message) {
        Message logMessage = new Message(type, message);
        putMessage(logMessage);
        System.out.println(logMessage);
    }

    private void putMessage(Message message) {
        if (messages.size() >= logCapacity) {
            for (int i = 0; i < messages.size() - 1; i++) {
                messages.set(i, messages.get(i+1));
            }
            messages.set(logCapacity - 1, message);
        } else {
            messages.add(message);
        }
    }

    private enum LogType {
        ERROR, WARNING, INFO
    }

    private class Message {
        private String text;
        private LogType type;

        public Message(LogType type, String text) {
            this.text = text;
            this.type = type;
        }

        @Override
        public String toString() {
            return type + ": " + text;
        }
    }
}
