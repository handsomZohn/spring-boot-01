package readandwrite.javase.programmer.lambda;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ForZhu {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Student student = new Student();
            student.setAge((i + 1) + "");
            student.setId(Long.parseLong(i + ""));
            if (i < 5) {
                student.setGrade("一年级");
            } else {
                student.setGrade("二年级");
            }
            student.setName("zhangsan" + 2);
            students.add(student);
        }

        // 分组
        Map<String, List<Student>> collect = students.stream().collect(Collectors.groupingBy(x -> x.getGrade()));

        // 分组并取出最值
        Map<String, Student> packTaskOrderMap = students.stream().collect(Collectors.groupingBy(p -> p.getGrade(),
                Collectors.collectingAndThen(Collectors.reducing((c1, c2) -> c1.getId() > c2.getId() ? c1 : c2), Optional::get)));

        // 不存在new一个 存在
        Student student = packTaskOrderMap.putIfAbsent("二年级", new Student());

        int i = 0;
        System.out.println("======^_^======变量i值为: " + i + ", " + "当前类以及方法名字是: ForZhu.main()");

        // 确定有没有值（one）
        boolean b = students.stream().anyMatch(s -> Objects.equals(s.getGrade(), "二年级"));
        System.out.println("======^_^======变量b值为: " + b + ", " + "当前类以及方法名字是: ForZhu.main()");

        // 确定有没有值（all）
        boolean b02 = students.stream().allMatch(s -> Objects.equals(s.getAge(), "3"));
        System.out.println("======^_^======变量b02值为: " + b02 + ", " + "当前类以及方法名字是: ForZhu.main()");


        int j = 10;
        System.out.println("======^_^======变量j值为: " + j + ", " + "当前类以及方法名字是: ForZhu.main()");

        // sort 排序
        List<Student> studentList = students.stream().sorted(Comparator.comparing(Student::getGrade).reversed().thenComparing(Student::getId)).collect(Collectors.toList());
        String s = studentList.toString();
        System.out.println("======^_^======排序结果为: " + s + ", " + "当前类以及方法名字是: ForZhu.main()");

        int k = 20;
        System.out.println("======^_^======变量k值为: " + k + ", " + "当前类以及方法名字是: ForZhu.main()");

        //  求年龄的和
        int sum = students.stream().mapToInt(r -> Integer.valueOf(r.getAge())).sum();
        // int sum02 = students.stream().mapToInt(Student::(Integer)getAge).sum();
        System.out.println("======^_^======变量sum值为: " + sum + ", " + "当前类以及方法名字是: ForZhu.main()");

        // 把一个,隔开的字符串转换为集合
        String[] str = {"1", "2", "3"};
        List<String> stringList = Arrays.stream(str).collect(Collectors.toList());
        // 不推荐使用的方法
        // Arrays.asList(str);
    }
}
