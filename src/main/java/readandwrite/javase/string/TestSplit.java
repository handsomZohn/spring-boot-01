package readandwrite.javase.string;

import java.util.Arrays;

/**
 * 测试split，当分隔符不存在时会不会出现异常
 */
public class TestSplit {
    public static void main(String[] args) {
        String str = "1,2,3";
        String str02 = "1";

        String[] split = str.split(",");
        Arrays.asList(split).forEach(System.out::print);
        System.out.println(split);

        String[] split1 = str02.split(",");
        System.out.println(split1);
        Arrays.asList(split1).forEach(System.out::print);
    }
}
