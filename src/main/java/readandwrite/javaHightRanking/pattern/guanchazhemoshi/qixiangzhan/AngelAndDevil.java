package readandwrite.javaHightRanking.pattern.guanchazhemoshi.qixiangzhan;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by zohn on 2017/12/11.
 */
public class AngelAndDevil {
    JFrame frame;

    public static void main(String[] args) {
            AngelAndDevil angelAndDevil = new AngelAndDevil();
            angelAndDevil.go();
    }

    private void go(){
        frame = new JFrame();
        JButton button = new JButton("Should I do it?");
        button.addActionListener(new AngelListener());
        button.addActionListener(new DevilListener());
        frame.getContentPane().add(BorderLayout.CENTER,button);
        frame.setSize(100,100);
        frame.setVisible(true);
    }

    class AngelListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            System.out.println("Don't do it You might regret it!");
        }
    }

    class DevilListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            System.out.println("Come on, do it!");
        }
    }
}
