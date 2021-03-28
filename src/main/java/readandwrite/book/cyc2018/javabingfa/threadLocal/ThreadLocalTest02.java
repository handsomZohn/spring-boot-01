package readandwrite.book.cyc2018.javabingfa.threadLocal;
/**
 *@Description  重写initialValue
 *@CreateDate   18/08/09 15:24
 *@Author        zohn
 *@Version       1.0
 *
 */
public class ThreadLocalTest02 {


//    private Object Supplier;
//    ThreadLocal<Long> local = ThreadLocal.withInitial(Supplier<? extends S> supplier);

    ThreadLocal<Long> threadLocalLong = new ThreadLocal<Long>(){
        @Override
        protected Long initialValue() {
            return Thread.currentThread().getId();
        }
    };

    ThreadLocal<String> threadLocalString = new ThreadLocal<String>(){
        @Override
        protected String initialValue() {
            return Thread.currentThread().getName();
        }
    };

    public void set(){
        threadLocalLong.set(Thread.currentThread().getId());
        threadLocalString.set(Thread.currentThread().getName());
    }

    public long getLong(){
        return threadLocalLong.get();
    }

    public String getString(){
        return threadLocalString.get();
    }

    public static void main(String[] args) throws Exception {
        final ThreadLocalTest02 threadLocalTest2 = new ThreadLocalTest02();
        // threadLocalTest.set(); // 不重写initialValue也不set() 在调用的是就会异常
        System.out.println(threadLocalTest2.getLong());
        System.out.println(threadLocalTest2.getString());

        Thread thread = new Thread(() ->{
            threadLocalTest2.set();
            System.out.println(threadLocalTest2.getLong());
            System.out.println(threadLocalTest2.getString());
        });

        thread.start();
        thread.join();

        System.out.println(threadLocalTest2.getLong());
        System.out.println(threadLocalTest2.getString());
    }

    /**
     * 适用场景：
     * 数据库连接
     * Session管理
     */
}
