package readandwrite.book.cyc2018.javabingfa.xianchengchi;



import readandwrite.book.cyc2018.javabingfa.thread2.MyRunnable;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description CachedThreadPool  JDK1.5
 * @CreateDate 18/07/23 17:06
 * @Author zohn
 * @Version 1.0
 */
public class MyCachedThreadPool {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            executorService.execute(new MyRunnable());
        }
        executorService.shutdown();
    }
}
