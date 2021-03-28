package readandwrite.javagame;

public class GameThread extends Thread {

    private GamePanel panel;

    public GameThread(GamePanel panel) {
        this.panel = panel;
    }

    @Override
    public void run() {
        while (true) {
            try {
                //程序运行暂停 0.01秒
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            //循环逻辑的执行
            panel.logic();

            //页面刷新
            panel.repaint();
        }
    }
}
