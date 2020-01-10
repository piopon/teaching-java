package pl.smtc.patterns.behavioral.strategy.context;

import org.junit.jupiter.api.Test;
import pl.smtc.base.BaseTestOut;
import pl.smtc.patterns.behavioral.strategy.strategies.*;

import static org.junit.jupiter.api.Assertions.*;

class RobotTest extends BaseTestOut {
    private static final String MANUFACTURER = "TestManufacturer";
    private static final String MODEL = "Model1234";
    private Robot testRobot;
    private IMove testMoveL = new LinearMove();
    private IMove testMoveJ = new JointMove();
    private IMove testMoveC = new CircularMove();

    @Override
    protected void setUp() {
        testRobot = new Robot(MANUFACTURER, MODEL);
    }

    @Test
    void configureMovementShouldBindMoveAlgorithmsToSpecificMoveType() {
        testRobot.configureMovement(testMoveL, testMoveJ, testMoveC);
        assertEquals(testMoveL, testRobot.linearMove);
        assertEquals(testMoveJ, testRobot.jointMove);
        assertEquals(testMoveC, testRobot.circularMove);
    }

    @Test
    void moveLShouldInvokeConfiguredMoveAlgorithm() {
        testRobot.configureMovement(testMoveL, testMoveJ, testMoveC);
        testRobot.moveL("posL", 100);
        String output = getOutput();
        assertTrue(output.contains("* " + MANUFACTURER + " " + MODEL));
        assertTrue(output.contains("Linear move to posL [speed: 100mm/s]"));
    }

    @Test
    void moveJShouldInvokeConfiguredMoveAlgorithm() {
        testRobot.configureMovement(testMoveL, testMoveJ, testMoveC);
        testRobot.moveJ("posJ", 45);
        String output = getOutput();
        assertTrue(output.contains("* " + MANUFACTURER + " " + MODEL));
        assertTrue(output.contains("Joint move to posJ [speed: 45deg/s]"));
    }

    @Test
    void moveCShouldInvokeConfiguredMoveAlgorithm() {
        testRobot.configureMovement(testMoveL, testMoveJ, testMoveC);
        testRobot.moveC("posCMid", "posCEnd", 200);
        String output = getOutput();
        assertTrue(output.contains("* " + MANUFACTURER + " " + MODEL));
        assertTrue(output.contains("Circular move to posCEnd by posCMid [speed: 200mm/s]"));
    }
}