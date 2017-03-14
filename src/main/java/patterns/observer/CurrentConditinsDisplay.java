package patterns.observer;

/**
 * Created by wopqw on 14.03.17.
 */
public class CurrentConditinsDisplay implements Observer, DisplayElement {

    private int temperature;
    private int humidity;
    private Subject weatherData;

    public CurrentConditinsDisplay(Subject weatherData){
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void update(int temp, int humidity, int pressure) {
        this.temperature = temp;
        this.humidity = humidity;
        display();
    }

    @Override
    public String display() {
        return String.format("Current conditions: %s F degrees and %s humidity",
                        temperature, humidity);
    }
}
