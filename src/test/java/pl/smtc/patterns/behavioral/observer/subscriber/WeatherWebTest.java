package pl.smtc.patterns.behavioral.observer.subscriber;

import org.junit.jupiter.api.Test;
import pl.smtc.base.BaseTestOut;
import pl.smtc.patterns.behavioral.observer.subject.WeatherGauge;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class WeatherWebTest extends BaseTestOut {
    private final static String TEST_ID = "web_test";
    private final static double TEST_TEMP = -12.987;
    private final static double TEST_WIND = -1.1234;
    private WeatherWeb weatherWeb;

    @Override
    protected void setUp() {
        WeatherGauge testWeatherGauge = mock(WeatherGauge.class);
        when(testWeatherGauge.getTemperature()).thenReturn(TEST_TEMP);
        when(testWeatherGauge.getWindSpeed()).thenReturn(TEST_WIND);
        weatherWeb = new WeatherWeb(TEST_ID, testWeatherGauge);
    }

    @Test
    void getId() {
        assertEquals(TEST_ID, weatherWeb.getId());
    }

    @Test
    void update() {
        weatherWeb.update();
        String output = getOutput();
        assertTrue(output.contains(" * " + TEST_ID + " - weather update: "));
        assertTrue(output.contains("temp = "+ TEST_TEMP + ", wind = " + TEST_WIND));
    }
}