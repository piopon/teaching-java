package pl.smtc.patterns.behavioral.observer;

import pl.smtc.menu.ConsoleExample;
import pl.smtc.patterns.behavioral.observer.subject.WeatherStation;
import pl.smtc.patterns.behavioral.observer.subscriber.WeatherPC;
import pl.smtc.patterns.behavioral.observer.subscriber.WeatherPhone;
import pl.smtc.patterns.behavioral.observer.subscriber.WeatherWeb;

public class ObserverPattern implements ConsoleExample {
    @Override
    public void execute() {
        WeatherStation station = new WeatherStation();
        WeatherPhone phone = new WeatherPhone("PHONE", station);
        WeatherWeb web = new WeatherWeb("WEB", station);
        WeatherPC pc = new WeatherPC("PC", station);

        station.add(phone);
        station.setTemperature(20.1);
        station.add(pc);
        station.add(web);
        station.setWindSpeed(1.2);
        station.remove(phone);
        station.setTemperature(19.2);
    }

    @Override
    public String getName() {
        return "Observer pattern";
    }
}
