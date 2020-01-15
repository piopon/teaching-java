package pl.smtc.patterns.structural.facade.computer.hardware;

import org.junit.jupiter.api.Test;
import pl.smtc.base.BaseTestOut;

import static org.junit.jupiter.api.Assertions.*;

class GraphicsCardTest extends BaseTestOut {
    private GraphicsCard graphicsCard;

    @Override
    protected void setUp() {
        graphicsCard = new GraphicsCard();
    }

    @Test
    void isBootableShouldReturnFalse() {
        assertFalse(graphicsCard.isBootable());
    }

    @Test
    void getBootCodeShouldReturnErrorGpuBootCode() {
        assertEquals("ERROR - DEVICE NOT BOOTABLE", graphicsCard.getBootCode());
    }

    @Test
    void initShouldInvokeInitializationProcedure() {
        graphicsCard.init();
        String output = getOutput();
        assertTrue(output.contains(" * Powering up, initializing drivers, benchmarking"));
    }

    @Test
    void getNameShouldReturnGraphicsCardString() {
        assertEquals("GRAPHICS CARD", graphicsCard.getName());
    }

    @Test
    void toStringShouldReturnGraphicsCardString() {
        assertEquals("GRAPHICS CARD", graphicsCard.toString());
    }
}