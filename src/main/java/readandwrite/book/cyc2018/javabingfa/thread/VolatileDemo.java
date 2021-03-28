package readandwrite.book.cyc2018.javabingfa.thread;

/**
 *@Description
 *@CreateDate   18/08/13 12:53
 *@Author        zohn
 *@Version       1.0
 *
 */
public class VolatileDemo {
    private volatile int num = 0;

    public int getNumber(){
        return this.num;
    }

    public void increase(){
        this.num++;
    }

    public static void main(String[] args) {
        final VolatileDemo volatileDemo = new VolatileDemo();
        for (int i = 0; i < 500; i++) {
//            new Thread(()->
//                volatileDemo.increase()
//            ).start();

            new Thread(new Runnable() {
                @Override
                public void run() {
                    volatileDemo.increase();
                }
            }).start();
        }

        // 主线程让出资源
        while (Thread.activeCount() > 1) {
            Thread.yield();
        }
        System.out.println(volatileDemo.getNumber());
    }
}
