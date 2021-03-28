package readandwrite.book.alibaba.equals;

import java.util.Objects;

/**
 * @Description Object的equals方法容易抛出空指针异常，应使用常量或确定有值的对象来调用equals
 * @Author zohn
 * @Date 2020\1\7 0007 9:21
 * @Param 
 * @Return
 */
public class EqualsTest {
    public static void main(String[] args) {
        String str01 = "001";
        String str02 = null;
        // System.out.println(str01.equals(str02));// Exception in thread "main" java.lang.NullPointerException

        boolean equals = Objects.equals(str01, str02);

        System.out.println("======^_^======变量equals值为: " + equals + ", " + "当前类以及方法名字是: EqualsTest.main()");

        // 经过测试Objects.equals(str01, str02) 是比较通用的
        // 以后（2020.01.07开始）经手的所有代码，在1.7以及以上的，要用Objects.equals(str01, str02)。
    }
}
