package readandwrite.javaHightRanking.async;


import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 参考连接
 * https://blog.csdn.net/tyBaoErGe/article/details/50097591
 */
public class Worker {
    static final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

    public void startWork(int i, AsyncHandler handler) {
        /*
         * code......
         * 一些业务操作完成,需要调用外部传入的handler来完成耗时操作
         */
        System.out.println("worker-" + i + " start Work @" + format.format(new Date()));
        handler.callback();//这里直接调用handler定义的模板方法callback
    }

    public static void main(String[] args) {
        //一个匿名的AsyncHandler 实现类,具体的实现为打印一句话
        AsyncHandler handler = new AsyncHandler() {

            @Override
            public void handle() {
                System.out.println("handler start @ " + format.format(new Date()));
            }
        };
        Worker worker = new Worker();
        worker.startWork(1, handler);
        System.out.println("main thread ending @" + format.format(new Date()));
    }
}


//    CallAccAsyncHandler handler = new CallAccAsyncHandler() {
//        @Override
//        public void handle() {
//            voucherService.synchroFinance(voucherIds);
//        }
//    };
//        handler.callback();