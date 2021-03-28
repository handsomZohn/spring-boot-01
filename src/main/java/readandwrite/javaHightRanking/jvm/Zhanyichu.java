package readandwrite.javaHightRanking.jvm;

/**
 *@Description  栈内存溢出  错误的递归调用
 *@CreateDate   18/07/31 9:05
 *@Author        zohn
 *@Version       1.0
 *
 */
public class Zhanyichu {
    public static void main(String[] args) {
        new Zhanyichu().test();
    }

    public void test () {
        test(); // java.lang.StackOverflowError
    }
}
