package readandwrite.book.cyc2018.newCharacteristics.eeight.lambdaExample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description 通过过滤创建一个String列表
 * @CreateDate 18/07/19 17:10
 * @Author zohn
 * @Version 1.0
 */
public class StringListFilter {
    public static void main(String[] args) {
        strFilter();// 过滤
        filter02();// 求和
        filter03();// 对象属性求和
    }

    private static void strFilter() {
        // 创建过滤器过滤
        List<String> strList = Arrays.asList("abc", "", "bcd", "defg", "jk", "kl");
        List<String> filtered = strList.stream().filter(x -> x.length() > 2).collect(Collectors.toList());
        System.out.printf("Original List : %s, filtered list : %s %n", strList, filtered);
        // 关于 filter() 方法有个常见误解。在现实生活中，做过滤的时候，通常会丢弃部分，但使用filter()方法则是获得一个新的列表，
        // 且其每个元素符合过滤原则
    }


    public static void filter02() {
        List<Integer> list = new ArrayList<>();

        list.add(5);
        int size = list.size();
        System.out.println("======^_^======变量size值为: " + size + ", " + "当前类以及方法名字是: StringListFilter.filter02()");

        //Integer integer = list.stream().filter(q -> q == 3).reduce(Integer::sum).get();
        // Integer integer = list.stream().filter(q -> q == 3).reduce(Integer::sum).get();

        Integer integer1 = list.stream().filter(q -> q == 5).reduce(0, Integer::sum);
        System.out.println("======^_^======变量integer1值为: " + integer1 + ", " + "当前类以及方法名字是: StringListFilter.filter02()");
        // list.stream().filter(s -> s == 5).map(Integer :: intValue).reduce(Integer :: sum).get();
    }

    /**
     * @Description 计算几个班级的总人数
     * @CreateDate 18/11/22 9:31
     * @Author zohn
     * @Version 1.0
     */
    public static void filter03() {
        List<ClassRoom> classRoomList = new ArrayList<>();
        for (int i = 0; i < 5; i++){
            classRoomList.add(new ClassRoom("五年级(" + i +")班", (i + 30) + ""));
        }

        classRoomList.forEach(System.out :: print);

        // classRoomList.stream().filter(x -> Integer.valueOf(x.getBjrs()) > 31).reduce(0, Integer :: sum);
    }
}

/**
 * @Description 教室
 * @CreateDate 18/11/22 9:29
 * @Author zohn
 * @Version 1.0
 */
class ClassRoom {
    private String bjmc;// 班级名称
    private String bjrs;// 班级人数

    public ClassRoom(String bjmc, String bjrs) {
        this.bjmc = bjmc;
        this.bjrs = bjrs;
    }

    public String getBjmc() {
        return bjmc;
    }

    public void setBjmc(String bjmc) {
        this.bjmc = bjmc;
    }

    public String getBjrs() {
        return bjrs;
    }

    public void setBjrs(String bjrs) {
        this.bjrs = bjrs;
    }
}
