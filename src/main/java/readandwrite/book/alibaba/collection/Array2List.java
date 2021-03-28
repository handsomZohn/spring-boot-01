package readandwrite.book.alibaba.collection;

import java.util.Arrays;
import java.util.List;

public class Array2List {
    public static void main(String[] args) {
        String[] strArr = {"001", "002", "003", "004", "005"};
        List<String> asList = Arrays.asList(strArr);
        System.out.println("======^_^======变量asList值为: " + asList + ", " + "当前类以及方法名字是: Array2List.main()");

        // 加一个元素试试 然后就  Exception in thread "main" java.lang.UnsupportedOperationException
        // asList.add("006");

        // asList.get(1)也会被修改了。
        strArr[1] = "0001";

        System.out.println("======^_^======变量asList值为: " + asList + ", " + "当前类以及方法名字是: Array2List.main()");
    }
}
