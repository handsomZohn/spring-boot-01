package readandwrite.javaHightRanking.jvm.reference;

import java.lang.ref.SoftReference;

/**
 * 软引用示例
 * @author Administrator
 */
public class SoftReferenceTest {

    public static void main(String[] args){
        PrintlnMemory.printlnMemory("1.原可用内存和总内存");

        //建立软引用
        SoftReference<Object> softRerference = new SoftReference<Object>(new byte[10*PrintlnMemory.M]);
        PrintlnMemory.printlnMemory("2.实例化10M的数组,并建立软引用");
        System.out.println("softRerference.get() : "+softRerference.get());

        System.gc();
        PrintlnMemory.printlnMemory("3.内存可用容量充足，GC后");
        System.out.println("softRerference.get() : "+softRerference.get());

        //实例化一个4M的数组,使内存不够用,并建立软引用
        //free=10M=4M+10M-4M,证明内存可用量不足时，GC后byte[10*m]被回收
        SoftReference<Object> softRerference2 = new SoftReference<Object>(new byte[4*PrintlnMemory.M]);
        PrintlnMemory.printlnMemory("4.实例化一个4M的数组后");
        System.out.println("softRerference.get() : "+softRerference.get());
        System.out.println("softRerference2.get() : "+softRerference2.get());
    }
}
