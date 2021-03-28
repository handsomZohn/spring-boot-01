package readandwrite.javaHightRanking.pattern.guanchazhemoshi.qixiangzhan.javaneizhi;




import readandwrite.javaHightRanking.pattern.guanchazhemoshi.qixiangzhan.zijixiede.DisplayElement;

import java.util.Observable;
import java.util.Observer;


/**
 * Created by zohn on 2017/12/11.
 */
public class CurrentConditionDisplay implements Observer, DisplayElement {

    Observable observable;
    private float temperature;
    private float humidity;

    public CurrentConditionDisplay(Observable observable) {
        this.observable = observable;
        observable.addObserver(this);
    }


    public void display() {
        System.out.println("Current Condition:" + temperature + "F degrees  and " + humidity + "% humidity ");
    }


    public void update(Observable obs, Object arg) {
        if (obs instanceof  WeatherData) {
            WeatherData weatherData = (WeatherData) obs;
            this.temperature = weatherData.getTemperature();
            this.humidity = weatherData.getHumidity();
            display();
        }
    }

}
