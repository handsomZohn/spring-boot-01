package readandwrite.javase.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @Description 换个方式写HashMap
 * @CreateDate 18/08/09 13:38
 * @Author zohn
 * @Version 1.0
 */
public class HashMapNewWrite {
    public static void main(String[] args) {
        Map<String, String> hashMap = new HashMap() {{
            put("name", "张三");
            put("name", "张三");// 不可重复
            put("age", "20");
            put("birthday", "1995-01-30");
            put(null,"123");
        }};

        // 遍历map

        // 第一种
        System.out.println("\n通过Map.keySet遍历key和value");
        for (String key : hashMap.keySet()) {
            System.out.println("Key:" + key + " Value:" + hashMap.get(key));
        }

        // 第二种
        System.out.println("\n通过Map.entrySet使用iterator遍历key和value");
        Iterator<Map.Entry<String, String>> iterator = hashMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> next = iterator.next();
            System.out.println("Key:" + next.getKey() + " Value:" + next.getValue());
        }

        // 第三种 推荐 尤其是容量大的时候
        System.out.println("\n通过Map.entrySet遍历key和value");
        for (Map.Entry<String, String> entry : hashMap.entrySet()) {
            System.out.println("Key:" + entry.getKey() + " Value:" + entry.getValue());
        }

        // 第四种
        System.out.println("\n通过Map.values()遍历所有的value，但是不能遍历key");
        for(String v: hashMap.values()){
            System.out.println(v);
        }

        //
        System.out.println("获取key为null的值：");
        String key = null;
        if (hashMap.containsKey(key)){
            System.out.println("Value:" + hashMap.get(key));
        }
        if (true)
                ;
            else
                ;
    }
}
