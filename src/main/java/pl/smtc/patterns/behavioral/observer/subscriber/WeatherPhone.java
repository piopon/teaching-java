package pl.smtc.patterns.behavioral.observer.subscriber;

import pl.smtc.patterns.behavioral.observer.subject.WeatherGauge;

public class WeatherPhone implements WeatherObserver {
    private WeatherGauge weatherGauge;
    private String id;

    public WeatherPhone(String id, WeatherGauge weatherGauge) {
        this.id = id;
        this.weatherGauge = weatherGauge;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void update() {
        String title = " * " + id + " - weather update: ";
        String data = "temp = "+ weatherGauge.getTemperature() + ", wind = " + weatherGauge.getWindSpeed();
        System.out.println(title + data);
    }
}
