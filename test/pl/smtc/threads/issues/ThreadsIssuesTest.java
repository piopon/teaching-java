package pl.smtc.threads.issues;

import org.junit.jupiter.api.Test;
import pl.smtc.base.BaseTestInOut;

import static org.junit.jupiter.api.Assertions.*;

class ThreadsIssuesTest extends BaseTestInOut {
    ThreadsIssues threadsIssues;

    @Override
    protected void setUp() {
        threadsIssues = new ThreadsIssues();
    }

    @Test
    void execute() {
        simulateUserInput("0");
        threadsIssues.execute();
        String output = getOutput();
        assertTrue(output.contains("THREADS ISSUES"));
        assertTrue(output.contains("1) Race condition"));
        assertTrue(output.contains("2) Nested monitor lockout"));
        assertTrue(output.contains("3) Threads deadlock"));
        assertTrue(output.contains("4) Thread starvation"));
        assertTrue(output.contains("5) Slipped conditions"));
        assertTrue(output.contains("6) Threads livelock"));
    }

    @Test
    void getNameShouldReturnThreadsIssues() {
        assertEquals("Threads issues", threadsIssues.getName());
    }
}