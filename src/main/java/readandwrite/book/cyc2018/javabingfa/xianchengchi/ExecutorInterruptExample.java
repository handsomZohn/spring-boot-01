package readandwrite.book.cyc2018.javabingfa.xianchengchi;

import java.lang.InterruptedException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @Description 调用Executor的shutdown（）方法会等待所有线程全部执行完毕再关闭，但是如果调用shutdownNow（）相当于调用每个线程的
 * interrupt()方法
 * @CreateDate 18/07/23 17:34
 * @Author zohn
 * @Version 1.0
 */
public class ExecutorInterruptExample {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() -> {
            try {
                Thread.sleep(1000);
                System.out.println("Thread Run");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        // executorService.shutdownNow();
        System.out.println("Main Run");

        // 中断一个线程
        Future<?> future = executorService.submit(() -> {

        });
        future.cancel(true);

    }
}
