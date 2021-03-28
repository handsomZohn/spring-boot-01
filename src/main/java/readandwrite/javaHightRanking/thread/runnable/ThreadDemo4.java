package readandwrite.javaHightRanking.thread.runnable;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *@Description 通过Runnable加ThreadPool实现创建线程 
 *@CreateDate 2020\3\15 0015 13:11
 *@Author zohn
 *@Version 1.0
 */
public class ThreadDemo4 implements Runnable{
    @Override
    public void run() {
        System.out.println("通过线程池+runnable实现多线程，名称："+Thread.currentThread().getName());
    }


    public static void main(String[] args) {
        ExecutorService executorService =
                Executors.newFixedThreadPool(3);
        for (int i = 0; i < 10; i++) {
            executorService.execute(new ThreadDemo4());
        }
        System.out.println("主线程名称:" + Thread.currentThread().getName());
        //关闭线程池
        executorService.shutdown();
    }

}
