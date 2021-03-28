package readandwrite.book.cyc2018.javabingfa.thread;

import java.util.concurrent.TimeUnit;

/**
 * @Description 一秒之内终止 注意写方法（requestStop）和读方法（stopRequested）都被同步了。
 * 只同步写方法还不够！实际上，如果读和写方法没有都同步，同步就不会起作用。
 * @CreateDate 18/08/07 15:46
 * @Author zohn
 * @Version 1.0
 */
public class FixStopThread {
    private static boolean stopRequested;

    private static synchronized void requestStop() {
        stopRequested = true;
    }

    private static synchronized boolean stopRequested() {
        return stopRequested;
    }

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            int i = 0;
            while (!stopRequested()) {
                i++;
                System.out.println(i + "sml");
            }
        }).start();
        TimeUnit.SECONDS.sleep(1);// 15万左右会有13万也会有16万 新学了一招让线程睡着的办法 效率更高点
        // Thread.sleep(1000); // 15万
        requestStop();
    }
}
