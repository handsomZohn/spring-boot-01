package readandwrite.book.cyc2018.javabingfa.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description 用三个线程按顺序循环打印abc三个字母，比如abcabcabc
 * @CreateDate 18/08/07 17:25
 * @Author zohn
 * @Version 1.0
 */
public class AbcThread implements Runnable {
    private ReentrantLock reentrantLock = new ReentrantLock();
    private Condition condition = reentrantLock.newCondition();
    private int state = 0;

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        reentrantLock.lock();
        // 进入临界区
        try {
            for (int i = 0; i < 10; i++) {
                if (name.equals("B")) {
                    // 只有a和a2同时为true时才打印B，否则阻塞当前线程
                    while (state % 3 != 1) {
                        condition.await();// 条件不满足，暂时阻塞线程，暂时释放lock
                    }
                } else if (name.equals("C")) {
                    while (state % 3 != 2) {
                        condition.await();
                    }
                } else if (name.equals("A")) {
                    while (state % 3 != 0) {
                        condition.await();
                    }
                }
                state++;
                System.out.print(name);
                condition.signalAll();// 通知正在等待的线程，此时有可能已经满足条件
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            reentrantLock.unlock();// 记得要释放锁
        }
    }

    public static void main(String[] args) {
        AbcThread task = new AbcThread();
        Thread thread1 = new Thread(task);
        Thread thread2 = new Thread(task);
        Thread thread3 = new Thread(task);
        thread1.setName("A");
        thread2.setName("B");
        thread3.setName("C");
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
