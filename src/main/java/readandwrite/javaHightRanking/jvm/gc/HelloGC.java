package readandwrite.javaHightRanking.jvm.gc;

import java.util.LinkedList;
import java.util.List;

/**
 * @Description
 * @Author zz
 * @Date 2020\4\21 0021 15:07
 * @Param 
 * @Return 
 */
public class HelloGC {
    public static void main(String[] args) {
        System.out.println("HelloGC!");
        List list = new LinkedList();
        for(;;) {
            byte[] b = new byte[1024*1024];
            list.add(b);
        }
    }
}
