package readandwrite.javaHightRanking.pattern.guanchazhemoshi.qixiangzhan.zijixiede.ObjectObserver;

/**
 * Created by zohn on 2017/12/11.
 */
public interface Observer {
    void update(float temp, float humidity, float pressure);
    // 当气象观测值改变时 主题会把这些状态值当做方法的参数 传递给观察者
    // 观察者实现
}
