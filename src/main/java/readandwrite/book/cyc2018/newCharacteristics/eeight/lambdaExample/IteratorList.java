package readandwrite.book.cyc2018.newCharacteristics.eeight.lambdaExample;

import java.util.Arrays;
import java.util.List;

/**
 *@Description  使用lambda表达式对列表进行迭代 针对集合类，最常见的操作就是进行迭代
 *@CreateDate   18/07/19 10:57
 *@Author        zohn
 *@Version       1.0
 *
 */
public class IteratorList {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("Lambda", "Default Method", "Stream  API", "Date And Time");
        // 1.8之前
        for (String l : list) {
            System.out.println(l);
        }
        // 1.8之后
        // lambda表达式
        list.forEach(str -> System.out.println(list));
        list.forEach(str -> System.out.println(str));
        // 方法引用
        list.forEach(System.out::print);
    }
}
