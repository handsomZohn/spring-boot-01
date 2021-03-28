package readandwrite.book.cyc2018.javabingfa.thread;

/**
 *@Description  用lambda创建线程
 *@CreateDate   18/07/19 9:42
 *@Author        zohn
 *@Version       1.0
 *
 */
public class ThreadExample {
    public static void main(String[] args) {
        // 1.8之前
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Before Java8");
            }
        }).start();
        // 1.8之后 用lambda之后变得很简洁
        new Thread(()-> System.out.println("After Java8")).start();
    }
}
