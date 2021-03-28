package readandwrite.book.cyc2018.newCharacteristics.eeight.stream;

import java.util.ArrayList;
import java.util.stream.Stream;

/**
 * https://blog.csdn.net/zxc123e/article/details/50533760
 *
 * @Description 使用map()方法的一个简单例子。这个程序计算ArrayList中值得平方根的乘积。元素的平方根被首先映射到一个新流。然后，
 * 使用reduce()方法计算乘积。
 * 最后，演示了各种流操作。
 * @CreateDate 18/09/17 11:39
 * @Author zohn
 * @Version 1.0
 */
public class StreamDemo02 {

    public static void main(String[] args) {

        ArrayList<Double> myList = new ArrayList<>();
        myList.add(7.0);
        /*myList.add(18.0);
        myList.add(10.0);
        myList.add(24.0);
        myList.add(5.0);*/

        // 映射元素的平方根到新流
        // Stream<Double> stream = myList.stream((i) -> i);
        // Double reduce = stream.reduce(1.0, (a, b) -> (a * b));
        // System.out.println("product of square roots is " + reduce);
    }
}
