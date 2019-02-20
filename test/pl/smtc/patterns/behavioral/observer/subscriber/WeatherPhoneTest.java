package pl.smtc.patterns.behavioral.observer.subscriber;

import org.junit.jupiter.api.Test;
import pl.smtc.base.BaseTestOut;
import pl.smtc.patterns.behavioral.observer.subject.WeatherGauge;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class WeatherPhoneTest extends BaseTestOut {
    private final static String TEST_ID = "phone_test";
    private final static double TEST_TEMP = 321.987;
    private final static double TEST_WIND = 11.1234;
    private WeatherPhone weatherPhone;

    @Override
    protected void setUp() {
        WeatherGauge testWeatherGauge = mock(WeatherGauge.class);
        when(testWeatherGauge.getTemperature()).thenReturn(TEST_TEMP);
        when(testWeatherGauge.getWindSpeed()).thenReturn(TEST_WIND);
        weatherPhone = new WeatherPhone(TEST_ID, testWeatherGauge);
    }

    @Test
    void getId() {
        assertEquals(TEST_ID, weatherPhone.getId());
    }

    @Test
    void update() {
        weatherPhone.update();
        String output = getOutput();
        assertTrue(output.contains(" * " + TEST_ID + " - weather update: "));
        assertTrue(output.contains("temp = "+ TEST_TEMP + ", wind = " + TEST_WIND));
    }
}