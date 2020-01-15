package pl.smtc.threads.comm;

import pl.smtc.menu.ConsoleExample;
import pl.smtc.menu.ConsoleMenu;
import pl.smtc.threads.comm.advanced.ProducerConsumer;
import pl.smtc.threads.comm.basic.BasicComm;
import pl.smtc.threads.comm.callable.ImplementsCallable;
import pl.smtc.threads.comm.future.CallableAndFuture;
import pl.smtc.threads.comm.low_level.LowLevelComm;

import java.util.HashMap;
import java.util.Map;

public class ThreadsCommunication implements ConsoleExample {
    private Map<Integer, ConsoleExample> communicationExamples = new HashMap<>();
    private final int menuWidth = 35;

    @Override
    public void execute() {
        addExamples(new BasicComm(), new ImplementsCallable(), new CallableAndFuture(),
                    new ProducerConsumer(), new LowLevelComm());

        ConsoleMenu communicationMenu = new ConsoleMenu(getName(), menuWidth, communicationExamples);
        communicationMenu.show();
    }

    @Override
    public String getName() {
        return "Threads communication";
    }

    private void addExamples(ConsoleExample... exercises) {
        for(int i = 0; i < exercises.length; i++) {
            communicationExamples.put(i, exercises[i]);
        }
    }
}
