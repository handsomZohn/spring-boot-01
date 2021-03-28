package readandwrite.book.cyc2018.javabingfa.threadxiezuo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description 线程协作-waitNotify
 * @CreateDate 18/07/26 11:55
 * @Author zohn
 * @Version 1.0
 */
public class WaitNotifyExample {
    public synchronized void before() {
        System.out.println("Before");
        notify();
    }

    public synchronized void after() {
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("After");
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        WaitNotifyExample waitNotifyExample = new WaitNotifyExample();
        executorService.execute(() -> waitNotifyExample.after());
        executorService.execute(() -> waitNotifyExample.before());
    }
}
