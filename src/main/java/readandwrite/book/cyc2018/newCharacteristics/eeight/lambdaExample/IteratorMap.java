package readandwrite.book.cyc2018.newCharacteristics.eeight.lambdaExample;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description Java8新特性之forEach+Lambda 表达式遍历Map
 * @CreateDate 18/07/19 11:39
 * @Author zohn
 * @Version 1.0
 */
public class IteratorMap {
    public static void main(String[] args) {
        Map<String, Integer> items = new HashMap<>();
        items.put("A", 10);
        items.put("B", 20);
        items.put("C", 30);
        items.put("D", 40);
        items.put("E", 50);
        items.put("F", 60);
        // 1.8之前
        for (Map.Entry<String, Integer> entry : items.entrySet()) {
            System.out.println("item: " + entry.getKey() + " Count: " + entry.getValue());
        }
        // 1.8之后 直接输入就在>后面直接+System.out.println
        items.forEach((k, v) -> System.out.println("item: " + k + ",Count: " + v));

        // 有对集合元素操作的就在>后面加上{},然后再{}里面对数据进行操作
        items.forEach((k, v) -> {
            if ("A".equals(k)) {
                System.out.println(v);
            }
        });
    }
}
