package readandwrite.book.cyc2018.newCharacteristics.eeight.stream;

import java.util.ArrayList;
import java.util.Optional;

/**
 * @Description 并行流demo
 * @CreateDate 18/09/17 13:57
 * @Author zohn
 * @Version 1.0
 */
public class ParallelDemo {
    public static void main(String[] args) {
        ArrayList<Integer> myList = new ArrayList<>();
        myList.add(7);
        myList.add(18);
        myList.add(10);
        myList.add(24);
        myList.add(5);


        Optional<Integer> parallelReduce = myList.parallelStream().reduce((a, b) -> (a * b));
        // 并行计算，保持计算结果和串行计算的结果一致：
        // 并行计算，有硬件要求，需要多核处理器
        if (parallelReduce.isPresent()) {
            System.out.println("并行计算：");
            System.out.println(parallelReduce.get());
        }
        // < U > U reduce(U identityVal, BiFunction< U, ? super T, U > accumulator, BinaryOperator< U > combiner)
        Integer reduce = myList.parallelStream().reduce(1, (a, b) -> (a * b),  (a, b) -> (a * b));
        System.out.println("accumulator和combiner执行的是相同的操作:" + reduce);

        // accumulator和combiner执行的是相同的操作。但是有些情况下，accumulator的执行与combiner的操作必须不同

    }
}
