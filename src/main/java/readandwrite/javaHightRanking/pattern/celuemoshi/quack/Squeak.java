package readandwrite.javaHightRanking.pattern.celuemoshi.quack;

/**
 * Created by zohn on 2017/11/10.
 * 鸭叫行为实现类
 * 鸭子吱吱的叫
 */
public class Squeak implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("吱吱的叫------");
    }
}
