package readandwrite.javaHightRanking.pattern.guanchazhemoshi.qixiangzhan.zijixiede.bugaoban;


import readandwrite.javaHightRanking.pattern.guanchazhemoshi.qixiangzhan.zijixiede.DisplayElement;
import readandwrite.javaHightRanking.pattern.guanchazhemoshi.qixiangzhan.zijixiede.ObjectObserver.Observer;
import readandwrite.javaHightRanking.pattern.guanchazhemoshi.qixiangzhan.zijixiede.ObjectObserver.Subject;

/**
 * 目前状况布告板
 * Created by zohn on 2017/12/11.
 */
public class CurrentConditionDisplay implements Observer, DisplayElement {
    private float temperature;
    private float humidity;
    private Subject weatherData;//  有对Subject的引用 取消注册会比较方便

    public CurrentConditionDisplay(Subject weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void update(float temp, float humidity, float pressure) {
        this.temperature = temp;
        this.humidity = humidity;// update被调用时把温度和湿度保存起来
        display();// 调用display()   思考display的调用位置
    }

    @Override
    public void display() {
        System.out.println("Current Condition:" + temperature + "F degrees  and " + humidity + "% humidity ");
    }
}
