package readandwrite.javaHightRanking.pattern.celuemoshi;


import readandwrite.javaHightRanking.pattern.celuemoshi.duck.Duck;
import readandwrite.javaHightRanking.pattern.celuemoshi.duck.MallarDuck;
import readandwrite.javaHightRanking.pattern.celuemoshi.duck.ModelDuck;
import readandwrite.javaHightRanking.pattern.celuemoshi.fly.FlyRocketPowered;

/**
 * Created by zohn on 2017/11/10.
 * 测试类
 */
public class MiniDuckSimulator {
    public static void main(String[] args) {
        //一个会呱呱呱叫的鸭子
        Duck mallarDuck = new MallarDuck();
        mallarDuck.display();
        mallarDuck.performFly();
        mallarDuck.performQuack();

        //一只沉默的模型鸭
        //但是后来它坐上了火箭
        ModelDuck modelDuck = new ModelDuck();
        modelDuck.display();
        modelDuck.performFly();
        modelDuck.setFlyBehavior(new FlyRocketPowered());//通过动态赋FlyBehavior
        modelDuck.performFly();
        modelDuck.performQuack();//
    }
}
