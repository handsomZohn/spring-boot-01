package readandwrite.book.cyc2018.newCharacteristics.eeight.lambdaExample;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description 复制不同的值，创建一个子列表 本例展示了如何利用流的 distinct() 方法来对集合进行去重。
 * @CreateDate 18/07/19 17:28
 * @Author zohn
 * @Version 1.0
 */
public class CreateSeedList {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(9, 10, 3, 4, 7, 3, 4);
        List<Integer> distinct = numbers.stream().map(i -> i * i).distinct().collect(Collectors.toList());
        System.out.printf("Original List: %s, Square Without duplicates : %s %n", numbers, distinct);
    }
}
