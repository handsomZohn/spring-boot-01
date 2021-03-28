package readandwrite.book.cyc2018.javabingfa.threadJUCOthers;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Description: 用于异步获取执行结果或者取消执行任务的场景
 * @Author: zohn
 * @CreateDate: 2018/7/28 12:14
 * @UpdateUser: zohn
 * @UpdateDate: 2018/7/28 12:14
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class FutureTaskExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> futureTask = new FutureTask<>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                int result = 0;
                for (int i = 0; i < 100; i++) {
                    Thread.sleep(10);
                    result += i;
                }
                return result;
            }
        });

        Thread computerThread = new Thread(futureTask);
        computerThread.start();

        Thread otherThread = new Thread(() -> {
            System.out.println("Other thread is running...");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        otherThread.start();
        System.out.println(futureTask.get());
    }
}
