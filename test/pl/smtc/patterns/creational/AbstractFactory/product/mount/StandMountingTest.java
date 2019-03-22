package pl.smtc.patterns.creational.AbstractFactory.product.mount;

import org.junit.jupiter.api.Test;
import pl.smtc.base.BaseTestOut;

import static org.junit.jupiter.api.Assertions.*;

class StandMountingTest extends BaseTestOut {
    private static final int MOUNT_COUNT = 5;
    private StandMounting testMounting;

    @Override
    protected void setUp() {
        testMounting = new StandMounting();
        testMounting.setMountElementsNumber(MOUNT_COUNT);
    }

    @Test
    void mountShouldReturnMountingInstructionsOutput() {
        boolean resultMount = testMounting.mount();
        assertTrue(resultMount);
        String output = getOutput();
        assertTrue(output.contains("Tools: " + testMounting.getTools()));
        assertTrue(output.contains("- clean desk place with wiper"));
        assertTrue(output.contains("- place lamp at desired space"));
    }

    @Test
    void addToolShouldAddToolForToolList() {
        testMounting.addTool("TEST_TOOL");
        assertTrue(testMounting.getTools().contains("TEST_TOOL"));
    }

    @Test
    void getToolsShouldReturnToolList() {
        String result = testMounting.getTools();
        assertTrue(result.contains("microfiber wiper"));
        assertTrue(result.contains("cleaners"));
    }

    @Test
    void getTypeShouldReturnAnchorsMountType() {
        assertEquals(EMounting.STAND, testMounting.getType());
    }

    @Test
    void getDescriptionShouldReturnCorrectDescription() {
        assertEquals(MOUNT_COUNT + " STAND", testMounting.getDescription());
    }

    @Test
    void setMountElementsNumber() {
        assertEquals(MOUNT_COUNT + " STAND", testMounting.getDescription());
        testMounting.setMountElementsNumber(100);
        assertEquals("100 STAND", testMounting.getDescription());
    }
}