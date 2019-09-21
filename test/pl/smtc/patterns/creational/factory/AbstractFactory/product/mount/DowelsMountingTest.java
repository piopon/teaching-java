package pl.smtc.patterns.creational.factory.AbstractFactory.product.mount;

import org.junit.jupiter.api.Test;
import pl.smtc.base.BaseTestOut;

import static org.junit.jupiter.api.Assertions.*;

class DowelsMountingTest extends BaseTestOut {
    private static final int MOUNT_COUNT = 5;
    private DowelsMounting testMounting;

    @Override
    protected void setUp() {
        testMounting = new DowelsMounting();
        testMounting.setMountElementsNumber(MOUNT_COUNT);
    }

    @Test
    void mountShouldReturnMountingInstructionsOutput() {
        boolean resultMount = testMounting.mount();
        assertTrue(resultMount);
        String output = getOutput();
        assertTrue(output.contains("Tools: " + testMounting.getTools()));
        assertTrue(output.contains("- drill holes with drill-driver"));
        assertTrue(output.contains("- fill holes with glue"));
    }

    @Test
    void addToolShouldAddToolForToolList() {
        testMounting.addTool("TEST_TOOL");
        assertTrue(testMounting.getTools().contains("TEST_TOOL"));
    }

    @Test
    void getToolsShouldReturnToolList() {
        String result = testMounting.getTools();
        assertTrue(result.contains("drill-driver"));
        assertTrue(result.contains("dowel glue"));
    }

    @Test
    void getTypeShouldReturnAnchorsMountType() {
        assertEquals(EMounting.DOWELS, testMounting.getType());
    }

    @Test
    void getDescriptionShouldReturnCorrectDescription() {
        assertEquals(MOUNT_COUNT + " DOWELS", testMounting.getDescription());
    }

    @Test
    void setMountElementsNumber() {
        assertEquals(MOUNT_COUNT + " DOWELS", testMounting.getDescription());
        testMounting.setMountElementsNumber(100);
        assertEquals("100 DOWELS", testMounting.getDescription());
    }
}