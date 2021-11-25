package readandwrite.javase.map;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class PutOfHashMap {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap();
        String key = "美团";
        map.put(key, "小美");
        // 第一步，先取到key的hashCode值
        int i = key.hashCode();
        System.out.println("======^_^======variable i value is : " + i + ", " + " current method and class name is : PutOfHashMap.main()");

        // 第二步，通过hash算法的后两步运算（高位运算和取模运算）来定位改键值对的存储位置
        int i1 = i ^ (i >>> 16);
        System.out.println("======^_^======variable i1 value is : " + i1 + ", " + " current method and class name is : PutOfHashMap.main()");

        int i2 = i1 & (map.size() - 1);
        System.out.println("======^_^======variable i2 value is : " + i2 + ", " + " current method and class name is : PutOfHashMap.main()");

        Collections.synchronizedMap(map);
    }
}
