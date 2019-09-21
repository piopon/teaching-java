package pl.smtc.patterns.creational.factory.AbstractFactory.product.source;

import org.junit.jupiter.api.Test;
import pl.smtc.base.BaseTestOut;

import static org.junit.jupiter.api.Assertions.*;

class NeonSourceTest extends BaseTestOut {
    private final static int TEST_TEMP = 2500;
    private final static String TEST_SHADE = "TEST_SHADE";
    private NeonSource testSource;

    @Override
    protected void setUp() {
        testSource = new NeonSource(TEST_TEMP);
    }

    @Test
    void powerOnShouldOutputSourceOnStatus() {
        boolean powerResult = testSource.power(true);
        assertTrue(powerResult);
        String output = getOutput();
        assertTrue(output.contains("NEON SOURCE - " + TEST_TEMP + "[K]"));
        assertTrue(output.contains("Multicolor light on"));
    }

    @Test
    void powerOffShouldOutputSourceOffStatus() {
        boolean powerResult = testSource.power(false);
        assertTrue(powerResult);
        String output = getOutput();
        assertTrue(output.contains("NEON SOURCE - " + TEST_TEMP + "[K]"));
        assertTrue(output.contains("Multicolor light off"));
    }

    @Test
    void getTypeShouldReturnSourceType() {
        assertEquals(ESource.NEON, testSource.getType());
    }

    @Test
    void setGlassShadeShouldSetShadeVariable() {
        testSource.setGlassShade(TEST_SHADE);
        assertTrue(testSource.getDescription().contains(TEST_SHADE + " glass"));
    }

    @Test
    void getDescriptionShouldReturnFullSourceDescription() {
        String expected = "NEON with  glass - " + TEST_TEMP + "[K]";
        assertEquals(expected, testSource.getDescription());
    }
}