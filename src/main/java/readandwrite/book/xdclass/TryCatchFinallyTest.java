package readandwrite.book.xdclass;

/**
 *@Description  TryCatchFinally 测试
 *@CreateDate 2020\3\13 0013 10:35
 *@Author zohn
 *@Version 1.0
 */
public class TryCatchFinallyTest {


    public static void main(String[] args) {
        int i = test1();
        int i1 = test2();
        System.out.println("======^_^======变量i值为: " + i + ", 变量i1值为: " +i1+ ", 当前类以及方法名字是: TryCatchFinallyTest.main()");
    }

    public static int test1() {
        int a = 1;
        try {
            System.out.println(a / 0);
            a = 2;
        } catch (ArithmeticException e) {
            a = 3;
            return a;
        } finally {
            a = 4;
        }
        return a;
    }

    public static int test2() {
        int a = 1;
        try {
            System.out.println(a / 0);
            a = 2;
        } catch (ArithmeticException e) {
            a = 3;
            return a;
        } finally {
            a = 4;
            return a;// 直接执行这里了；finally中的return语句一定会被执行的
        }
    }
}
