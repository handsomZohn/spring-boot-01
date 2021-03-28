package readandwrite.javaHightRanking.pattern.guanchazhemoshi.qixiangzhan.javaneizhi;

import java.util.Observable;

/**
 * Created by zohn on 2017/12/11.
 */
public class WeatherData extends Observable {
    private float temperature;
    private float humidity;
    private float pressure;

    public WeatherData() {
    }
    public void measurementsChanged(){
        setChanged();  // 指示状态已经改变
        notifyObservers();
    }
    public void setMeasurements(float temperature, float humidity, float pressure){
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
    }

    public float getTemperature() {
        return temperature;
    }

    public float getHumidity() {
        return humidity;
    }

    public float getPressure() {
        return pressure;
    }
}
