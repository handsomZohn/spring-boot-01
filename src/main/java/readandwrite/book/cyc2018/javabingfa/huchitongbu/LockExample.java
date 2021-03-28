package readandwrite.book.cyc2018.javabingfa.huchitongbu;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description ReentrantLock
 * @CreateDate 18/07/26 11:12
 * @Author zohn
 * @Version 1.0
 */
public class LockExample {
    private Lock lock = new ReentrantLock();

    public void func() {
        lock.lock();
        try {
            for (int i = 0; i < 10; i++) {
                System.out.print(i + " ");
            }
        } finally {
            lock.unlock();// 确保释放锁 避免死锁
        }
    }

    public static void main(String[] args) {
        LockExample lockExample = new LockExample();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(()->lockExample.func());
        executorService.execute(()->lockExample.func());
    }
    // ReentrantLock是java.util.concurrent(J.U.C)包中的锁，相比于synchronized多了几个高级特性
    // 1.等待可中断 持有锁的线程长期不释放锁的时候 正在等待的线程可以选择放弃等待 去处理其他事情
    // 2.实现公平锁 公平锁是多个线程在等待同一个锁的时候 必须按照申请的顺序来依次获得锁 synchronized中的锁是非公平的 ReentrantLock
    // 中的锁默认也是非公平的 但是可以通过带有布尔值得构造函数要求使用公平锁
    // 3.锁绑定多个条件
}
