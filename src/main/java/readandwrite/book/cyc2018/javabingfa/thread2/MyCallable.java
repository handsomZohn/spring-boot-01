package readandwrite.book.cyc2018.javabingfa.thread2;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 *@Description  实现Callable 与Runnable相比 Callable有返回值，返回值通过FutureTask实现           JDK1.5之后提供 50
 * 综上例子可以看到： Callable 和 Future接口的区别
 *   （1）Callable规定的方法是call()，而Runnable规定的方法是run().
 *   （2）Callable的任务执行后可返回值，而Runnable的任务是不能返回值的。
 *   （3）call()方法可抛出异常，而run()方法是不能抛出异常的。
 *   （4）运行Callable任务可拿到一个Future对象， Future表示异步计算的结果。
 *   它提供了检查计算是否完成的方法，以等待计算的完成，并检索计算的结果。
 *   通过Future对象可了解任务执行情况，可取消任务的执行，还可获取任务执行的结果。
 *   Callable是类似于Runnable的接口，实现Callable接口的类和实现Runnable的类都是可被其它线程执行的任务。
 *@CreateDate   18/07/23 16:53
 *@Author        zohn
 *@Version       1.0
 *
 */
public class MyCallable implements Callable{
    @Override
    public Integer call() throws Exception {
        return 123;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException{
        MyCallable myCallable = new MyCallable();
        FutureTask futureTask = new FutureTask<>(myCallable);
        Thread thread = new Thread(futureTask);
        thread.start();
        System.out.println(futureTask.get());
    }
}
