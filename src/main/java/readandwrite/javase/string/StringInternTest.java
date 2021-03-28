package readandwrite.javase.string;


import org.junit.jupiter.api.Test;

/**
 *@Description Intern 示例代码 
 *@CreateDate 2020\5\18 0018 15:30
 *@Author zz
 *@Version 1.0
 */
public class StringInternTest {

    /**
     * 字符串常量池（String Pool）保存着所有字符串字面量（literal strings），这些字面量在编译时期就确定。
     * 不仅如此，还可以使用 String 的 intern() 方法在运行过程将字符串添加到 String Pool 中。
     *
     * 当一个字符串调用 intern() 方法时，如果 String Pool 中已经存在一个字符串和该字符串值相等（使用 equals() 方法进行确定），
     * 那么就会返回 String Pool 中字符串的引用；否则，就会在 String Pool 中添加一个新的字符串，并返回这个新字符串的引用。
     */
    @Test
    public void testStringIntern () {
        
        // 调用intern的时候返回引用
        String str01 = new String("123");
        // 
        String str02 = new String("123");

        String intern = str01.intern();

        String intern1 = str02.intern();


        // false
        boolean b = str01 == str02;

        System.out.println("======^_^======variable b value is : " + b + ", " + " current method and class name is : StringInternTest.testStringIntern()");

        // true
        boolean b1 = intern == intern1;
        
        System.out.println("======^_^======variable b1 value is : " + b1 + ", " + " current method and class name is : StringInternTest.testStringIntern()");
    }
}
