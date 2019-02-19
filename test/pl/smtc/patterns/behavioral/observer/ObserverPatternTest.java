package pl.smtc.patterns.behavioral.observer;

import org.junit.jupiter.api.Test;
import pl.smtc.base.BaseTestOut;

import static org.junit.jupiter.api.Assertions.*;

class ObserverPatternTest extends BaseTestOut {
    private ObserverPattern observerPattern;

    @Override
    protected void setUp() {
        observerPattern = new ObserverPattern();
    }

    @Test
    void execute() {
        observerPattern.execute();
        String output = getOutput();
        assertTrue(output.contains("Added observer: PHONE [subscribers: 1]"));
        assertTrue(output.contains("* PHONE - weather update: temp = 20.1, wind = 0.0"));
        assertTrue(output.contains("Added observer: PC [subscribers: 2]"));
        assertTrue(output.contains("Added observer: WEB [subscribers: 3]"));
        assertTrue(output.contains("* PHONE - weather update: temp = 20.1, wind = 1.2"));
        assertTrue(output.contains("* PC - weather update: temp = 20.1, wind = 1.2"));
        assertTrue(output.contains("* WEB - weather update: temp = 20.1, wind = 1.2"));
        assertTrue(output.contains("Removed observer: PHONE [subscribers: 2]"));
        assertTrue(output.contains("* PC - weather update: temp = 19.2, wind = 1.2"));
        assertTrue(output.contains("* WEB - weather update: temp = 19.2, wind = 1.2"));
    }

    @Test
    void getName() {
        assertEquals("Observer pattern", observerPattern.getName());
    }

}