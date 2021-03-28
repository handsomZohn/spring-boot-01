package readandwrite.book.cyc2018.javabingfa.threadJUC;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description: 用来控制多个线程互相等待，只有当多个线程都到达的时候，这些线程才继续执行。
 * @Author: zohn
 * @CreateDate: 2018/7/28 11:41
 * @UpdateUser: zohn
 * @UpdateDate: 2018/7/28 11:41
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class CyclicBarrierExample {
    public static void main(String[] args) throws InterruptedException {
        final int totalThread = 10;
        CyclicBarrier cyclicBarrier = new CyclicBarrier(totalThread);
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < totalThread; i++) {
            executorService.execute(() -> {
                System.out.print("before...");// 单个输出
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
                System.out.print("after...");// 一下全蹦出来 10个
            });
        }
        executorService.shutdown();
    }
}
