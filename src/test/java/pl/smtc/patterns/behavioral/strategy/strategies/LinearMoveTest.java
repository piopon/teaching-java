package pl.smtc.patterns.behavioral.strategy.strategies;

import org.junit.jupiter.api.Test;
import pl.smtc.base.BaseTestOut;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LinearMoveTest extends BaseTestOut {
    private static final List<String> SINGLE_POS = createPositions("finalPos");
    private static final List<String> MULTIPLE_POS = createPositions("pos1", "pos2");
    private LinearMove moveUnderTest;

    @Override
    protected void setUp() {
        moveUnderTest = new LinearMove();
    }

    @Test
    void setPositionsShouldFillMovePositionsTable() {
        moveUnderTest.setPositions(SINGLE_POS);
        assertEquals(1, moveUnderTest.positions.size());
        assertEquals("finalPos", moveUnderTest.positions.get(0));
    }

    @Test
    void setSpeedShouldFillMoveSpeedField() {
        moveUnderTest.setSpeed(275);
        assertEquals(275, moveUnderTest.speed);
    }

    @Test
    void getTypeShouldReturnMoveLString() {
        assertEquals("MoveL", moveUnderTest.getType());
    }


    @Test
    void moveShouldInvokeCircularAlgorithmIfInputIsCorrect() {
        moveUnderTest.setPositions(SINGLE_POS);
        moveUnderTest.setSpeed(200);
        moveUnderTest.move();
        String output = getOutput();
        assertTrue(output.contains("Linear move to finalPos [speed: 200mm/s]"));
    }

    @Test
    void moveShouldThrowErrorIfBadNumberOfPositionsWasInputted() {
        InvalidParameterException exception = assertThrows(InvalidParameterException.class, () -> {
            moveUnderTest.setPositions(MULTIPLE_POS);
            moveUnderTest.setSpeed(350);
            moveUnderTest.move();
        });
        assertEquals("You must specify one destination point.", exception.getMessage());
    }

    @Test
    void moveShouldThrowErrorIfBadSpeedVariableWasInputted() {
        InvalidParameterException exception = assertThrows(InvalidParameterException.class, () -> {
            moveUnderTest.setPositions(MULTIPLE_POS);
            moveUnderTest.setSpeed(0);
            moveUnderTest.move();
        });
        assertEquals("Speed cannot be zero.", exception.getMessage());
    }

    private static List<String> createPositions(String... positions) {
        return new ArrayList<>(Arrays.asList(positions));
    }
}