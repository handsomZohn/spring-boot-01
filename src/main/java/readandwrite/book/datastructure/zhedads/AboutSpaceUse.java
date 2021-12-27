package readandwrite.book.datastructure.zhedads;

/**
 * @ClassName AboutSpaceUse
 * @Description 关于空间的使用   传入正整数N，顺序从1到N的全部正整数
 * @Date 2021/12/20 23:40
 * @Version 1.0
 **/
public class AboutSpaceUse {

    public static void main(String[] args) {
        int n = 100;
        test01(n);
        // Exception in thread "main" java.lang.StackOverflowError
        test02(n);
    }


    public static void test01(int n){

        for (int i = 1; i <= n; i++) {
            System.out.println(i);
        }

    }

    public static void test02(int n){
        if (n>0){
            test02(n-1);
            System.out.println(n);

        }
    }
}
