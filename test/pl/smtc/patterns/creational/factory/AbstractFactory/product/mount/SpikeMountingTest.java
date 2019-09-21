package pl.smtc.patterns.creational.factory.AbstractFactory.product.mount;

import org.junit.jupiter.api.Test;
import pl.smtc.base.BaseTestOut;

import static org.junit.jupiter.api.Assertions.*;

class SpikeMountingTest extends BaseTestOut {
    private static final int MOUNT_COUNT = 5;
    private SpikeMounting testMounting;

    @Override
    protected void setUp() {
        testMounting = new SpikeMounting();
        testMounting.setMountElementsNumber(MOUNT_COUNT);
    }

    @Test
    void mountShouldReturnMountingInstructionsOutput() {
        boolean resultMount = testMounting.mount();
        assertTrue(resultMount);
        String output = getOutput();
        assertTrue(output.contains("Tools: " + testMounting.getTools()));
        assertTrue(output.contains("- place spike to desired space"));
        assertTrue(output.contains("- knock lamp with rubber hammer"));
    }

    @Test
    void addToolShouldAddToolForToolList() {
        testMounting.addTool("TEST_TOOL");
        assertTrue(testMounting.getTools().contains("TEST_TOOL"));
    }

    @Test
    void getToolsShouldReturnToolList() {
        String result = testMounting.getTools();
        assertTrue(result.contains("rubber hammer"));
    }

    @Test
    void getTypeShouldReturnAnchorsMountType() {
        assertEquals(EMounting.SPIKE, testMounting.getType());
    }

    @Test
    void getDescriptionShouldReturnCorrectDescription() {
        assertEquals(MOUNT_COUNT + " SPIKE", testMounting.getDescription());
    }

    @Test
    void setMountElementsNumber() {
        assertEquals(MOUNT_COUNT + " SPIKE", testMounting.getDescription());
        testMounting.setMountElementsNumber(100);
        assertEquals("100 SPIKE", testMounting.getDescription());
    }
}