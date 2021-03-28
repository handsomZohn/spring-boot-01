package readandwrite.javase.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @Description 在Java中遍历HashMap的5种最佳方法
 * @CreateDate 2020/4/2 20:27
 * @Author zohn
 * @Version 1.0
 */
public class IteratorHashMapExample {
    public static void main(String[] args) {
        HashMap<Integer, String> hashMap = new HashMap() {{
            put(1, "C");
            put(2, "C++");
            put(3, "Java");
            put(4, "Spring Framework");
            put(5, "Hibernate ORM framework");
        }};

        String EntrySet = "EntrySet";
        System.out.println("======^_^======variable EntrySet value is : " + EntrySet + ", " + " current method and class name is : IteratorHashMapExample.main()");

        // 通过EntrySet遍历
        iteratorByEntrySet(hashMap);

        String KeySet = "KeySet";
        System.out.println("======^_^======variable KeySet value is : " + KeySet + ", " + " current method and class name is : IteratorHashMapExample.main()");
        // 通过KeySet遍历
        iteratorByKeySet(hashMap);

        // 通过for-each遍历map
        iteratorByForEach(hashMap);

        // 通过lambda遍历map
        iteratorByLambda(hashMap);

        // 通过stream API遍历map
        iteratorByStreamAPI(hashMap);
    }

    /**
     * @Description 使用Iterator遍历HashMap EntrySet
     * @Author zohn
     * @Date 2020/4/2 20:31
     * @Param [hashMap]
     * @Return void
     */
    static void iteratorByEntrySet(HashMap<Integer, String> hashMap) {
        Iterator<Map.Entry<Integer, String>> iterator = hashMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, String> entry = iterator.next();
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
    }

    /**
     * @Description 使用Iterator遍历HashMap KeySet
     * @Author zohn
     * @Date 2020/4/2 20:37
     * @Param [hashMap]
     * @Return void
     */
    static void iteratorByKeySet(HashMap<Integer, String> hashMap) {
        Iterator<Integer> keySet = hashMap.keySet().iterator();
        while (keySet.hasNext()) {
            Integer key = keySet.next();
            System.out.println(key);
            System.out.println(hashMap.get(key));
        }
    }

    /**
     * @Description 使用for-each遍历map
     * @Author zohn
     * @Date 2020/4/2 20:47
     * @Param [hashMap]
     * @Return void
     */
    static void iteratorByForEach(HashMap<Integer, String> hashMap) {
        for (Map.Entry<Integer, String> entry : hashMap.entrySet()
        ) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
    }

    /**
     * @Description 使用lambda遍历map
     * @Author zohn
     * @Date 2020/4/2 21:12
     * @Param [hashMap]
     * @Return void
     */
    static void iteratorByLambda(HashMap<Integer, String> hashMap) {
        hashMap.forEach((k,v) -> {
            System.out.println(k);
            System.out.println(v);
        });
    }

    /**
     * @Description 使用streamAPI遍历map
     * @Author zohn
     * @Date 2020/4/2 21:14
     * @Param [hashMap]
     * @Return void
     */
    static void iteratorByStreamAPI(HashMap<Integer, String> hashMap) {
        hashMap.entrySet().stream().forEach(entry -> {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        });
    }
}
