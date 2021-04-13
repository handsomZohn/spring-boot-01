package readandwrite.javase.list;

import java.util.ArrayList;
import java.util.List;

/**
 * 判断集合是否为空
 */
public class DetermineWhetherListIsEmpty {
    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();
        // stringList = null;
        stringList.isEmpty();
        System.out.println(stringList.isEmpty());
    }
}
