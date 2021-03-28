package readandwrite.javase.passbyvalueorreference;

/**
 *@Description 基础类型参数传递
 *@CreateDate 2020\4\8 0008 15:39
 *@Author zz
 *@Version 1.0
 */

public class BasicType {
    public static void main(String[] args) {
        int a = 25;
        float w = 77.5f;

        valuePassTest(a, w);

        // 值传递传递的是真实内容的一个副本，对副本的操作不影响原内容，也就是形参怎么变化，不会影响实参对应的内容。
        System.out.println("======^_^======variable a value is : " + a + ", " + " current method and class name is : BasicType.main()");

        System.out.println("======^_^======variable w value is : " + w + ", " + " current method and class name is : BasicType.main()");
    }


    public static void valuePassTest(int age, float weight){
        System.out.println("传入的age：" + age);
        System.out.println("传入的weight：" + weight);

        age = 33;
        weight = 87.5f;

        System.out.println("方法内重新赋值后的age：" + age);
        System.out.println("方法内重新赋值后的的weight：" + weight);
    }
}
