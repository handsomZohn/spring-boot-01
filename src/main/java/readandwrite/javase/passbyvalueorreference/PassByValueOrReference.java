package readandwrite.javase.passbyvalueorreference;

/**
 * @Description 值传递还是引用传递
 * 参考文章：：https://juejin.im/post/5bce68226fb9a05ce46a0476
 * @CreateDate 2020\4\8 0008 14:43
 * @Author zz
 * @Version 1.0
 */
public class PassByValueOrReference {

    public static void main(String[] args) {
        Student student = new Student() {{
            setId(100);
            setName("test001");
        }};

        String nameBeforeMain = student.getName();
        System.out.println("======^_^======variable nameBeforeMain value is : " + nameBeforeMain + ", " + " current method and class name is : PassByValueOrReference.test001()");

        test002(student);


        String nameAfterMain = student.getName();
        System.out.println("======^_^======variable nameAfterMain value is : " + nameAfterMain + ", " + " current method and class name is : PassByValueOrReference.test001()");
    }

    /*
    public void test001 () {
        Student student = new Student() {{
            setId(100);
            setName("test001");
        }};

        test002(student);
    }*/

    /**
     * @Description 引用传递：“引用”也就是指向真实内容的地址值，在方法调用时，实参的地址通过方法调用传递给相应的形参，在方法体的内部
     * 形参和实参指向同一块内存地址，对形参的操作，会影响到实参的内容
     * @Author zz
     * @Date 2020\4\8 0008 15:11
     * @Param [student]
     * @Return void
     */
    public static void test002(Student student) {


        String nameBeforeTest002 = student.getName();

        System.out.println("======^_^======variable nameBeforeTest002 value is : " + nameBeforeTest002 + ", " + " current method and class name is : PassByValueOrReference.test002()");

        // 输出结果为：001 001 002 002
        // 多加下面一行魔力的代码 结果就变成了了 001 001 002 001
        // student = new Student();
        student.setName("test002");


        String nameAfterTest002 = student.getName();

        System.out.println("======^_^======variable nameAfterTest002 value is : " + nameAfterTest002 + ", " + " current method and class name is : PassByValueOrReference.test002()");
    }
}
