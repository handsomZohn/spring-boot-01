package readandwrite.javase.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * @Description java 获取键盘输入流
 * @Author zohn
 * @Date 2020\1\14 0014 16:48
 * @Param
 * @Return
 */
public class GetInputFromKeyboard {


    public static void main(String[] args) {
        getInput();
    }

    /**
     * @Description 获取输入的
     * @Author zohn
     * @Date 2020\1\14 0014 16:49
     * @Param []
     * @Return void
     */
    public static void getInput() {

        // 第一种方法
        System.out.println("type your name:");
        Scanner input = new Scanner(System.in);
        String string1 = input.nextLine();
        System.out.println("======^_^======变量string1值为: " + string1 + ", " + "当前类以及方法名字是: GetInputFromKeyboard.getInput()");

        // 第二种方法
        System.out.println("type your name002:");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String string = bufferedReader.readLine();
            System.out.println("======^_^======变量string值为: " + string + ", " + "当前类以及方法名字是: GetInputFromKeyboard.getInput()");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
