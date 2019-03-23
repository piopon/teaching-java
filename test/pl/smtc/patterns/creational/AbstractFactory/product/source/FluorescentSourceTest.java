package pl.smtc.patterns.creational.AbstractFactory.product.source;

import org.junit.jupiter.api.Test;
import pl.smtc.base.BaseTestOut;

import static org.junit.jupiter.api.Assertions.*;

class FluorescentSourceTest extends BaseTestOut {
    private final static int TEST_TEMP = 2500;
    private final static String TEST_SHADE = "TEST_SHADE";
    private FluorescentSource testSource;

    @Override
    protected void setUp() {
        testSource = new FluorescentSource(TEST_TEMP);
    }

    @Test
    void powerOnShouldOutputSourceOnStatus() {
        boolean powerResult = testSource.power(true);
        assertTrue(powerResult);
        String output = getOutput();
        assertTrue(output.contains("FLUORESCENT SOURCE - " + TEST_TEMP + "[K]"));
        assertTrue(output.contains("Flickering light on"));
    }

    @Test
    void powerOffShouldOutputSourceOffStatus() {
        boolean powerResult = testSource.power(false);
        assertTrue(powerResult);
        String output = getOutput();
        assertTrue(output.contains("FLUORESCENT SOURCE - " + TEST_TEMP + "[K]"));
        assertTrue(output.contains("Flickering light off"));
    }

    @Test
    void getTypeShouldReturnSourceType() {
        assertEquals(ESource.FLUORESCENT, testSource.getType());
    }

    @Test
    void setGlassShadeShouldSetShadeVariable() {
        testSource.setGlassShade(TEST_SHADE);
        assertTrue(testSource.getDescription().contains(TEST_SHADE + " glass"));
    }

    @Test
    void getDescriptionShouldReturnFullSourceDescription() {
        String expected = "FLUORESCENT with  glass - " + TEST_TEMP + "[K]";
        assertEquals(expected, testSource.getDescription());
    }
}