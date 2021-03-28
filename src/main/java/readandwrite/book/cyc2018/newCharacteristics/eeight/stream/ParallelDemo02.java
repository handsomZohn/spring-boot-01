package readandwrite.book.cyc2018.newCharacteristics.eeight.stream;

import java.util.ArrayList;
import java.util.Optional;

/**
 * @Description 并行流demo
 * @CreateDate 18/09/17 13:57
 * @Author zohn
 * @Version 1.0
 */
public class ParallelDemo02 {
    public static void main(String[] args) {
        ArrayList<Integer> myList = new ArrayList<>();
        myList.add(7);
        myList.add(18);
        myList.add(10);
        myList.add(24);
        myList.add(5);
        // < U > U reduce(U identityVal, BiFunction< U, ? super T, U > accumulator, BinaryOperator< U > combiner)
        // accumulator和combiner执行的是相同的操作。但是有些情况下，accumulator的执行与combiner的操作必须不同
        // 使用reduce()方法的合并器版本，计算列表中每个元素的平方根的乘积。
        // 累加器将两个元素的平方根相乘
        // 合并器将部分结果相乘
        // 因为是并行执行的 假设有两个并行执行，第一部分计算7*18*10，第二部分计算24*5
        //
        // 累加器的作用：[无状态，不干预，结合性]
        // 就是将第一部分的计算结果乘以第二部分计算结果
        // 就是7*18*10*24*5
        Double reduce = myList.parallelStream().reduce(1.0, (a, b) -> a * Math.sqrt(b), (a, b) -> (a * b));
        System.out.println("每个元素的平方根的乘积(并行流计算（正确）):" + reduce);

        // 在这个版本的reduce()方法中，累加器和合并器函数是同一个函数。这将导致错误，因为当合并两个部分结果时，相乘的是它们的平方根，
        // 而不是部分结果自身
        // 因为是用了并行流
        // (7*18*10)^2就是一个数的平方了不是两部分结果的积
        // 当使用并行流时，才会发生问题
        Double reduce1 = myList.parallelStream().reduce(1.0, (a, b) -> a * Math.sqrt(b), (a, b) -> a * Math.sqrt(b));

        // 串行流：
        Double reduce2 = myList.stream().reduce(1.0, (a, b) -> a * Math.sqrt(b), (a, b) -> a * Math.sqrt(b));

        System.out.println("每个元素的平方根的乘积(并行流计算（错误）):" + reduce1);
        System.out.println("每个元素的平方根的乘积(串行流计算（正确）):" + reduce2);
    }
}
