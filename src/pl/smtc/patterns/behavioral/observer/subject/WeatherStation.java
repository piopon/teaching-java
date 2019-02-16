package pl.smtc.patterns.behavioral.observer.subject;

public class WeatherStation extends WeatherObservable implements WeatherGauge {
    private double temperature = 0;
    private double windSpeed = 0;

    public void setTemperature(double temperature) {
        this.temperature = temperature;
        notifyChanged();
    }

    public void setWindSpeed(double windSpeed) {
        this.windSpeed = windSpeed;
        notifyChanged();
    }

    @Override
    public double getTemperature() {
        return temperature;
    }

    @Override
    public double getWindSpeed() {
        return windSpeed;
    }
}
