package pl.smtc.patterns.behavioral.observer.subject;

import org.junit.jupiter.api.Test;
import pl.smtc.base.BaseTestOut;
import pl.smtc.patterns.behavioral.observer.subscriber.WeatherObserver;

import static org.junit.jupiter.api.Assertions.*;

class WeatherStationTest extends BaseTestOut {
    private final static double TEST_TEMP = 36.6;
    private final static double TEST_WIND_SPEED = 12.3;
    private WeatherStation weatherStation;
    private WeatherObserver testObserver1;
    private WeatherObserver testObserver2;

    @Override
    protected void setUp() {
        weatherStation = new WeatherStation();
        testObserver1 = createObserver("test1");
        testObserver2 = createObserver("test2");
    }

    @Test
    void setTemperatureShouldUpdateTemperatureField() {
        weatherStation.setTemperature(TEST_TEMP);
        assertEquals(TEST_TEMP, weatherStation.temperature);
    }

    @Test
    void setWindSpeedShouldUpdateWindSpeedField() {
        weatherStation.setWindSpeed(TEST_WIND_SPEED);
        assertEquals(TEST_WIND_SPEED, weatherStation.windSpeed);
    }

    @Test
    void getTemperatureShouldReturnCurrentTemperature() {
        weatherStation.setTemperature(TEST_TEMP);
        assertEquals(TEST_TEMP, weatherStation.getTemperature());
    }

    @Test
    void getWindSpeedShouldReturnCurrentWindSpeed() {
        weatherStation.setWindSpeed(TEST_WIND_SPEED);
        assertEquals(TEST_WIND_SPEED, weatherStation.getWindSpeed());
    }

    @Test
    void addShouldInsertObjectIntoObserverList() {
        weatherStation.add(testObserver1);
        weatherStation.add(testObserver2);

        assertEquals(2, weatherStation.observers.size());
        assertEquals(testObserver1, weatherStation.observers.get(0));
        assertEquals(testObserver2, weatherStation.observers.get(1));
    }

    @Test
    void removeShouldDeleteObjectIntoObserverList() {
        weatherStation.add(testObserver1);
        weatherStation.add(testObserver2);
        weatherStation.remove(testObserver1);

        assertEquals(1, weatherStation.observers.size());
        assertEquals(testObserver2, weatherStation.observers.get(0));
    }

    @Test
    void notifyChangedShouldInvokeMethodsInAllObservers() {
        weatherStation.add(testObserver1);
        weatherStation.add(testObserver2);
        weatherStation.notifyChanged();

        String output = getOutput();
        assertTrue(output.contains("test1: update invoked!"));
        assertTrue(output.contains("test2: update invoked!"));
    }

    private WeatherObserver createObserver(String idName) {
        return new WeatherObserver() {
            @Override
            public String getId() {
                return idName;
            }

            @Override
            public void update() {
                System.out.println(idName + ": update invoked!");
            }
        };
    }
}