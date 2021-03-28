package readandwrite.book.cyc2018.newCharacteristics.eeight.stream;




import java.util.ArrayList;
import java.util.Optional;

/**
 * @Description
 * @CreateDate 18/09/17 13:30
 * @Author zohn
 * @Version 1.0
 */
public class ReduceDemo {
    public static void main(String[] args) {
        ArrayList<Integer> myList = new ArrayList<>();
        myList.add(7);
        myList.add(18);
        myList.add(10);
        myList.add(24);
        myList.add(5);
        // myList.add(0);// 没添加0的时候运行了89毫秒  每次运行耗费时间基本都不一致

        // 使用lambda表达式来计算两个值得乘积
        // 两个值分别代表累积结果中的当前值和流中的下一个元素
        Optional<Integer> reduce = myList.stream().reduce((a, b) -> (a * b));

        if (reduce.isPresent()) {
            System.out.println("product as optional:" + reduce.get());
            // 在第二个版本中，显示指定了单位值，对于乘法而言就是1

            int product = myList.stream().reduce(1, (a, b) -> a * b);// 1 所有元素全部*起来
            System.out.println("product as int:" + product);

            // 获取偶数的乘积
            int evenProduct = myList.stream().reduce(1, (a, b) -> {
                if (b % 2 == 0) {
                    return a * b;
                } else {
                    return a;
                }
            });
            System.out.println("所有偶数的乘积：" + evenProduct);
        }
    }

    //
    // @Test
    public void test() {
        ReduceDemo.main(new String[]{});
    }
}
