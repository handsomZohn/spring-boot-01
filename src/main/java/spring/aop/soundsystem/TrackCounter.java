package spring.aop.soundsystem;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import java.util.HashMap;
import java.util.Map;

/**
 *@Description 处理切面中的参数
 *@CreateDate 2021/3/28 15:11
 *@Author zz
 *@Version 1.0
 */
@Aspect
public class TrackCounter {
    private Map<Integer, Integer> trackCounts = new HashMap<>();

    /**
     * 切点定义中的参数与切点方法中的参数名称一样，就能完成从命名切点到通知方法的参数转移
     * @param trackNumber
     */
    @Pointcut("execution(* spring.aop.soundsystem.CompactDis.playTrack(int)) && args(trackNumber)")
    public void trackPlayed(int trackNumber) {

    }

    @Before("trackPlayed(trackNumber)")
    public void countTrack(int trackNumber){
        int currentCount = getPlayCount(trackNumber);
        trackCounts.put(trackNumber, currentCount + 1);
    }

    public int getPlayCount(int trackNumber){
        return trackCounts.containsKey(trackNumber) ? trackCounts.get(trackNumber) : 0;
    }
}
