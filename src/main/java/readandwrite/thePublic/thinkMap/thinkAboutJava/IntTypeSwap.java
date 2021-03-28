package readandwrite.thePublic.thinkMap.thinkAboutJava;

// 测试main方法
public class IntTypeSwap {
    public static void main(String[] args) {

        // CODE_1
        IntType type1 = new IntType();
        type1.setValue(1);

        // CODE_2
        IntType type2 = new IntType();
        type2.setValue(2);

        // 交换
        swap1(type1, type2);
        System.out.printf("type1.value = %s, type2.value = %s", type1.getValue(), type2.getValue());

        System.out.println();

        swap2(type1, type2);
        System.out.printf("type1.value = %s, type2.value = %s", type1.getValue(), type2.getValue());

    }

    // 对象参数传递采用的是引用传递,type1和type2传递过来的是指向对象的引用，在方法内部直接操作形参，交换了形参的内容，这样形参
    // 改变，没有对实参产生任何影响，也没有改变对象实际的值，所以结果是无法交换的。
    public static void swap1 (IntType type1, IntType type2) {
        IntType type = type1;
        type1 = type2;
        type2 = type;
        System.out.println("只是形参的转换==================");
        System.out.println("======^_^======变量type1.getValue()值为: " + type1.getValue() + ", 变量type2.getValue()值为: " +type2.getValue()+ ", 当前类以及方法名字是: IntTypeSwap.swap1()");
    }

    // 对象引用作为形参传递过来，没有对形参做任何改变，而是直接操作了形参锁指向的对象实际地址，那这样，无论是实参还是其他地方，
    // 只要是指向该对象的所有的引用地址对应的值都会改变。
    public static void swap2 (IntType type1, IntType type2) {
        int temp = type1.getValue();
        type1.setValue(type2.getValue());
        type2.setValue(temp);
    }
}
