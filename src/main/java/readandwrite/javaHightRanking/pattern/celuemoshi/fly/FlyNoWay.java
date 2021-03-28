package readandwrite.javaHightRanking.pattern.celuemoshi.fly;

/**
 * Created by zohn on 2017/11/10.
 * 飞行行为实现类
 * 给不会"飞的鸭子用"
 */
public class FlyNoWay implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("不能飞啊不能飞---");
    }
}
