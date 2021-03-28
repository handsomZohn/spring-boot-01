package readandwrite.javaHightRanking.jvm.reference;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

/**
 * 虚引用示例
 * @author Administrator
 */
public class PhantomReferenceTest {

    public static void main(String[] args) throws InterruptedException {

        PrintlnMemory.printlnMemory("1.原可用内存和总内存");
        byte[] object = new byte[10*PrintlnMemory.M];
        PrintlnMemory.printlnMemory("2.实例化10M的数组后");

        //建立虚引用
        ReferenceQueue<Object> referenceQueue = new ReferenceQueue<Object>();
        PhantomReference<Object> phantomReference = new PhantomReference<Object>(object,referenceQueue);

        PrintlnMemory.printlnMemory("3.建立虚引用后");
        System.out.println("phantomReference : "+phantomReference);
        System.out.println("phantomReference.get() : "+phantomReference.get());
        System.out.println("referenceQueue.poll() : "+referenceQueue.poll());

        //断开byte[10*PrintlnMemory.M]的强引用
        object = null;
        PrintlnMemory.printlnMemory("4.执行object = null;强引用断开后");

        System.gc();
        PrintlnMemory.printlnMemory("5.GC后");
        System.out.println("phantomReference : "+phantomReference);
        System.out.println("phantomReference.get() : "+phantomReference.get());
        System.out.println("referenceQueue.poll() : "+referenceQueue.poll());

        //断开虚引用
        phantomReference = null;
        System.gc();
        PrintlnMemory.printlnMemory("6.断开虚引用后GC");
        System.out.println("phantomReference : "+phantomReference);
        System.out.println("referenceQueue.poll() : "+referenceQueue.poll());
    }
}
