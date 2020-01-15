package pl.smtc.threads.issues.race;

import org.junit.jupiter.api.Test;
import pl.smtc.base.BaseTestOut;

import static org.junit.jupiter.api.Assertions.*;

class IterateTest extends BaseTestOut {
    Iterate iterate;

    @Override
    protected void setUp() {
        iterate = new Iterate(5);
    }

    @Test
    void iterateStartsIncrementingInitialValue() {
        String iterateTitle = "testIterate";
        iterate.iterate(iterateTitle);
        String output = getOutput();
        assertTrue(output.contains(iterateTitle + " -> START"));
        assertTrue(output.contains(iterateTitle + " -> counter: 1"));
        assertTrue(output.contains(iterateTitle + " -> counter: 2"));
        assertTrue(output.contains(iterateTitle + " -> counter: 3"));
        assertTrue(output.contains(iterateTitle + " -> counter: 4"));
        assertTrue(output.contains(iterateTitle + " -> counter: 5"));
        assertTrue(output.contains(iterateTitle + " -> STOP"));
    }
}