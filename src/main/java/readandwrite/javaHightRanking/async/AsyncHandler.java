package readandwrite.javaHightRanking.async;

abstract class AsyncHandler {
    public void callback() {
        new Thread(() -> {
            try {
                //这里通过休眠一秒子线程来达到模拟handler耗时操作
                Thread.sleep(1000 * 5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            handle();
        }).start();
    }

    abstract public void handle();


}
