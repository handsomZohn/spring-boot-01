package readandwrite.javaHightRanking.thread;

/**
 * @Description: 多线程的线程数根据什么确定：：
 * @Author: zohn
 * @CreateDate: 2019/2/5 9:23
 * @UpdateUser: zohn
 * @UpdateDate: 2019/2/5 9:23
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class MaxThread {

    public static void main(String[] args) {
        int maxThread = Runtime.getRuntime().availableProcessors() * 25;
        System.out.println("maxThread:" + maxThread);

        // 最大线程数是CPU的核数*25
        // 用java程序获取cpu的核数：Runtime.getRuntime.availableProcessors();
    }
}
