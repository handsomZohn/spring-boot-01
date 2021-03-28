package readandwrite.book.cyc2018.newCharacteristics.eeight.lambdaExample;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;

/**
 * @Description 计算集合元素的最大值、最小值、总和以及平均值 IntStream、LongStream 和 DoubleStream 等流的类中，
 * 有个非常有用的方法叫做 summaryStatistics() 。
 * 可以返回 IntSummaryStatistics、LongSummaryStatistics 或者 DoubleSummaryStatistic s，描述流中元素的各种摘要数据。
 * 在本例中，我们用这个方法来计算列表的最大值和最小值。它也有 getSum() 和 getAverage() 方法来获得列表的所有元素的总和及平均值。
 * @CreateDate 18/07/19 17:37
 * @Author zohn
 * @Version 1.0
 */
public class CalculationMaxMinAvg {
    public static void main(String[] args) {
        //获取数字的个数、最小值、最大值、总和以及平均值
        List<Integer> primes = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29);
        IntSummaryStatistics stats = primes.stream().mapToInt((x) -> x).summaryStatistics();

        System.out.println("Count prime number in List：" + stats.getCount());
        System.out.println("Highest prime number in List : " + stats.getMax());
        System.out.println("Lowest prime number in List : " + stats.getMin());
        System.out.println("Sum of all prime numbers : " + stats.getSum());
        System.out.println("Average of all prime numbers : " + stats.getAverage());

    }
    // Lambda表达式 vs 匿名类
    // 既然lambda表达式即将正式取代Java代码中的匿名内部类，那么有必要对二者做一个比较分析。
    // 一个关键的不同点就是关键字 this。匿名类的 this 关键字指向匿名类，而lambda表达式的 this 关键字指向包围lambda表达式的类。
    // 另一个不同点是二者的编译方式。Java编译器将lambda表达式编译成类的私有方法。
    // 使用了Java 7的 invokedynamic 字节码指令来动态绑定这个方法。

    // 后记：
    //1）lambda表达式仅能放入如下代码：预定义使用了 @Functional 注释的函数式接口，自带一个抽象函数的方法，
    // 或者SAM（Single Abstract Method 单个抽象方法）类型。这些称为lambda表达式的目标类型，可以用作返回类型，
    // 或lambda目标代码的参数。例如，若一个方法接收Runnable、Comparable或者 Callable 接口，都有单个抽象方法，
    // 可以传入lambda表达式。类似的，如果一个方法接受声明于 java.util.function 包内的接口，
    // 例如 Predicate、Function、Consumer 或 Supplier，那么可以向其传lambda表达式。
    //2）lambda表达式内可以使用方法引用，仅当该方法不修改lambda表达式提供的参数。本例中的lambda表达式可以换为方法引用，因为这仅是一个参数相同的简单方法调用。
    //        list.forEach(n -> System.out.println(n));
    //        list.forEach(System.out::println);  // 使用方法引用
    // 然而，若对参数有任何修改，则不能使用方法引用，而需键入完整地lambda表达式，如下所示：
    // list.forEach((String s) -> System.out.println("*" + s + "*"));
    // 事实上，可以省略这里的lambda参数的类型声明，编译器可以从列表的类属性推测出来。
    // 3）lambda内部可以使用静态、非静态和局部变量，这称为lambda内的变量捕获。

    // 4）Lambda表达式在Java中又称为闭包或匿名函数，所以如果有同事把它叫闭包的时候，不用惊讶。

    // 5）Lambda方法在编译器内部被翻译成私有方法，并派发 invokedynamic 字节码指令来进行调用。
    // 可以使用JDK中的 javap 工具来反编译class文件。使用 javap -p 或 javap -c -v 命令来看一看lambda表达式生成的字节码。
    // 大致应该长这样：
    // private static java.lang.Object zlambda$0(java.lang.String);
    // 6）lambda表达式有个限制，那就是只能引用 final 或 final 局部变量，这就是说不能在lambda内部修改定义在域外的变量。
    // List<Integer> primes = Arrays.asList(new Integer[]{2, 3,5,7});
    // int factor = 2;
    // primes.forEach(element -> { factor++; });
    // Compile time error : "local variables referenced from a zlambda expression must be final or effectively final"
    // 另外，只是访问它而不作修改是可以的，如下所示：
    // List<Integer> primes = Arrays.asList(new Integer[]{2, 3,5,7});
    // int factor = 2;
    // primes.forEach(element -> { System.out.println(factor*element); });
    // 输出：
    // 4
    // 6
    // 10
    // 14
    // 因此，它看起来更像不可变闭包，类似于Python。

}
