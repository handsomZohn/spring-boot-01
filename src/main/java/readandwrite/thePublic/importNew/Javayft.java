package readandwrite.thePublic.importNew;





import javax.validation.constraints.NotNull;
import java.util.ArrayList;

/**
 * @Description java语法糖以及Foreach循环的原理
 * @CreateDate 18/10/24 14:23
 * @Author zohn
 * @Version 1.0
 */

public class Javayft {


    public static void main(String[] args) {
        // kbccs(1, 2, "3", "222", "333", "120", "110");
        feachyl();
    }


    //java 语法糖--可变长参数
    public static void kbccs(int a, int b, @NotNull String... args) {
        System.out.println("---------zohn-----------a值=" + a + ", b值=" + b + ", args值=" + args + ", 当前类=Javayft.kbccs()");
        // ---------zohn-----------a值=1, b值=2, args值=[Ljava.lang.String;@6d6f6e28, 当前类=Javayft.kbccs()
        // 可以看到打印的内存地址前面有一个[
        // 可以说明：可变参数，是利用数组实现的；
        for (String arg : args) {// 说明可以利用遍历数组的方式去遍历可变参数
            System.out.print(arg + " ");
        }

        // !! 可变参数必须作为参数列表的最后一个参数，而且一个参数列表仅能有一个可变参数
    }

    // foreach 循环的原理
    public static void feachyl() {
        ArrayList<String> strings = new ArrayList<String>() {{
            add("111");
            add("111");
            add("111");
            add("111");
        }};

        for(String str: strings){
            System.out.print(str + " ") ;
        }
    }
    // javap -verbose Javayft.class
    //  9: invokevirtual #19                 // Method java/util/ArrayList.iterator:()Ljava/util/Iterator;
    // 23: invokeinterface #21,  1           // InterfaceMethod java/util/Iterator.next:()Ljava/lang/Object;
    // 可以看到Iterator：在编译的时候编译器会自动将对for这个关键字的使用转化为对目标的迭代器的使用；
    // 进而再得出两个结论：
    // 1、ArrayList之所以能使用foreach循环遍历，是因为ArrayList所有的List都是Collection的子接口，
    // 而Collection是Iterable的子接口，ArrayList的父类AbstractList正确地实现了Iterable接口的iterator方法
    // 2、任何一个集合，无论是JDK提供的还是自己写的，只要想使用foreach循环遍历，就必须正确地实现Iterable接口

    // 数组可以用foreach遍历的原因
    public static void szforeachyy() {
        int[] intArr = {1, 3, 5, 7, 9};
        for (int i : intArr) {
            System.out.print(i + " ");
        }
    }
    // 反编译了一下 也没看懂什么意思

    // Java将对于数组的foreach循环转换为  对于这个数组每一个元素的循环引用


}



