package thread;

import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

public class ExecutorsTest {


    private static void sayHi(String name){
        String printStr = "thread name" + Thread.currentThread().getName() + ", carried out by: " + name;
        System.out.println(printStr);
        throw new RuntimeException("an Exception happened============================, carried out by: " + name);
    }

    private static ThreadPoolTaskExecutor buildThreadPoolTaskExecutor(){
        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
        threadPoolTaskExecutor.setThreadNamePrefix("Tarim");// 塔里木
        threadPoolTaskExecutor.setCorePoolSize(5);
        threadPoolTaskExecutor.setMaxPoolSize(10);
        threadPoolTaskExecutor.setQueueCapacity(1000);
        threadPoolTaskExecutor.setKeepAliveSeconds(30);
        threadPoolTaskExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        threadPoolTaskExecutor.initialize();
        return  threadPoolTaskExecutor;
    }


    /**
     * 主程序
     * @param
     */
    public static void main(String[] args) throws ExecutionException {
        ThreadPoolTaskExecutor threadPoolTaskExecutor = buildThreadPoolTaskExecutor();
        threadPoolTaskExecutor.execute(() -> sayHi("execute"));// execute方法执行，会抛出堆栈异常信息
        // submit方法执行时，返回结果封装在future中，如果调用future.get()方法必须进行异常捕获，从而可以抛出堆栈异常
        Future<?> submit = threadPoolTaskExecutor.submit(() -> sayHi("submit"));
        try {
            submit.get();// 拿到submit执行方式的堆栈异常 捕获的方式
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
