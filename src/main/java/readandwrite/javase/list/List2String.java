package readandwrite.javase.list;



import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 *@Description list 转为string
 *@CreateDate 2020/4/4 16:28
 *@Author zohn
 *@Version 1.0
 */
public class List2String {

    @Test
    public void list2String(){
        List arrayList = new ArrayList();
        arrayList.add("1");
        arrayList.add("2");
        arrayList.add("3");
        arrayList.add("4");
        arrayList.add("5");

        String join = String.join(",", arrayList);

        System.out.println("======^_^======variable join value is :" + join + ", " + " current method and class name is : List2String.list2String()");
    }
}
