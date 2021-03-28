package readandwrite.book.cyc2018.newCharacteristics.eeight.lambdaExample;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @Description 使用Java 8 lambda表达式进行事件处理 用lambda表达式写出更好的事件监听代码
 * @CreateDate 18/07/19 10:36
 * @Author zohn
 * @Version 1.0
 */
public class EventProcessing {
    public static void main(String[] args) {
        JButton button = new JButton("Show");
        // 1.8之前
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Event handing without zlambda is boring");
            }
        });
        // 1.8之后
        button.addActionListener((e) -> {
            System.out.println("Light, Camera, Action !! Lambda expressions Rocks");
        });
    }
    // Java开发者经常使用匿名类的另一个地方是为 Collections.sort() 定制 Comparator。
    // 在Java 8中，你可以用更可读的lambda表达式换掉丑陋的匿名类。
    // 我把这个留做练习，应该不难，可以按照我在使用lambda表达式实现 Runnable 和 ActionListener 的过程中的套路来做。
}
