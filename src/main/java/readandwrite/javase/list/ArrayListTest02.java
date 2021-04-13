package readandwrite.javase.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * list为null时 foreach会报错
 */
public class ArrayListTest02 {
    public static void main(String[] args) {

        List<String> stringList = new ArrayList<>(10);

        if (!stringList.isEmpty()) {
            for (String str : stringList) {
                System.out.println(str);
                System.out.println(111);
            }
        }


        // stringList = null;
        if (!stringList.isEmpty()) {
            for (String str : stringList) {
                System.out.println(str);
            }
        }

    }
}
