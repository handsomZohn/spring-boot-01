package readandwrite.book.cyc2018.javabingfa.threadxiezuo;

/**
 *@Description  线程之间的协作-join
 *@CreateDate   18/07/26 11:29
 *@Author        zohn
 *@Version       1.0
 *
 */
public class JoinExample {
    private class A extends Thread {
        @Override
        public void run() {
            System.out.println("A");
        }
    }
    private class B extends Thread {
        private A a;
        B(A a) {
            this.a = a;
        }

        @Override
        public void run() {
            try {
                a.join();// 在b中调用a b线程会等到a线程结束才继续执行 所以a线程的输出优先于b线程
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("B");
        }
    }

    public void test () {
        A a = new A();
        B b = new B(a);
        b.start();// b线程先启动 但是a线程先运行完毕
        a.start();
    }

    public static void main(String[] args) {
        JoinExample joinExample = new JoinExample();
        joinExample.test();
    }

}
