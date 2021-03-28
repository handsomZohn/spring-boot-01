package readandwrite.thePublic.importNew;


/**
 * @Description 自动装箱自动拆箱
 * @CreateDate 18/10/24 15:48
 * @Author zohn
 * @Version 1.0
 */
public class Zdzxzdcx {
    public static void main(String[] args) {
        zdzx();
        zdcx();
        // xxkzz();
        xxj();
    }

    /**
     * 自动装箱
     */
    public static void zdzx() {
        Integer i = 10;
        System.out.println(i);// 2: invokestatic  #4                  // Method java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        // 根据数值创建对应的Integer对象 这就是自动装箱
    }

    /**
     * 自动拆箱
     */
    public static void zdcx() {
        Integer integer = 10;
        int i = integer;//  7: invokevirtual #7                  // Method java/lang/Integer.intValue:()I
        System.out.println(i);
        // 根据包装器类型将数据转换为基本类型 自动拆箱
    }

    // 原理：
    // 看javap 反编译的字节码指令信息：
    // 自动装箱的时候，Java虚拟机会自动调用Integer的valueOf方法
    // 自动拆箱的时候，Java虚拟机会自动调用Integer的intValue方法

    /**
     * @Description 小心空指针
     * @CreateDate 18/10/24 15:59
     * @Author zohn
     * @Version 1.0
     */
    public static void xxkzz() {
        Object object = null;
        int i = (Integer)object;
        System.out.println(i);
    }

    public static void xxj(){
        Integer integer01 = 100;
        Integer integer02 = 100;
        Integer integer03 = 200;
        Integer integer04 = 200;

        System.out.println(integer01 == integer02);// true
        System.out.println(integer03 == integer04);// false

        Double double01 = 100.0;
        Double double02 = 100.0;
        Double double03 = 100.0;
        Double double04 = 100.0;


        System.out.println(double01 == double02);// false
        System.out.println(double03 == double04);// false

        // 原因分析:Byte, Short, Integer, Long, Char这几个装箱类的valueOf()方法是以128为分界做了缓存
        // 假如是128以下（不包含128）-128以上（包含-128）会取缓存里面的值；
        // 而Float，Double则不会，因为Byte，Short，Integer，Long，Char的某个范围内的整数个数是有限的，Float和Double却不是

        // 基本知识
        // 缓存的概念，缓存对于提高程序运行效率、节省内存空间有很大帮助
    }
}
