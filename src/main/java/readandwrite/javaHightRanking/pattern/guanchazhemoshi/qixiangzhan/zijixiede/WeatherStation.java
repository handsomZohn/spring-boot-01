package readandwrite.javaHightRanking.pattern.guanchazhemoshi.qixiangzhan.zijixiede;


import readandwrite.javaHightRanking.pattern.guanchazhemoshi.qixiangzhan.zijixiede.bugaoban.CurrentConditionDisplay;

/**
 * Created by zohn on 2017/12/11.
 */
public class WeatherStation {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();
        CurrentConditionDisplay currentConditionDisplay = new CurrentConditionDisplay(weatherData);
        weatherData.setMeasureMents(50,50,20.2f);
        weatherData.setMeasureMents(54,55,40.2f);
        weatherData.setMeasureMents(10,30,70.2f);
    }
}
