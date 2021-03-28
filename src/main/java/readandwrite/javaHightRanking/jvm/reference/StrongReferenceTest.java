package readandwrite.javaHightRanking.jvm.reference;

/**
 * 强引用示例
 * @Author
 */
public class StrongReferenceTest {


    public static void main(String[] args){
        PrintlnMemory.printlnMemory("1.原可用内存和总内存");

        //实例化10M的数组并与strongReference建立强引用
        byte[] strongReference = new byte[10*PrintlnMemory.M];
        PrintlnMemory.printlnMemory("2.实例化10M的数组,并建立强引用");
        System.out.println("strongReference : "+strongReference);

        System.gc();
        PrintlnMemory.printlnMemory("3.GC后");
        System.out.println("strongReference : "+strongReference);

        //strongReference = null;后,强引用断开了
        strongReference = null;
        PrintlnMemory.printlnMemory("4.强引用断开后");
        System.out.println("strongReference : "+strongReference);

        System.gc();
        PrintlnMemory.printlnMemory("5.GC后");
        System.out.println("strongReference : "+strongReference);
    }
}
