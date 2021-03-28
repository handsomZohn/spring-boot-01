package readandwrite.thePublic.smile.shengchanxiaofei;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *@Description  每个线程当做一个生产者
 *@CreateDate   18/08/13 9:01
 *@Author        zohn
 *@Version       1.0
 *
 */
public class Producer implements Runnable{
    private boolean working = true;
    private BlockingQueue<Food> queue;
    private static AtomicInteger count = new AtomicInteger();

    // 构造函数
    public Producer(BlockingQueue<Food> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (working) {
            int id = count.incrementAndGet();
            Food food = new Food(id);
            if (queue.offer(food)) {
                System.out.println(Thread.currentThread().getId() + "号员工将" + food.getId() + "号食物加入餐台");
            } else {
                System.out.println("餐台已满，" + food.getId() + "号食物无法加入");
            }
            try {
                // Thread.sleep(1000*3);
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
