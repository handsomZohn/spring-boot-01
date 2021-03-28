package readandwrite.book.cyc2018.javabingfa.thread;

import static java.lang.Thread.currentThread;

/**
 * Created by zohn on 2016-09-27.
 * 1、extends Thread
 * 2、implements Runnable
 */
public class Thread01 {

    public static void main(String[] args) {

       //第一种创建线程的方式 new Thread(){}.start();
        new Thread(){
                    @Override
                    public void run(){
                try {
                    int i = 0;
                    while (i<2){
                        //TimeUnit.SECONDS.sleep(1); //走到这个地方，停一秒
                       // TimeUnit.MINUTES.sleep(1);   //走到这个点，挺一分钟
                        System.out.println("1name:"+currentThread().getName());
                        i++;
                    }
                }catch (Exception  e){
                    e.printStackTrace();
                }
            }
        }.start(); //对象.start();表示让该线程起来

        // 第二种创建线程的方式  new Thread(Runnable target,String name).start();
        // 可以用lambda替换匿名类
        new Thread(new Runnable(){
                    public void run(){
                        try {
                    int i = 0;
                    while (i<2){
                        System.out.println("2name:"+currentThread().getName());
                        i++;
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        },"Thread-zidingyi").start(); //"Thread-自己起的名字" 可变参数，是创建 线程的名字；zidingyi；

        //将两种方式结合起来 先走三还是先走四？看看打印结果 new Thread(Runnable target,String name){}.start();
        new Thread(new Runnable(){
            public void run(){
                try {
                    int i = 0;
                    while (i<2){
                        System.out.println("3name:"+currentThread().getName());
                        i++;
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        },"All Over The World"){
            @Override
            public void run(){
                try {
                    int i = 0;
                    while (i<2){
                        System.out.println("4name:"+currentThread().getName());
                        i++;
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }.start();
        /*
        第三家线程根本没有输出！因为，三和四 线程 只启动了一个，
        下面的匿名类继承自Thread，并把Thread里面的run方法覆盖了。
         */


      //main 方法
    }

    //类
}
