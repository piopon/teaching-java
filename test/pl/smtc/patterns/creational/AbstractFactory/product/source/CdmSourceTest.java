package pl.smtc.patterns.creational.AbstractFactory.product.source;

import org.junit.jupiter.api.Test;
import pl.smtc.base.BaseTestOut;

import static org.junit.jupiter.api.Assertions.*;

class CdmSourceTest extends BaseTestOut {
    private final static int TEST_TEMP = 2500;
    private final static String TEST_SHADE = "TEST_SHADE";
    private CdmSource testSource;

    @Override
    protected void setUp() {
        testSource = new CdmSource(TEST_TEMP);
    }

    @Test
    void powerOnShouldOutputCdmSourceOnStatus() {
        boolean powerResult = testSource.power(true);
        assertTrue(powerResult);
        String output = getOutput();
        assertTrue(output.contains("CDM SOURCE - " + TEST_TEMP + "[K]"));
        assertTrue(output.contains("Energy saving light on"));
    }

    @Test
    void powerOffShouldOutputCdmSourceOffStatus() {
        boolean powerResult = testSource.power(false);
        assertTrue(powerResult);
        String output = getOutput();
        assertTrue(output.contains("CDM SOURCE - " + TEST_TEMP + "[K]"));
        assertTrue(output.contains("Energy saving light off"));
    }

    @Test
    void getTypeShouldReturnCdmSourceType() {
        assertEquals(ESource.CDM, testSource.getType());
    }

    @Test
    void setGlassShadeShouldSetShadeVariable() {
        testSource.setGlassShade(TEST_SHADE);
        assertTrue(testSource.getDescription().contains(TEST_SHADE + " glass"));
    }

    @Test
    void getDescriptionShouldReturnFullSourceDescription() {
        String expected = "CDM with  glass - " + TEST_TEMP + "[K]";
        assertEquals(expected, testSource.getDescription());
    }
}