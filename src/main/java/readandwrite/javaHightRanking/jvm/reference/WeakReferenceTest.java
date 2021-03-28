package readandwrite.javaHightRanking.jvm.reference;

import java.lang.ref.WeakReference;

/**
 * 弱引用示例
 * @Author
 */
public class WeakReferenceTest {

    public static void main(String[] args){
        PrintlnMemory.printlnMemory("1.原可用内存和总内存");

        //创建弱引用
        WeakReference<Object> weakRerference = new WeakReference<Object>(new byte[10*PrintlnMemory.M]);
        PrintlnMemory.printlnMemory("2.实例化10M的数组,并建立弱引用");
        System.out.println("weakRerference.get() : "+weakRerference.get());

        System.gc();
        PrintlnMemory.printlnMemory("3.GC后");
        System.out.println("weakRerference.get() : "+weakRerference.get());
    }
}
