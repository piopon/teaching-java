package pl.smtc.threads.issues;

import pl.smtc.menu.ConsoleExample;
import pl.smtc.menu.ConsoleMenu;
import pl.smtc.threads.issues.deadlock.ThreadsDeadlock;
import pl.smtc.threads.issues.livelock.ThreadsLivelock;
import pl.smtc.threads.issues.lockout.NestedLockout;
import pl.smtc.threads.issues.race.RaceCondition;
import pl.smtc.threads.issues.slip.SlipConditions;
import pl.smtc.threads.issues.starvation.ThreadsStarvation;

import java.util.HashMap;
import java.util.Map;

public class ThreadsIssues implements ConsoleExample {
    private Map<Integer, ConsoleExample> issuesExamples = new HashMap<>();
    private int menuWidth = 35;

    @Override
    public void execute() {
        addExamples(new RaceCondition(), new NestedLockout(), new ThreadsDeadlock(),
                    new ThreadsStarvation(), new SlipConditions(), new ThreadsLivelock());

        ConsoleMenu issuesMenu = new ConsoleMenu(getName(), menuWidth, issuesExamples);
        issuesMenu.show();
    }

    @Override
    public String getName() {
        return "Threads issues";
    }

    private void addExamples(ConsoleExample... exercises) {
        for(int i = 0; i < exercises.length; i++) {
            issuesExamples.put(i, exercises[i]);
        }
    }
}
