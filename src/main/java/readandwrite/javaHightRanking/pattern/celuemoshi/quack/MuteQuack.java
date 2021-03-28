package readandwrite.javaHightRanking.pattern.celuemoshi.quack;

/**
 * Created by zohn on 2017/11/10.
 * 鸭叫行为实现类
 * 不会叫
 * 和Silence重复
 */
public class MuteQuack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("我不会叫------SILENCE");
    }
}
