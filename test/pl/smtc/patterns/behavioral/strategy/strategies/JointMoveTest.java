package pl.smtc.patterns.behavioral.strategy.strategies;

import org.junit.jupiter.api.Test;
import pl.smtc.base.BaseTestOut;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class JointMoveTest extends BaseTestOut {
    private static final List<String> SINGLE_POS = createPositions("destination");
    private static final List<String> MULTIPLE_POS = createPositions("pos1", "pos2");
    private JointMove moveUnderTest;

    @Override
    protected void setUp() {
        moveUnderTest = new JointMove();
    }

    @Test
    void setPositionsShouldFillMovePositionsTable() {
        moveUnderTest.setPositions(MULTIPLE_POS);
        assertEquals(2, moveUnderTest.positions.size());
        assertEquals("pos1", moveUnderTest.positions.get(0));
        assertEquals("pos2", moveUnderTest.positions.get(1));
    }

    @Test
    void setSpeedShouldFillMoveSpeedField() {
        moveUnderTest.setSpeed(100);
        assertEquals(100, moveUnderTest.speed);
    }

    @Test
    void getTypeShouldReturnMoveJString() {
        assertEquals("MoveJ", moveUnderTest.getType());
    }


    @Test
    void moveShouldInvokeCircularAlgorithmIfInputIsCorrect() {
        moveUnderTest.setPositions(SINGLE_POS);
        moveUnderTest.setSpeed(90);
        moveUnderTest.move();
        String output = getOutput();
        assertTrue(output.contains("Joint move to destination [speed: 90deg/s]"));
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