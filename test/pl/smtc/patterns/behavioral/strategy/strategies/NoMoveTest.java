package pl.smtc.patterns.behavioral.strategy.strategies;

import org.junit.jupiter.api.Test;
import pl.smtc.base.BaseTestOut;

import static org.junit.jupiter.api.Assertions.*;

class NoMoveTest extends BaseTestOut {
    private NoMove moveUnderTest;

    @Override
    protected void setUp() {
        moveUnderTest = new NoMove();
    }

    @Test
    void moveShouldReturnMoveNotSupportedInformation() {
        moveUnderTest.move();
        String output = getOutput();
        assertTrue(output.contains("Move not supported."));
    }

}