package readandwrite.javaHightRanking.pattern.celuemoshi.fly;

/**
 * Created by zohn on 2017/11/10.
 * 飞行行为实现类
 * 给真正会飞的鸭子用
 */
public class FlyWithWings implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("Duck is Flying---飞啊飞我的骄傲放纵--");
    }
}
