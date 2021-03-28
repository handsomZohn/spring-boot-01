package readandwrite.book.cyc2018.javabingfa.threadJUC;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description:CountdownLatch 用来控制一个线程等待多个线程。
 * 维护一个计数器cnt，每次调用countDown()方法会让计数器的值减1，
 * 减到0的时候，那些因为调用await（）方法而等待的线程就会被唤醒。
 * @Author: zohn
 * @CreateDate: 2018/7/28 10:25
 * @UpdateUser: zohn
 * @UpdateDate: 2018/7/28 10:25
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class CountdownLatchExample {
    public static void main(String[] args) throws InterruptedException {
        final int totalThread = 10;
        CountDownLatch countDownLatch = new CountDownLatch(totalThread);
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < totalThread; i++) {
            executorService.execute(() -> {
                System.out.print("run...");
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        System.out.println("end");
        executorService.shutdown();
    }
}
