package readandwrite.javase.dataType;

/**
 *@Description short数据类型
 *@CreateDate 2020\4\8 0008 14:12
 *@Author zz
 *@Version 1.0
 */
public class AboutShort {
    public static void main(String[] args) {
        short s1 = 10;
        // 不能正确编译 不能把int赋值为short
        // s1 = s1 + 1;
        // 下面的则可以
        s1 += 1;
        System.out.println("======^_^======variable s1 value is : " + s1 + ", " + " current method and class name is : AboutShort.main()");
    }
}
