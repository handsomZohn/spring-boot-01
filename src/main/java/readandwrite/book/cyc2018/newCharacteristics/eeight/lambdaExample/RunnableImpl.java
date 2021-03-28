package readandwrite.book.cyc2018.newCharacteristics.eeight.lambdaExample;

/**
 *@Description  用lambda表达式实现Runnable
 *@CreateDate   18/07/19 10:25
 *@Author        zohn
 *@Version       1.0
 *
 */
public class RunnableImpl {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Before Java8 is too large~~");
            }
        }).start();

        new Thread(() -> System.out.println("After Java8 is so cool")).start();
    }
    // 例子向我们展示了Java 8 lambda表达式的语法。你可以使用lambda写出如下代码：
    // (params) -> Expression
    // (params) -> statement
    // (params) -> {statements}
    // 例如，如果你的方法不对参数进行修改、重写，只是在控制台打印点东西的话，那么可以这样写：
    // () -> System.out.println("After Java8 is so cool")
    // 如果你的方法接收两个参数，那么可以写成如下这样：
    // (int even, int odd) -> even + odd;
    // 通常都会把lambda表达式内部变量的名字起得短一些。这样能使代码更简短，放在同一行。所以，在上述代码中，变量名选用a、b或者x、y会比
    // even、odd要好
}
