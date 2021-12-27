package readandwrite.javase.programmer.trycatchfinally;

/**
 * @ClassName TryCatchFinallyTest
 * @Description try catch finally 执行逻辑
 * 在执⾏行行try、catch中的return之前⼀一定会执⾏行行finally中的代码（如果finally存在），如
 * 果finally中有return语句句，就会直接执⾏行行finally中的return⽅方法，所以finally中的return语句句
 * ⼀一定会被执⾏行行的
 *
 *  执⾏行行流程：finally执⾏行行前的代码⾥里里⾯面有包含return，则会先确定return返回值，然后再执
 * ⾏行行finally的代码，最后再执⾏行行return
 * @Date 2021/12/19 10:18
 * @Version 1.0
 **/
public class TryCatchFinallyTest {


    public static void main(String[] args) {
        int test = test01();
        System.out.println(test);


        int i = test02();
        System.out.println(i);
    }


    /**
     *
     * @return
     */
    public static int test01() {
        int a = 1;
        try {
            System.out.println(a / 0);
            a = 2;
        } catch (ArithmeticException e) {
            a = 3;
            // 这一步已确定return的返回值是3
            return a;
        } finally {
            // 这一步骤改了a的值，也是没有用处的，返回的也不是4
            a = 4;
        }
        return a;
    }

    public static int test02() {
        int a = 1;
        try {
            System.out.println(a / 0);
            a = 2;
        } catch (ArithmeticException e) {
            a = 3;
            return a;
        } finally {
            // 这一步骤改了a的值，下面有返回，返回的就是4
            a = 4;
            return a;
        }
    }
}
