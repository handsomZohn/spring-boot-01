package readandwrite.javaHightRanking.thread.multithreaddatasharing.methodone;

public class DecRunnable implements Runnable{

    MyData myData;

    public DecRunnable(MyData myData) {
        this.myData = myData;
    }

    @Override
    public void run() {
        myData.dec();
    }
}
