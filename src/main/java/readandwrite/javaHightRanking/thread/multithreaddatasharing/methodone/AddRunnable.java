package readandwrite.javaHightRanking.thread.multithreaddatasharing.methodone;

/**
 * 线程使用类的对象调用类的方法 对类的数据进行操作
 */
public class AddRunnable implements Runnable{

    MyData myData;

    public AddRunnable(MyData myData) {
        this.myData = myData;
    }

    @Override
    public void run() {
        myData.add();
    }
}
