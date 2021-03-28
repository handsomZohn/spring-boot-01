package readandwrite.javaHightRanking.thread;

import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Description 读锁 写锁 例子
 * @Author z
 * @Date 2021\2\1 0001 17:53
 * @Param 
 * @Return 
 */
public class RWSample {
    private final Map<String, String> map = new TreeMap<>();
    private final ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
    private final Lock rLock = reentrantReadWriteLock.readLock();
    private final Lock wLock = reentrantReadWriteLock.writeLock();

    public String get (String key){
        rLock.lock();
        System.out.println("读锁锁定");
        try {
            return map.get(key);
        } finally {
            rLock.unlock();
        }
    }

    public String put (String key, String value) {
        wLock.lock();
        System.out.println("写锁锁定");
        try {

        } finally {
            wLock.unlock();
        }
        return "";
    }

}
