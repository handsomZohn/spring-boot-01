package readandwrite.book.xdclass;

/**
 *@Description i++ 或者++i 的返回结果
 *@CreateDate 2020\3\13 0013 10:28
 *@Author zohn
 *@Version 1.0
 */
public class IPlusPlusTest {
    public static void main(String[] args) {
        int i = returnTest();
        int i02 = returnTest02();

        System.out.println("======^_^======变量i值为: " + i + ", 变量i02值为: " +i02+ ", 当前类以及方法名字是: IPlusPlusTest.main()");
    }

    static int returnTest(){
        int i = 10;
        return i ++ ;
    }

    static int returnTest02(){
        int i = 10;
        return ++ i ;
    }
}
