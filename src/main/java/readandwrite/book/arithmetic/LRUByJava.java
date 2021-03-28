package readandwrite.book.arithmetic;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 *@Description 手写一个java版本的lru
 *@CreateDate 2021\2\8 0008 13:59
 *@Author z
 *@Version 1.0
 */
public class LRUByJava<K,V> extends LinkedHashMap<K,V> {
    private int CACHE_SIZE;
    /**
     * 传递进来能缓存多少数据
     * @param cacheSize 缓存大小
     */
    public LRUByJava(int cacheSize){
        // true表示让linkedHashMap按照访问顺序来排序，最近访问的排在头部，最先（老）访问的排在尾部
        super((int)Math.ceil(cacheSize/0.75) + 1, 0.75f,true);
        CACHE_SIZE = cacheSize;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K,V> eldest){
        // 当map中的数据量大于指定的缓存的个数的时候，就自动删除最老的数据
        return size() > CACHE_SIZE;
    }
    public static void main(String[] args) {
        System.out.println(2>>>3);
    }
}
