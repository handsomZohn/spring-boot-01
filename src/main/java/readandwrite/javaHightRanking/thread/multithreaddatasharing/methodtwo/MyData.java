package readandwrite.javaHightRanking.thread.multithreaddatasharing.methodtwo;

/**
 * 将Runnable对象作为类的内部类，
 * 将共享数据作为这个类的成员变量，
 * 每个线程对共享数据的操作方法被封装在该类的外部类中，
 * 以便于实现对数据的各种操作的同步和互斥，
 * 作为内部类的各个Runnable对象调用外部类的这些方法
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
