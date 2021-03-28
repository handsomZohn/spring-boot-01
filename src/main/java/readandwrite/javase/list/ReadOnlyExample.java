package readandwrite.javase.list;

import java.util.*;

/**
 * @Description 通过Collections.unmodifiable...实现不可变集合
 * @CreateDate 18/10/10 16:17
 * @Author zohn
 * @Version 1.0
 */
public class ReadOnlyExample {

    // 不可变集合
    public static void main(String[] args) {
        Set set = new HashSet();
        List list = new LinkedList();
        set.add("a");
        set.add("b");
        set.add("c");
        set = Collections.unmodifiableSet(set);
        list = Collections.unmodifiableList(list);
        set.add("d");// java.lang.UnsupportedOperationException
    }
}
