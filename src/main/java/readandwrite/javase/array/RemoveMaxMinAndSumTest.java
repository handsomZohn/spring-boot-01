package readandwrite.javase.array;



import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @Description 给定一串以‘,’分隔的字符，去除最大值和最小值之后求和
 * @CreateDate 2020\6\2 0002 15:14
 * @Author z
 * @Version 1.0
 */
public class RemoveMaxMinAndSumTest {

    @Test
    public void sum() {
        String str = "8,3,7,2,2,3,2,4,2,5,6,3,5,3,6,9,7,9";
        List list = Arrays.asList(str.split(","));
        System.out.println(Collections.max(list));
        System.out.println(Collections.min(list));
        str = str.replaceAll(Collections.max(list) + "", "0");
        str = str.replaceAll(Collections.min(list) + "", "0");
        List list1 = Arrays.asList(str.split(","));
        System.out.println(list1);
        int sum = list1.stream().mapToInt(r -> Integer.parseInt(r + "")).sum();
        System.out.println("======^_^======variable sum value is : " + sum + ", " + " current method and class name is : RemoveMaxMinAndSumTest.sum()");
    }
}
