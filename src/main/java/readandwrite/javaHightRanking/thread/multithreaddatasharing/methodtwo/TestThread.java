package readandwrite.javaHightRanking.thread.multithreaddatasharing.methodtwo;

public class TestThread {
    public static void main(String[] args) {
        final MyData myData = new MyData();
        for (int i = 0; i < 2; i++) {
            new Thread(() -> myData.add()).start();


            new Thread(() -> myData.dec()).start();
        }
    }
}
