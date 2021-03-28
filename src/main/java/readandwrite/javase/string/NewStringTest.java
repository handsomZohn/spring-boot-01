package readandwrite.javase.string;


/**
 *@Description 涉及到的命令：：：javap -verbose NewStringTest.class
 *@CreateDate 2020\5\18 0018 15:29
 *@Author zz
 *@Version 1.0
 */

public class NewStringTest {
    public static void main(String[] args) {
        String string = new String("123");
        System.out.println("======^_^======变量string值为: " + string + ", " + "当前类以及方法名字是: NewStringTest.main()");
    }

    // Constant pool:

    // #2 = Class              #31            // java/lang/String
    // #3 = String             #32            // 123  //----------    #32存储字符串字面量abc   #3是String Pool的字符串对象    它指向#32这个字符串字面量

    // Code:
    // stack=3, locals=2, args_size=1
    // 0: new           #2                  // class java/lang/String 使用new#2在堆中创建字符串对象
    // 3: dup
    // 4: ldc           #3                  // String 123 并且使用lcd#3将String Pool中的字符串对象作为String构造函数的参数

    // public String(String original) {
    //     this.value = original.value;
    //     this.hash = original.hash;
    // }
    // 以上是String构造函数的源码，可以看到在将一个字符串作为另一个字符串对象的构造函数参数时，并不会完全复制value数组的内容，而是都会指向同一个value数组；；
}
