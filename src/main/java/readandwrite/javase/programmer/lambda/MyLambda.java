package readandwrite.javase.programmer.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class MyLambda {
    public static void main(String[] args) {
        MyLambdaInterface aBlockOfCode = (s) -> System.out.println(s);

        filterTest();

        countTest();

    }


    /**
     * @Description 过滤
     * @Author zohn
     * @Date 2020\1\14 0014 14:05
     * @Param []
     * @Return void
     */
    public static void filterTest() {
        // 实例化一个
        Yhxx yhxx = new Yhxx("zohn", "411322199501302430", 2);

        // 放入list中一堆
        List<Yhxx> yhxxList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            if (i == 0) {
                yhxxList.add(new Yhxx("zohn", "41132219950130243" + i, i));
            } else {
                yhxxList.add(new Yhxx("zohn" + i, "41132219950130243" + i, i));
            }
        }

        //把实例化的放入list
        yhxxList.add(yhxx);

        // 过滤出和实例化的yhxx中xm一样并且sfzhm一样的，并打印。
        List<Yhxx> yhxxList1 = yhxxList.stream().filter(x -> Objects.equals(yhxx.getXm(), x.getXm()) && Objects.equals
                (yhxx.getSfzhm(), x.getSfzhm())).collect(Collectors.toList());

        // 打印过滤前的
        System.out.println("before filter:");
        System.out.println(yhxxList.toString());

        // 打印过滤后的
        System.out.println("after filter:");
        System.out.println(yhxxList1.toString());
    }

    /**
     * @Description 求和
     * @Author zohn
     * @Date 2020\1\14 0014 14:25
     * @Param []
     * @Return void
     */
    public static void countTest() {
        // 放入list中一堆
        List<Yhxx> yhxxList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            if (i == 0) {
                yhxxList.add(new Yhxx("zohn", "41132219950130243" + i, i));
            } else {
                yhxxList.add(new Yhxx("zohn" + i, "41132219950130243" + i, i));
            }
        }
        // list中放的是对象，每个对象的元素求和
        int sjgs = yhxxList.stream().mapToInt(Yhxx::getSjgs).sum();

        System.out.println("count of sjgs:" + sjgs);

        // list中直接放的就是数字
        List<Integer> integerList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            integerList.add(i);
        }

        int countTest = integerList.stream().mapToInt(Integer::intValue).sum();
        System.out.println("count Test:" + countTest);
    }
}


