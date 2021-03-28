package readandwrite.thePublic.smile.shengchanxiaofei;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 *@Description  每个线程当做一个消费者
 *@CreateDate   18/08/13 9:13
 *@Author        zohn
 *@Version       1.0
 *
 */
public class Consumer implements Runnable {
    private boolean working = true;
    private BlockingQueue<Food> queue;

    public Consumer(BlockingQueue<Food> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Food food = queue.take(); // take方式，若队列中没有元素 则线程阻塞
                System.out.println(food.getId() + "号食物已被" + Thread.currentThread().getId() + "号顾客端走");
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
