package readandwrite.javaHightRanking.thread.multithreaddatasharing.methodone;

/**
 * 将数据抽象成一个类，并将对这个数据的操作封装在类的方法中
 */
public class MyData {
    private int j = 0;

    public synchronized void add() {
        j++;
        System.out.println("线程" + Thread.currentThread().getName() + "j为：" + j);
    }

    public synchronized void dec() {
        j--;
        System.out.println("线程" + Thread.currentThread().getName() + "j为：" + j);
    }

    public int getData() {
        return j;
    }
}
