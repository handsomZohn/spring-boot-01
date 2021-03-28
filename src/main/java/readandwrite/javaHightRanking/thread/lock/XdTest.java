package readandwrite.javaHightRanking.thread.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class XdTest {
    private int num = 0;
    //使?用lock，每个对象都是有锁，只有获得这个锁才可以进?行?对应的操作
    Lock lock = new ReentrantLock();

    public void add1() {
        lock.lock();
        try {
            num++;
        } finally {
            lock.unlock();
        }
    }

    //使?用synchronized，和上述是?一个操作，这个是保证?方法被锁住?而已，上述的是代码块被锁住
    public synchronized void add2() {
        num++;
        int minPriority = Thread.MIN_PRIORITY;
        int maxPriority = Thread.MAX_PRIORITY;
    }
}
