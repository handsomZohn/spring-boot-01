package readandwrite.javaHightRanking.thread.lock;
/**
 *@Description
 *@CreateDate   18/10/19 10:19
 *@Author        zohn
 *@Version       1.0
 *https://www.cnblogs.com/pullein/p/6232119.html
 */
// 死锁：
//形成死锁的条件：
// 1.互斥：有共享资源，有锁、
// 2.持有与请求：当前线程至少持有一个资源并且在等待获取被其他线程持有的资源
// 3.非剥夺：分配的资源不能从响应的线程中被强制剥夺[就是我占有的资源不能被强制抢走]
// 4.循环等待：第一个线程等待第二个线程，第二个线程又在等待第一个线程，形成[环路]
//死锁的预防：
// 1.加锁的顺序：确保所有的线程按照相同的顺序获得锁[需要事先知道所用到的锁，有时候无法预知]
// 2.加锁的时限：在尝试获取锁的时候加一个超时时限：如果超过时限，则放弃对该锁的请求，然后进行回退，并释放所有已获得的锁；
// 3.死锁监测：
//
//
public class DeadLock {

    static Object lockA = new Object();
    static Object lockB = new Object();

    // 这个地方不能用debug模式运行  debug模式运行是单线程。
    // 用run方式运行，debug模式不能每次都完美复现线程死锁。
    public static void main(String[] args) {
        new Thread(() -> {
            synchronized (lockA) {
                System.out.println("第一个线程调用A");
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lockB) {
                    System.out.println("第一个线程调用B");
                }
            }
        }).start();


        new Thread(() -> {

            synchronized (lockB) {
                System.out.println("第二个线程调用B");
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lockA) {
                    System.out.println("第二个线程调用A");
                }
            }

        }).start();
    }
}

