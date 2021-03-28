package readandwrite.javagame;

import javax.swing.*;

public class GameFrame extends JFrame {
    private int width = 600, height = 400;

    public GameFrame() {
        //设置窗体标题
        this.setTitle("java游戏开发杂谈-台哥出品");

        //创建一个画布
        GamePanel panel = new GamePanel(width, height);
        //把画布加入到窗体中
        getContentPane().add(panel, "Center");

        //设置窗体大小
        this.setSize(width, height);
        //设置能否调整窗体大小
        this.setResizable(false);
        //这句会使得在屏幕上居中显示
        this.setLocationRelativeTo(null);
        //当关闭窗体的时候退出程序
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        //把窗体显示出来
        this.setVisible(true);

        //开始游戏线程的循环
        GameThread gt = new GameThread(panel);
        gt.start();
    }

    /**
     * 主方法
     */
    public static void main(String[] args) {
        GameFrame frame = new GameFrame();
    }
}
