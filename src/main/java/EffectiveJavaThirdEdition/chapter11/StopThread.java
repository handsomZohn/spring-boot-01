package EffectiveJavaThirdEdition.chapter11;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @Description  同步写的时候 也要同步读取。
 * @Author zohn
 * @Date 2019/12/22 19:15
 * @Param
 * @Return
 */
public class StopThread {
    private static boolean stopRequested;

    // ============================
    private static synchronized void requestStop(){
        stopRequested = true;
    }

    private static synchronized boolean stopRequested (){
        return stopRequested;
    }

    // ============================

    public static void main(String[] args) throws InterruptedException {
        Thread backgroundThread = new Thread(() -> {
            int i = 0;
            // 同步的·读
            while (!stopRequested()) {
                i++;
                System.out.println("======^_^======变量i值为: " + i + ", " + "当前类以及方法名字是: StopThread.main()");
            }
        });

        backgroundThread.start();

        TimeUnit.SECONDS.sleep(1);

        // stopRequested = true;
        // ============================
        // 同步写
        requestStop();
        // ============================
    }

    // 生产序列号 i++ 操作不是原子的。获取自增长的序号
    private static  final AtomicLong nextSerialNumber = new AtomicLong();

    public static long generateSerialNumber(){
        return nextSerialNumber.getAndIncrement();
    }

    // 安全发布对象引用的方法：
    // 换一种提问方法，就是怎么保证数据的安全性？
     // 静态域、volatile域、final域、正常锁定访问的域、放入并发集合中

}
