package readandwrite.book.cyc2018.newCharacteristics.eeight.stream;

import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * https://blog.csdn.net/zxc123e/article/details/50533760
 * @Description 创建了一个叫myList的ArrayList，用于存储整数集合（自动装箱为Integer引用类型）。然后，获得一个使用myList作为源的流。
 * 最后，演示了各种流操作。
 * @CreateDate 18/09/17 11:39
 * @Author zohn
 * @Version 1.0
 */
public class StreamDemo {

    public static void main(String[] args) {

        ArrayList<Integer> myList = new ArrayList<>();
        myList.add(7);
        myList.add(18);
        myList.add(10);
        myList.add(24);
        myList.add(5);

        // 最大最小值；
        Stream<Integer> integerStream = myList.stream(); // 获取流

        Optional<Integer> min = integerStream.min(Integer::compareTo);// list中最小

        if (min.isPresent()){
            System.out.println("Min value:" + min.get());
        }

        // Exception in thread "main" java.lang.IllegalStateException: stream has already been operated upon or closed
        //	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:229)
        // 必须获得一个新的流，因为调用MIN（）是所消耗的流的终端的操作。
        integerStream = myList.stream();
        Optional<Integer> max = integerStream.max(Integer::compare);

        if (max.isPresent()){
            System.out.println("Max value:" + max.get());
        }


        // 排序

        Stream<Integer> sorted = myList.stream().sorted();

        // 使用forEach（）显示已排序的流。
        System.out.println("sorted stream: ");
        System.out.println();

        // 只显示奇数
        Stream<Integer> odd = myList.stream().sorted().filter((n) -> (n % 2 == 1));
        System.out.println("odd values:");
        // odd.forEach((n) -> System.out.println(n + ""));
        odd.forEach(System.out :: println);

        // 只显示大于5的奇数
        Stream<Integer> oddBigerThan5 = myList.stream().sorted().filter((n) -> (n % 2 == 1)).filter((n) -> (n > 5));
        System.out.println("odd values that bigger than 5 :");
        oddBigerThan5.forEach(System.out :: println);
    }
}
