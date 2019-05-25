package pl.smtc.patterns.behavioral.state.support;

import java.util.ArrayList;
import java.util.List;

public class PrintQueue {
    private static List<Thread> printList = new ArrayList<>();

    public void push(String document, Thread printThread) {
        printList.add(printThread);
        System.out.println("Added to print queue: " + document);
    }

    public void pop() {
        printList.remove(0);
    }

    public boolean isEmpty() {
        return printList.isEmpty();
    }

    public Thread get(int index) {
        return printList.get(index);
    }

    public void clearQueue() {
        printList.clear();
    }
}
