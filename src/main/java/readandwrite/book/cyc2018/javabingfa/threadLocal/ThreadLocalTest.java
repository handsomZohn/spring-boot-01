package readandwrite.book.cyc2018.javabingfa.threadLocal;

/**
 *@Description  通过threadlcoal能达到在每个线程中创建变量副本的效果 :
 * 首先，在每个线程Thread内部有一个ThreadLocal.ThreadLocalMap类型的成员变量threadLocals，这个threadLocals就是用来存储实际的变量
 * 副本的，key为当前ThreadLocal变量，value为变量副本（即T类型的变量）
 * 初始时，在Thread里面，threadLocals为空，当通过ThreadLocal变量调用get()方法或者set（）方法，就会对Thread类中的threadLocals进行初
 * 始化，并且以当前ThreadLocal变量为key，以ThreadLocal要保存的副本变量为value，存到threadLocals。
 * 然后再线程里面，如果要使用副本变量，就可以通过get方法在threadLocals里面查找。
 *@CreateDate   18/08/09 14:40
 *@Author        zohn
 *@Version       1.0
 *
 */
public class ThreadLocalTest {
   ThreadLocal<Long> longThreadLocal = new ThreadLocal<>();
   ThreadLocal<String> stringThreadLocal = new ThreadLocal<>();

   public void set(){
       longThreadLocal.set(Thread.currentThread().getId());
       stringThreadLocal.set(Thread.currentThread().getName());
   }

   public long getLong(){
       return longThreadLocal.get();
   }

   public String getString(){
       return stringThreadLocal.get();
   }

    public static void main(String[] args) throws Exception {
        final ThreadLocalTest threadLocalTest = new ThreadLocalTest();
         threadLocalTest.set(); // 不重写initialValue也不set() 在调用的是就会异常
        System.out.println(threadLocalTest.getLong());
        System.out.println(threadLocalTest.getString());

        Thread thread = new Thread(() ->{
            threadLocalTest.set();
            System.out.println(threadLocalTest.getLong());
            System.out.println(threadLocalTest.getString());
        });

        thread.start();
        thread.join();

        System.out.println(threadLocalTest.getLong());
        System.out.println(threadLocalTest.getString());
    }
}
/**
 * 总结：
 * 1.实际的通过ThreadLocal创建的副本是存储在每个线程自己的threadLocals中的；
 * 2.为何threadLocals的类型ThreadLocalMap的键值为ThreadLocal对象，因为每个线程中可有多个threadLocal变量，就像上面的代码中的
 * longLocal和StringLocal
 * 3.在get之前必须set否则会报空指针异常
 * 如果在get之前不需要调用set就能正常访问 必须重写initialValue（）方法
 */
