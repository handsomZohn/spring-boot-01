package readandwrite.book.cyc2018.javabingfa.thread;

import java.util.concurrent.TimeUnit;

/**
 * @Description volatile 保证任何一个线程在读取该域的时候都将看到最新写入的值；
 * @CreateDate 18/08/07 16:05
 * @Author zohn
 * @Version 1.0
 */
public class FixStopThread02 {
    private static volatile boolean stopRequested;

    public static void main(String[] args) {
        new Thread(() ->{
            int i = 0;
            while (!stopRequested) {// 新创建线程可以看到被主线程修改过的值;
                i++;
                System.out.println(i + "sml");
            }
        }).start();
        try {
            TimeUnit.SECONDS.sleep(1);
            stopRequested = true;// 主线程更改值
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
