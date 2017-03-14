package patterns.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wopqw on 14.03.17.
 */

public class WeatherData implements Subject {

    private List<Observer> observers;
    private int temperature;
    private int humidity;
    private int pressure;


    public WeatherData(){
        observers = new ArrayList<>();
    }
    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void deleteObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObjects() {
        observers.forEach(observer ->
                observer.update(temperature, humidity, pressure));
    }

    public void measurementsChanged(){
        notifyObjects();
    }

    public void setMeasurements(int temperature, int humidity, int pressure){
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
    }
}
