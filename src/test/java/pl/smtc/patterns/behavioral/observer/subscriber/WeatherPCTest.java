package pl.smtc.patterns.behavioral.observer.subscriber;

import org.junit.jupiter.api.Test;
import pl.smtc.base.BaseTestOut;
import pl.smtc.patterns.behavioral.observer.subject.WeatherGauge;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class WeatherPCTest extends BaseTestOut {
    private final static String TEST_ID = "pc_test";
    private final static double TEST_TEMP = 123.034;
    private final static double TEST_WIND = 1.98712;
    private WeatherPC weatherPC;

    @Override
    protected void setUp() {
        WeatherGauge testWeatherGauge = mock(WeatherGauge.class);
        when(testWeatherGauge.getTemperature()).thenReturn(TEST_TEMP);
        when(testWeatherGauge.getWindSpeed()).thenReturn(TEST_WIND);
        weatherPC = new WeatherPC(TEST_ID, testWeatherGauge);
    }

    @Test
    void getId() {
        assertEquals(TEST_ID, weatherPC.getId());
    }

    @Test
    void update() {
        weatherPC.update();
        String output = getOutput();
        assertTrue(output.contains(" * " + TEST_ID + " - weather update: "));
        assertTrue(output.contains("temp = "+ TEST_TEMP + ", wind = " + TEST_WIND));
    }
}