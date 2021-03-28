package readandwrite.book.cyc2018.javabingfa.xianchengchi;

/**
 * @Description 通过调用一个线程的interrupt()来中断线程 如果该线程出于阻塞、限期等待或者无限期等待 就会抛出InterruptedException
 * 从而提前结束该线程。但是不能中断IO阻塞和synchronized锁阻塞。
 * @CreateDate 18/07/23 17:16
 * @Author zohn
 * @Version 1.0
 */
public class InterruptedException {
    private static class MyThread extends Thread {
        @Override
        public void run() {
            try {
                Thread.sleep(1000);// sleep()可能会抛出InterruptedException 因为异常不能夸线程传播回main()中
                // 因此必须在本地处理
                System.out.println("Thread  Run");
            } catch (java.lang.InterruptedException e) {
                e.printStackTrace();
            }
        }

        public static void main(String[] args) {
            MyThread myThread = new MyThread();
            myThread.start();
            myThread.interrupt();
            System.out.println("Main Run");
        }
    }


    private static class MyThread2 extends Thread {
        @Override
        public void run() {
            while (!interrupted()) {
                System.out.println("myThread2 has been not interrupted");
            }
            System.out.println("Thread End");
        }

        public static void main(String[] args) throws java.lang.InterruptedException {
            MyThread2 myThread2 = new MyThread2();
            myThread2.start();
            Thread.sleep(5000); // 运行10秒 interrupt
            myThread2.interrupt();
        }
    }
}
