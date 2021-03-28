package readandwrite.javaHightRanking.pattern.guanchazhemoshi.qixiangzhan.javaneizhi;





import readandwrite.javaHightRanking.pattern.guanchazhemoshi.qixiangzhan.zijixiede.DisplayElement;

import java.util.Observable;
import java.util.Observer;


/**
 * Created by zohn on 2017/12/12.
 */
public class ForecastDisplay implements Observer, DisplayElement {

    private float currentPressure = 202.f;
    private float lastPressure;

    public ForecastDisplay(Observable observable) {
        WeatherData weatherData = (WeatherData) observable;
        observable.addObserver(this);
    }

    @Override
    public void display() {

    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof WeatherData){
            lastPressure = currentPressure;
            currentPressure = new WeatherData().getPressure();
        }
    }
}
