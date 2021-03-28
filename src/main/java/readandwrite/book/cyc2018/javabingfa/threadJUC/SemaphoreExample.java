package readandwrite.book.cyc2018.javabingfa.threadJUC;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
* @Description: semaphore就是操作系统中的信号量，可以控制对互斥资源的访问线程数；
 * 模拟对某个服务的并发请求，每次只能有三个客户端同时访问 请求数为10
* @Author:         zohn
* @CreateDate:     2018/7/28 11:56
* @UpdateUser:     zohn
* @UpdateDate:     2018/7/28 11:56
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
public class SemaphoreExample {
    public static void main(String[] args) {
        final int clientCount = 3;
        final int totalRequestCount = 10;
        Semaphore semaphore = new Semaphore(2);
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < totalRequestCount; i++) {
            executorService.execute(()->{
                try {
                    semaphore.acquire();
                    System.out.print(semaphore.availablePermits() + " ");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();
                }
            });
        }
        executorService.shutdown();
    }
}
