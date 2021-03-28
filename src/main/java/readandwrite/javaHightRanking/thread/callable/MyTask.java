package readandwrite.javaHightRanking.thread.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Description 通过Callable实现多线程
 * @CreateDate 2020\3\15 0015 12:41
 * @Author zohn
 * @Version 1.0
 */
public class MyTask implements Callable<Object> {
    @Override
    public Object call() throws Exception {
        System.out.println("通过Callable实现多线程，名 称：" + Thread.currentThread().getName());
        return "这是返回值";
    }

    public static void main(String[] args) {
        FutureTask<Object> futureTask = new FutureTask<>(() -> {
            System.out.println("通过Callable实现多线程，名称 " + Thread.currentThread().getName());
            return "这是返回值";
        });
        // MyTask myTask = new MyTask();
        // FutureTask<Object> futureTask = new FutureTask<>(myTask);
        //FutureTask继承了Runnable，可以放在Thread中启动执行
        Thread thread = new Thread(futureTask);
        thread.setName("demo3");
        thread.start();
        System.out.println("主线程名 称:" + Thread.currentThread().getName());
        try {
            System.out.println(futureTask.get());
        } catch (InterruptedException e) {
            //阻塞等待中被中断，则抛出
            e.printStackTrace();
        } catch (ExecutionException e) {
            //执行过程发送异常被抛出
            e.printStackTrace();
        }

        MyTask myTask = new MyTask();
        FutureTask<Object> objectFutureTask = new FutureTask<>(myTask);
        Thread thread1 = new Thread(objectFutureTask);
        thread1.setName("mytaskDemo");
        thread1.start();

        try {
            System.out.println(futureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


    }
}
