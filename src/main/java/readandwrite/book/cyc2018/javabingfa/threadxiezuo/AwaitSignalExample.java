package readandwrite.book.cyc2018.javabingfa.threadxiezuo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description:
 * @Author: zohn
 * @CreateDate: 2018/7/28 5:29
 * @UpdateUser: zohn
 * @UpdateDate: 2018/7/28 5:29
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class AwaitSignalExample {
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void before() {
        lock.lock();
        try {
            System.out.println("before");
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public void after() {
        lock.lock();
        try {
            System.out.println("after");
            condition.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        AwaitSignalExample awaitSignalExample = new AwaitSignalExample();
        executorService.execute(() -> awaitSignalExample.after());
        executorService.execute(() -> awaitSignalExample.before());
    }

}
