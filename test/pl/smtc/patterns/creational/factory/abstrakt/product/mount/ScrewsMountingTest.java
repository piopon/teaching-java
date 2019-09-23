package pl.smtc.patterns.creational.factory.abstrakt.product.mount;

import org.junit.jupiter.api.Test;
import pl.smtc.base.BaseTestOut;

import static org.junit.jupiter.api.Assertions.*;

class ScrewsMountingTest extends BaseTestOut {
    private static final int MOUNT_COUNT = 5;
    private ScrewsMounting testMounting;

    @Override
    protected void setUp() {
        testMounting = new ScrewsMounting();
        testMounting.setMountElementsNumber(MOUNT_COUNT);
    }

    @Test
    void mountShouldReturnMountingInstructionsOutput() {
        boolean resultMount = testMounting.mount();
        assertTrue(resultMount);
        String output = getOutput();
        assertTrue(output.contains("Tools: " + testMounting.getTools()));
        assertTrue(output.contains("- drill holes with a power driller"));
        assertTrue(output.contains("- clean all holes with vacuum"));
        assertTrue(output.contains("- put rawlplugs into holes"));
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
        assertTrue(result.contains("vacuum"));
        assertTrue(result.contains("rawlplugs"));
    }

    @Test
    void getTypeShouldReturnAnchorsMountType() {
        assertEquals(EMounting.SCREWS, testMounting.getType());
    }

    @Test
    void getDescriptionShouldReturnCorrectDescription() {
        assertEquals(MOUNT_COUNT + " SCREWS", testMounting.getDescription());
    }

    @Test
    void setMountElementsNumber() {
        assertEquals(MOUNT_COUNT + " SCREWS", testMounting.getDescription());
        testMounting.setMountElementsNumber(100);
        assertEquals("100 SCREWS", testMounting.getDescription());
    }
}