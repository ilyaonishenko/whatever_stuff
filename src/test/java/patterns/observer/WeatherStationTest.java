package patterns.observer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by wopqw on 14.03.17.
 */
class WeatherStationTest {

    private WeatherData weatherData;
    private CurrentConditinsDisplay ccd;

    @BeforeEach
    void setUp(){
        weatherData =  new WeatherData();
        ccd = new CurrentConditinsDisplay(weatherData);
    }

    @Test
    void display() {

        weatherData.setMeasurements(80, 65, 30);
        assertThat(ccd.display(), is(String.format("Current conditions: %s F degrees and %s humidity", 80, 65)));
    }

}