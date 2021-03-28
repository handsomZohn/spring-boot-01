package readandwrite.javaHightRanking.jvm.reference;

/**
 * 打印内存信息
 * @author Administrator
 */
public class PrintlnMemory {

    public static int M = 1024*1024;

    /**
     * 打印内存信息
     * @param tag
     */
    public static void printlnMemory(String tag){
        Runtime runtime = Runtime.getRuntime();
        int M = PrintlnMemory.M;
        System.out.println("\n"+tag+":");
        System.out.println(runtime.freeMemory()/M+"M(free)/" + runtime.totalMemory()/M+"M(total)");
    }
}
