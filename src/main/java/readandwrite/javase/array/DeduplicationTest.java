package readandwrite.javase.array;

import java.util.*;

/**
 * 去重
 *
 * @author Administrator
 */
public class DeduplicationTest {
    /**
     * 通过list
     * 去重不排序
     *
     * @param ints
     */
    public static void deduplicationButNoSort(int[] ints) {
        List<Integer> list = new ArrayList<>();
        Arrays.stream(ints).forEach(i -> {
            if (!list.contains(i)) {
                list.add(i);
            }
        });
        System.out.println("======^_^======variable list value is : " + list + ", " + " current method and class name is : DeduplicationTest.deduplicationButNoSort()");
        // System.out.println(list);
    }

    /**
     * 通过list和HashSet
     * 去重不排序
     *
     * @param ints
     */
    public static void deduplicationButNoSort02(int[] ints) {
        List<Integer> list = new ArrayList<>();
        Arrays.stream(ints).forEach(i ->  list.add(i));
        HashSet<Integer> integers = new HashSet<>();
        integers.addAll(list);
        System.out.println("======^_^======variable integers value is : " + integers + ", " + " current method and class name is : DeduplicationTest.deduplicationButNoSort02()");
        // System.out.println(list);
    }

    /**
     * 通过HashSet
     * 去重不排序
     *
     */
    public static void deduplicationButNoSort03() {
        Integer[] ints = {88, 89, 895, 88, 99, 87, 25, 65, 87};
        HashSet<Integer> integers = new HashSet<>(Arrays.asList(ints));
        System.out.println("======^_^======variable integers value is : " + integers + ", " + " current method and class name is : DeduplicationTest.deduplicationButNoSort03()");
        // integers.forEach( x -> System.out.println("======^_^======variable x value is : " + x + ", " + " current method and class name is : DeduplicationTest.deduplicationButNoSort03()"));
    }

    /**
     * 通过TreeSet
     * 去重,排序(正序，倒序)
     * 自定义排序参考连接
     * https://www.cnblogs.com/DreamDrive/p/5487087.html
     */
    public static void deduplicationAndSort() {
        Integer[] ints = {88, 89, 895, 88, 99, 87, 25, 65, 87};
        TreeSet<Integer> integers = new TreeSet<>(Arrays.asList(ints));
        System.out.println("DEFAULT ASC:");
        System.out.println("======^_^======variable integers value is : " + integers + ", " + " current method and class name is : DeduplicationTest.deduplicationAndSort()");
        NavigableSet<Integer> descendingSet = integers.descendingSet();
        System.out.println("AFTER DESC:");
        System.out.println("======^_^======variable descendingSet value is : " + descendingSet + ", " + " current method and class name is : DeduplicationTest.deduplicationAndSort()");
    }

    public static void main(String[] args) {
        int[] ints = {88, 89, 895, 88, 99, 87, 25, 65, 87};
        deduplicationButNoSort(ints);
        deduplicationButNoSort02(ints);
        deduplicationButNoSort03();
        deduplicationAndSort();
    }
}
