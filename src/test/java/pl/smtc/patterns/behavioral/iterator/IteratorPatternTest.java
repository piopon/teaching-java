package pl.smtc.patterns.behavioral.iterator;

import org.junit.jupiter.api.Test;
import pl.smtc.base.BaseTestOut;

import static org.junit.jupiter.api.Assertions.*;

class IteratorPatternTest extends BaseTestOut {
    private IteratorPattern iteratorPattern;

    @Override
    protected void setUp() {
        iteratorPattern = new IteratorPattern();
    }

    @Test
    void executeShouldInvokeIteratorPatternExample() {
        iteratorPattern.execute();
        String output = getOutput();
        assertTrue(output.contains("PLAYLIST:"));
        assertTrue(output.contains("* Queen - Bohemian Rhapsody [album: Greatest Hits]"));
        assertTrue(output.contains("* Queen - Another One Bites the Dust [album: Greatest Hits]"));
        assertTrue(output.contains("* Queen - Don't Stop Me Now [album: Greatest Hits]"));
        assertTrue(output.contains("* Queen - We Will Rock You [album: Greatest Hits]"));
        assertTrue(output.contains("* Eminem - Stan [album: The Marshall Mathers LP]"));
        assertTrue(output.contains("* Eminem - The Way I Am [album: The Marshall Mathers LP]"));
        assertTrue(output.contains("* Eminem - The Real Slim Shady [album: The Marshall Mathers LP]"));
    }

    @Test
    void getNameShouldReturnIteratorPatternString() {
        assertEquals("Iterator pattern", iteratorPattern.getName());
    }
}