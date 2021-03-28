package readandwrite.javaHightRanking.thread.mashibing;

/**
 * @author Administrator
 */
public class T {
    private int count = 10;
    private Object o = new Object();

    public void m() {
        // 任何线程要想执行下面的代码，必须先拿到o的锁
        synchronized(o) {
            count--;
            System.out.println(Thread.currentThread().getName() + " count = " + count);
        }
    }
}
