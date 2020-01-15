package pl.smtc.patterns.behavioral.strategy;

import org.junit.jupiter.api.Test;
import pl.smtc.base.BaseTestOut;

import static org.junit.jupiter.api.Assertions.*;

class StrategyPatternTest extends BaseTestOut {
    private StrategyPattern strategyPattern;

    @Override
    protected void setUp() {
        strategyPattern = new StrategyPattern();
    }

    @Test
    void executeShouldInvokeStrategyPatternExample() {
        strategyPattern.execute();
        String output = getOutput();
        assertTrue(output.contains("* ABB IRB-1600L"));
        assertTrue(output.contains("  Linear move to linearPosition [speed: 300mm/s]"));
        assertTrue(output.contains("* Kawasaki ZH100U"));
        assertTrue(output.contains("  Joint move to destJoint [speed: 100deg/s]"));
        assertTrue(output.contains("* Model robot R2D2"));
        assertTrue(output.contains("  Move not supported."));
        assertTrue(output.contains("* Kawasaki ZH100U"));
        assertTrue(output.contains("  Circular move to dest by mid [speed: 150mm/s]"));
        assertTrue(output.contains("* IRobot Roomba 980"));
        assertTrue(output.contains("  Linear move to clean [speed: 25mm/s]"));
    }

    @Test
    void getNameShouldReturnStrategyPatternString() {
        assertEquals("Strategy pattern", strategyPattern.getName());
    }
}