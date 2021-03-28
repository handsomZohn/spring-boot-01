package readandwrite.javaHightRanking.pattern.guanchazhemoshi.qixiangzhan.javaneizhi;


/**
 * Created by zohn on 2017/12/11.
 */
public class WeatherStation {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();
        CurrentConditionDisplay currentConditionDisplay = new CurrentConditionDisplay(weatherData);
        weatherData.setMeasurements(50,50,20f);
        ForecastDisplay forecastDisplay = new ForecastDisplay(weatherData);
        weatherData.setMeasurements(20,20,20f);
    }
}
