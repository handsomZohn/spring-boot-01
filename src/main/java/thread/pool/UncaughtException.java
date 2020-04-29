package thread.pool;

import java.util.concurrent.Executors;

public class UncaughtException {
    public static void main(String[] args) {
        // 使用单个线程的时候
        Thread thread = new Thread();
        thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler(){
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                // 根据业务场景选择想要的处理方式
            }
        });
        thread.setUncaughtExceptionHandler((t, e) -> {
            // 根据业务场景选择想要的处理方式
        });


        // 使用线程池创建线程的时候
        Executors.newFixedThreadPool(5, r -> {
            Thread thread1 = new Thread(r);
            thread1.setUncaughtExceptionHandler((t, e) -> {
                // 根据业务场景选择想要的处理方式

            });
            return thread1;
        });
    }
}
