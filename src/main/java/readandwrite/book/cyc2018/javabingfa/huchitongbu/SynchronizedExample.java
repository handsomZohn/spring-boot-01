package readandwrite.book.cyc2018.javabingfa.huchitongbu;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description synchronized 同步一个对象
 * @CreateDate 18/07/23 17:50
 * @Author zohn
 * @Version 1.0
 */
public class SynchronizedExample {
    public void func1() {
        synchronized (this) { // synchronized只作用于同一个对象 如果调用两个对象上的同步代码块 不会进行同步
            for (int i = 0; i < 100; i++) {
                System.out.print(i + " ");
            }
        }
    }

    public void func2(){
        synchronized (SynchronizedExample.class){ // 作用于整个类 也就是说两个线程调用同一个类的不同对象的这种同步语句
            // 也会进行同步
            for (int i = 0; i < 20; i++) {
                System.out.print(i + " ");
            }
        }
    }

    public static void main(String[] args) {
        /**
         * 同步一个对象
         */
//        SynchronizedExample synchronizedExample = new SynchronizedExample();
//        SynchronizedExample synchronizedExample2 = new SynchronizedExample();
//        ExecutorService executorService = Executors.newCachedThreadPool();
//        executorService.execute(() -> synchronizedExample.func1()); //
//        executorService.execute(() -> synchronizedExample.func1()); // 与上面的同步
//        executorService.execute(() -> synchronizedExample2.func1());// 与上面的不同步

        /**
         * 同步一个类
         */
        SynchronizedExample synchronizedExample = new SynchronizedExample();
        SynchronizedExample synchronizedExample1 = new SynchronizedExample();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(()->synchronizedExample.func2());
        executorService.execute(()->synchronizedExample1.func2());
    }

    // 同步一个静态方法
    // 作用于整个类
    public synchronized static void fun() {

    }
}
