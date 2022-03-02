package readandwrite.javase.map;

import java.util.HashMap;
import java.util.Hashtable;

/**
 * @ClassName HashtableAndHashMap
 * @Description TODO
 * @Date 2022/3/2 18:53
 * @Version 1.0
 **/
public class HashtableAndHashMap {
    public static void main(String[] args) {
        HashMap<Object, Object> map = new HashMap<>();

        map.put("name", "张三");

        Hashtable<Object, Object> hashtable = new Hashtable<>();

        hashtable.put("name", "王五");

        boolean 王五 = hashtable.contains("王五");
        boolean 张三 = hashtable.contains("张三");
        System.out.println(王五);
        System.out.println(张三);


        boolean name = map.containsKey("name");
        boolean 张三1 = map.containsValue("张三");

        System.out.println(name);
        System.out.println(张三1);
    }
}
