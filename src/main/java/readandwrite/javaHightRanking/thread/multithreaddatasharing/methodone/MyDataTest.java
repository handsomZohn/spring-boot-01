package readandwrite.javaHightRanking.thread.multithreaddatasharing.methodone;

public class MyDataTest {
    public static void main(String[] args) {
        MyData myData = new MyData();

        /**
         * 要保证数据操作的原子性和一致性
         * 必须在传入参数时使用同一个data对象入参
         */
        AddRunnable addRunnable = new AddRunnable(myData);
        DecRunnable decRunnable = new DecRunnable(myData);

        for (int i = 0; i < 2; i++) {
            new Thread(addRunnable).start();
            new Thread(decRunnable).start();
        }
    }
}
