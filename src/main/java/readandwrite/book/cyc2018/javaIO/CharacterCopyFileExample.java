package readandwrite.book.cyc2018.javaIO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *@Description  使用字符流进行文件复制
 *@CreateDate   18/07/18 14:55
 *@Author        zohn
 *@Version       1.0
 *
 */
public class CharacterCopyFileExample {
    public static void main(String[] args) throws IOException {
        String src = "d:\\licence.txt", dist = "e:\\licence.txt";
        System.out.println("复制文件开始：" + System.currentTimeMillis());
        copyFile(src,dist);
        System.out.println("复制文件结束：" + System.currentTimeMillis());
        readLine(src);
    }

    /**
     *
     * @param src 原文件路径
     * @param dist 目标文件路径
     * @throws IOException
     */
    static void copyFile(String src, String dist) throws IOException{
        FileReader fileReader = new FileReader(src);
        FileWriter fileWriter = new FileWriter(dist);
        char[] chuf = new char[20 * 1024];
        while (fileReader.read(chuf, 0, chuf.length) != -1){
            fileWriter.write(chuf);
        }
        fileWriter.close();
        fileReader.close();
    }

    /**
     * 逐行输出文件内容
     * @param src 源文件路径
     * @throws IOException
     */
    static void readLine(String src) throws  IOException{
        FileReader fileReader = new FileReader(src);
        // 装饰者模式使得BufferedReader组合一个FileReader对象
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        while ((line = bufferedReader.readLine()) != null){
            System.out.println(line);
        }
        // 在调用BufferedReader的close()方法时,会去调用FileReader的close()方法
        // 只需调用一次即可
        bufferedReader.close();
    }
    // 编码就是把字符转换为字节 解码就是把字节重新组合成字符;
}
