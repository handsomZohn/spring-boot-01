package readandwrite.aboutmain;

import lombok.extern.slf4j.Slf4j;

/**
 * @ClassName Main
 * @Description main方法可以被重载吗
 * @Date 2021/12/27 14:18
 * @Version 1.0
 **/
@Slf4j
public class Main {
    public static void main(String[] args) {
        // main("this is overload main method");
        log.info("main方法执行:({})",times);
        if (times <= 0) {
            System.exit(0);
        }
        main2(args);
    }

    /**
     *
     * @param str
     */
    public static void main(String str) {
        // System.out.println(str);
        log.info(str);
    }

    private static int times = 3;

    public static void main2(String[] args) {
        times--;
        main(args);

    }
}
