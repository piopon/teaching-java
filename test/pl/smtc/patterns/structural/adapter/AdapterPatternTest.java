package pl.smtc.patterns.structural.adapter;

import org.junit.jupiter.api.Test;
import pl.smtc.base.BaseTestOut;

import static org.junit.jupiter.api.Assertions.*;

class AdapterPatternTest extends BaseTestOut {
    private AdapterPattern adapterPattern;

    @Override
    protected void setUp() {
        adapterPattern = new AdapterPattern();
    }

    @Test
    void execute() {
        adapterPattern.execute();
        String output = getOutput();
        assertTrue(output.contains("SAMSUNG GALAXY S7 - showing www page: google.com"));
        assertTrue(output.contains("SAMSUNG GALAXY S7 - calling number: 600-000-001 [LTE]"));
        assertTrue(output.contains("SAMSUNG GALAXY S7 - battery empty. Charge it."));
        assertTrue(output.contains("SAMSUNG GALAXY S7 - USB general standard plug inputted. Charging..."));
        assertTrue(output.contains("NOKIA 3310 - calling number: 512-123-456 [EDGE]"));
        assertTrue(output.contains("NOKIA 3310 - battery empty. Charge it."));
        assertTrue(output.contains("Applying USB -> vendor plug adapter."));
        assertTrue(output.contains("NOKIA 3310 - cellphone vendor plug inputted. Charging..."));
    }

    @Test
    void getName() {
        assertEquals("Adapter pattern", adapterPattern.getName());
    }
}