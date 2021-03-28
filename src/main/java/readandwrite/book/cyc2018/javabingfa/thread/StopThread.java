package readandwrite.book.cyc2018.javabingfa.thread;

import java.util.concurrent.TimeUnit;

/**
 *@Description  Thread.stop. 由于没有同步，就不能保证后台线程何时‘看到’主线程对stopRequested的值所做的改变
 *@CreateDate   18/08/07 15:30
 *@Author        zohn
 *@Version       1.0
 *
 */
public class StopThread {
    private static boolean stopRequest;
    public static void main(String[] args) {
        new Thread(() ->{
            int i = 0;
            while (!stopRequest) {// 新启动线程看不到主线程对stopRequest域做的修改 所以就会一直运行；
                i++;
            }
        }).start();

        try {
            TimeUnit.SECONDS.sleep(1);
            stopRequest = true;// 主线程做修改
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    // 没有同步 虚拟机将这个代码：
    // while (!done)
    //     i++;
    // 转换为
    // if ()
    //     while(true)
    //         i++
    // 这种优化叫做提升（hoisting）正是HopSpot Server VM的工作。结果是个活性失败（liveness failure）：
    // 这个程序无法前进
    // 修正这个问题的一种解决方式是同步访问stopRequested域
}
