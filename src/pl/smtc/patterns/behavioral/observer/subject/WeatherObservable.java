package pl.smtc.patterns.behavioral.observer.subject;

import pl.smtc.patterns.behavioral.observer.subscriber.WeatherObserver;

import java.util.ArrayList;
import java.util.List;

public abstract class WeatherObservable {
    protected List<WeatherObserver> observers = new ArrayList<>();

    public void add(WeatherObserver observer) {
        observers.add(observer);
        System.out.println("Added observer: " + observer.getId() + " [subscribers: " + observers.size() + "]");
    }

    public void remove(WeatherObserver observer) {
        observers.remove(observer);
        System.out.println("Removed observer: " + observer.getId() + " [subscribers: " + observers.size() + "]");
    }

    public void notifyChanged() {
        observers.forEach(WeatherObserver::update);
    }
}
