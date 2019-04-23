package pl.smtc.patterns.structural.bridge;

import org.junit.jupiter.api.Test;
import pl.smtc.base.BaseTestOut;

import static org.junit.jupiter.api.Assertions.*;

class BridgePatternTest extends BaseTestOut {
    private BridgePattern bridgePattern;

    @Override
    protected void setUp() {
        bridgePattern = new BridgePattern();
    }

    @Test
    void executeShouldInvokeBridgePatternExample() {
        bridgePattern.execute();
        String output = getOutput();
        assertTrue(output.contains("HERO [SOLDIER] moving towards enemy!"));
        assertTrue(output.contains("HERO [SOLDIER] attacking with RIFLE => added 170HP"));
        assertTrue(output.contains("VILLAIN [INFILTRATOR] attacking with PISTOL => added 30HP"));
        assertTrue(output.contains("SIDEKICK [ENGINEER] moving towards enemy!"));
        assertTrue(output.contains("SIDEKICK [ENGINEER] attacking with BIONIC => added 50HP"));
    }

    @Test
    void getNameShouldReturnBridgePatternString() {
        assertEquals("Bridge pattern", bridgePattern.getName());
    }
}