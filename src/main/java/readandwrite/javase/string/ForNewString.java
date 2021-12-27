package readandwrite.javase.string;

/**
 * @ClassName For
 * @Description TODO
 * @Date 2021/12/19 17:39
 * @Version 1.0
 **/
public class ForNewString {


    public static void main(String[] args) {
        // test01();
        test02();
    }


    /**
     * ⽐比较引⽤用的内存地址是否⼀一样
     * 第⼀一个是false： new 创建新的对象会开辟新的空间，所以地址不不⼀一样
     * 第⼆二个是true：都是从常量量池⾥里里⾯面获取，"xdclass.net" 存在于常量量池中
     */
    public static void test01() {
        String str01 = new String("xdclass.net");
        String str02 = "xdclass.net";
        String str03 = "xdclass.net";

        System.out.println(str01 == str02);


        System.out.println(str02 == str03);
    }


    /**
     * 第⼀一条语句句打印的结果为false， s2 = s1 + ".net",   //变量量+常量量=堆
     * 构建了了⼀一个新的string对象，并将对象引⽤用赋予s2变量量，常量量池中的地址不不⼀一样，但是值⼀一样。
     *
     * 第⼆二条语句句打印的结果为true，javac编译可以对【字符串串常量量】直接相加的表达式进⾏行行优化，不不⽤用等到
     * 运⾏行行期再去进⾏行行加法运算处理理，⽽而是直接将其编译成⼀一个这些常量量相连的结果.
     *
     * 如果需要第⼀一个输出为true，只需要把变量量改为常量量即可 fianl String s1 = "xdclass";
     * 不不管是new String("XXX")和直接常量量赋值, 都会在字符串串常量量池创建.只是new String("XXX")⽅方
     * 式会在堆中创建⼀一个对象去指向常量量池的对象, 普通的常量量赋值是直接赋值给变量量
     */
    public static void test02(){
        // String s1 = "xdclass";
        final String s1 = "xdclass";
        // 变量 + 常量 = 来自堆
        String s2 = s1 + ".net";
        // 常量 + 常量 = 常量池
        String s3 = "xdclass" + ".net";

        System.out.println(s2 == "xdclass.net");
        System.out.println(s3 == "xdclass.net");
    }
}
