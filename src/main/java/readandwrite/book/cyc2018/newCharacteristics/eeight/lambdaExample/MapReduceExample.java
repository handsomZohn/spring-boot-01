package readandwrite.book.cyc2018.newCharacteristics.eeight.lambdaExample;

import java.util.Arrays;
import java.util.List;

/**
 *@Description  Java 8中使用lambda表达式的Map和Reduce示例
 *@CreateDate   18/07/19 14:53
 *@Author        zohn
 *@Version       1.0
 *
 */
public class MapReduceExample {
    public static void main(String[] args) {
//        jiaShui();
        jiaShuiQiuhe();
    }

    private static void jiaShui() {
        List<Integer> costBeforeTax = Arrays.asList(100, 200, 300, 400, 500);

        // 不使用lambda为每个订单加上12%的税
        for (Integer cost : costBeforeTax) {
            double price = .12 * cost + cost;
            System.out.println(price);
        }

        // 使用lambda为每个订单加上12%的税
        costBeforeTax.stream().map((cost) -> cost + .12 * cost).forEach(System.out :: println);
//        for (Integer cost: costBeforeTax) {
//            if (cost > 400) {
//                //System.out :: println;
//                System.out.println(cost);
//            }
//        }


//        costBeforeTax.stream().map((cost) ->{
//            if (cost > 500) {
//                cost + .12 * cost).forEach(System.out :: println)
//            }
//        }
        // 本例介绍最广为人知的函数式编程概念map。它允许你将对象进行转换。
        // 例如在本例中，我们将 costBeforeTax 列表的每个元素转换成为税后的值。
        // 我们将 x -> x*x lambda表达式传到 map() 方法，后者将其应用到流中的每一个元素。
        // 然后用 forEach() 将列表元素打印出来。使用流API的收集器类，可以得到所有含税的开销。
        // 有 toList() 这样的方法将 map 或任何其他操作的结果合并起来。由于收集器在流上做终端操作，因此之后便不能重用流了。
        // 你甚至可以用流API的 reduce() 方法将所有数字合成一个，下一个例子将会讲到。
    }

    private static void jiaShuiQiuhe(){
        List<Integer> costBeforeTax = Arrays.asList(100, 200, 300, 400, 500);
        double total = 0;
        // 1.8之前
        for (Integer cost : costBeforeTax) {
            double price = .12 * cost + cost;
            total = total + price;
        }
        System.out.println("total:" + total);

        // 1.8之后
        double bill = costBeforeTax.stream().map((cost) -> cost + .12 * cost).reduce((sum, cost) -> sum + cost).get();

        System.out.println("total:" + bill);
    }
}
