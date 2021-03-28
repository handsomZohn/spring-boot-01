package readandwrite.javase.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description map转为list
 * @CreateDate 2020/4/4 17:03
 * @Author zz
 * @Version 1.0
 */
public class Map2List {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("1", "A");
        map.put("2", "B");
        map.put("3", "C");
        map.put("4", "D");
        map.put("5", "E");
        List<String> keylist = new ArrayList<>(map.keySet());
        for (String key : keylist) {
            System.out.println(key);
        }

        //List<String> valuesList = (List<String>) map.values();        //map.values()返回的是collection，通过arrayList的构造方法可以实现

        List<String> valuesList = new ArrayList<String>(map.values());

        for (String str : valuesList) {
            System.out.println(str);
        }

    }
}
