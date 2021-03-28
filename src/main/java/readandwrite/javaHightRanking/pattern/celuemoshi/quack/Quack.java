package readandwrite.javaHightRanking.pattern.celuemoshi.quack;

/**
 * Created by zohn on 2017/11/10.
 * 鸭叫行为实现类
 * 鸭子呱呱的叫
 */
public class Quack implements QuackBehavior{
    @Override
    public void quack() {
        System.out.println("呱呱呱的叫------");
    }
}
