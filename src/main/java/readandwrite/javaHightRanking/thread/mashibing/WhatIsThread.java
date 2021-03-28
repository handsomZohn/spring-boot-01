package readandwrite.javaHightRanking.thread.mashibing;

import java.util.concurrent.TimeUnit;

/**
 * 示例什么是线程
 *
 * @author Administrator
 */
public class WhatIsThread {

    static int maxi = 10;

    private static class T1 extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < maxi; i++) {
                try {
                    TimeUnit.MICROSECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("T1");
            }
        }
    }

    public static void main(String[] args) {
        new T1().start();
        for (int i = 0; i < maxi; i++) {
            try {
                TimeUnit.MICROSECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("main");
        }
    }
}
