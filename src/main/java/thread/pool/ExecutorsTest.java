package thread.pool;

import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 有些线程它死了，于是他变成了一道面试题
 *@Description https://mp.weixin.qq.com/s?__biz=MzIxNTQ4MzE1NA==&mid=2247483741&idx=1&sn=238fc933c3b9b19ab1754b23283ac6fd&chksm=9796d720a0e15e364f4105c29de606e7329760a41607136a722dc97bb177f9362aeacd92f762&scene=21&key=c90959eb7434e3d3dc5311c6f5149124166477cd17d371fc8d1ed23def1362994e68cba2ec3f78852a85d8937d8edaddc55fa365b52fad5e252982b015d3c42ff1c2dc97a71c7bf8d17f35c80db6bd11&ascene=14&uin=NjQzNTk5OTI0&devicetype=Windows+7+x64&version=62090070&lang=zh_CN&exportkey=AZAp693btznzRjJo9Uaz5v0%3D&pass_ticket=VXb6sgPiiJnI9Bx5a55aYXbEWuxHXpCUhTpBAczqtMIDzrhg%2BdAL0aSd4k%2Bo2BTy
 *@CreateDate 2020\4\26 0026 13:35
 *@Author zz
 *@Version 1.0
 */
public class ExecutorsTest {


    private static void sayHi(String name){
        String printStr = "thread name" + Thread.currentThread().getName() + ", carried out by: " + name;
        System.out.println(printStr);
        throw new RuntimeException("an Exception happened============================, carried out by: " + name);
    }

    private static ThreadPoolTaskExecutor buildThreadPoolTaskExecutor(){
        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
        // 塔里木
        threadPoolTaskExecutor.setThreadNamePrefix("Tarim");
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


        // execute方法执行，会抛出堆栈异常信息
        threadPoolTaskExecutor.execute(() -> sayHi("execute"));
        // submit方法执行时，返回结果封装在future中，如果调用future.get()方法必须进行异常捕获，从而可以抛出堆栈异常
        Future<?> submit = threadPoolTaskExecutor.submit(() -> sayHi("submit"));
        try {
            submit.get();// 拿到submit执行方式的堆栈异常 捕获的方式
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
