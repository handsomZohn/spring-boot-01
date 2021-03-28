package readandwrite.javagame;

import javax.swing.*;
import java.awt.*;

/**
 *@Description 游戏画布 
 *@CreateDate 2020\6\24 0024 14:36
 *@Author z
 *@Version 1.0
 */
public class GamePanel extends JPanel {
    /**
     * 屏幕的宽和高
     */
    private int width, height;

    public GamePanel(int width, int height) {
        this.width = width;
        this.height = height;
        this.setSize(width, height);

        //设置当前画布可以获得焦点。
        this.setFocusable(true);
    }

    /**
     * 方块的位置
     */
    private int fk_x = 60;
    private int fk_y = 60;


    /**
     * 画布的绘制
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        //画绿色背景
        g.setColor(new Color(0x9391d6));
        g.fillRect(0, 0, width, height);

        //绘制方块
        g.setColor(Color.red);
        g.fillRect(fk_x, fk_y, 80, 80);
    }


    /**
     * 游戏逻辑，处理方块的运动，每次横纵坐标都移动1个像素
     */
    public void logic() {
        if (fk_x < 260) {
            fk_x = fk_x + 1;
        } else {
            fk_x = 60;
        }

        if (fk_y < 260) {
            fk_y = fk_y + 1;
        } else {
            fk_y = 60;
        }
    }


}
