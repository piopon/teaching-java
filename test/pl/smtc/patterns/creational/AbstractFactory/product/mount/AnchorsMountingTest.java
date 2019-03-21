package pl.smtc.patterns.creational.AbstractFactory.product.mount;

import org.junit.jupiter.api.Test;
import pl.smtc.base.BaseTestOut;

import static org.junit.jupiter.api.Assertions.*;

class AnchorsMountingTest extends BaseTestOut {
    private static final int MOUNT_COUNT = 5;
    private AnchorsMounting testMounting;

    @Override
    protected void setUp() {
        testMounting = new AnchorsMounting();
        testMounting.setMountElementsNumber(MOUNT_COUNT);
    }

    @Test
    void mountShouldReturnMountingInstructionsOutput() {
        boolean resultMount = testMounting.mount();
        assertTrue(resultMount);
        String output = getOutput();
        assertTrue(output.contains("Tools: " + testMounting.getTools()));
        assertTrue(output.contains("- mount driller into guide"));
        assertTrue(output.contains("- drill holes"));
        assertTrue(output.contains("- fill holes with binging mixture"));
    }

    @Test
    void addToolShouldAddToolForToolList() {
        testMounting.addTool("TEST_TOOL");
        assertTrue(testMounting.getTools().contains("TEST_TOOL"));
    }

    @Test
    void getToolsShouldReturnToolList() {
        String result = testMounting.getTools();
        assertTrue(result.contains("power driller"));
        assertTrue(result.contains("drillers' guide"));
        assertTrue(result.contains("binding mixture"));
    }

    @Test
    void getTypeShouldReturnAnchorsMountType() {
        assertEquals(EMounting.ANCHORS, testMounting.getType());
    }

    @Test
    void getDescriptionShouldReturnCorrectDescription() {
        assertEquals(MOUNT_COUNT + " ANCHORS", testMounting.getDescription());
    }

    @Test
    void setMountElementsNumber() {
        assertEquals(MOUNT_COUNT + " ANCHORS", testMounting.getDescription());
        testMounting.setMountElementsNumber(100);
        assertEquals("100 ANCHORS", testMounting.getDescription());
    }
}