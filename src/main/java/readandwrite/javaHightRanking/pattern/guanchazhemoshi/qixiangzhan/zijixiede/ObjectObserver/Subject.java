package readandwrite.javaHightRanking.pattern.guanchazhemoshi.qixiangzhan.zijixiede.ObjectObserver;

/**
 * Created by zohn on 2017/12/11.
 */
public interface Subject {
    void registerObserver(Observer observer);// 注册观察者
    void removeObserver(Observer observer);// 移除观察者
    void notifyObservers();// 主题状态改变 通知所有观察者
    // 主题
}
