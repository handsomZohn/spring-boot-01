package readandwrite.thePublic.smile.shengchanxiaofei;

import java.util.concurrent.*;

/**
 *@Description  主线程调用 使用线程池对线程进行分配
 * 将数据队列定义为10个元素空间
 * 线程池使用newFixedThreadPool方式来规定五条线程，初始化3名生产者和15名消费者
 *@CreateDate   18/08/13 9:19
 *@Author        zohn
 *@Version       1.0
 *
 */
public class Main {
    public static void main(String[] args) {
        BlockingQueue<Food> queue = new LinkedBlockingDeque<>(10);
        Producer[] producers = new Producer[3];
        Consumer[] consumers = new Consumer[15];

        for (int i = 0; i < 3; i++) {
            producers[i] = new Producer(queue);
        }

        for (int j = 0; j < 15; j++) {
            consumers[j] = new Consumer(queue);
        }

        ExecutorService executorService = Executors.newFixedThreadPool(5);

        for (int i = 0; i < 3; i++) {
            executorService.execute(producers[i]);
        }

        for (int j = 0; j < 15; j++) {
            executorService.execute(consumers[j]);
        }

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
