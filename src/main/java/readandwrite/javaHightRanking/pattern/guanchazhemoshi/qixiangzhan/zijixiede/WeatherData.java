package readandwrite.javaHightRanking.pattern.guanchazhemoshi.qixiangzhan.zijixiede;





import readandwrite.javaHightRanking.pattern.guanchazhemoshi.qixiangzhan.zijixiede.ObjectObserver.Observer;
import readandwrite.javaHightRanking.pattern.guanchazhemoshi.qixiangzhan.zijixiede.ObjectObserver.Subject;

import java.util.ArrayList;

/**
 * Created by zohn on 2017/12/11.
 */
public class WeatherData implements Subject {

    private ArrayList obervers;  //观察者
    private float temperature;
    private float humidity;
    private float pressure;

    public WeatherData(){
        obervers = new ArrayList();
    }
    @Override
    public void registerObserver(Observer observer) {
        //注册观察者加进observers
        obervers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        //移除观察者 就从observers里面移除
        int i = obervers.indexOf(observer);
        if (i > 0) obervers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (int i = 0; i < obervers.size(); i++){
            Observer o = (Observer) obervers.get(i);
            o.update(temperature, humidity, pressure);
        }
    }

    //当从气象站得到更新检测值时，通知观察者
    public void measurementsChanged(){
        notifyObservers();
    }

    public void setMeasureMents(float temperature, float humidity, float pressure){
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
    }
}
