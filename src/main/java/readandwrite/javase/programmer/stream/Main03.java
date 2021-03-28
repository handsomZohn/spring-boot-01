package readandwrite.javase.programmer.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Description https://www.liaoxuefeng.com/wiki/1252599548343744/1322656099991586
 * @Author zohn
 * @Date 2020/1/26 20:07
 * @Param
 * @Return
 */
public class Main03 {
    public static void main(String[] args) {
        // 输出为List
        outputAsList();
        // 输出为Arr
        outputAsArr();
        // 输出为map
        outPutAsMap();
        // 分组输出
        outPutByGroup();
    }

    /**
     * @Description 输出为list
     * @Author zohn
     * @Date 2020\1\17 0017 14:14
     * @Param []
     * @Return void
     */
    static void outputAsList () {
        Stream<String> stream = Stream.of("Apple", "Orange", "", null, "Pear", "   ", "banana");
        List<String> list = stream.filter(s -> s != null && !s.isEmpty()).collect(Collectors.toList());
        System.out.println("======^_^======变量list值为: " + list + ", " + "当前类以及方法名字是: Main03.main()");
    }

    /**
     * @Description 输出为数组
     * @Author zohn
     * @Date 2020\1\17 0017 14:15
     * @Param []
     * @Return void
     */
    static void outputAsArr(){
        List<String> list = Arrays.asList("Apple", "Banana", "Orange");
        String[] strings = list.stream().toArray(String[]::new);

        Arrays.stream(strings).forEach(x -> System.out.println("======^_^======变量x值为: " + x + ", " + "当前类以及方法名字是: Main03.outputAsArr()"));
        // System.out.println("======^_^======变量strings值为: " + strings + ", " + "当前类以及方法名字是: Main03.outputAsArr()");
    }

    /**
     * @Description 输出为map
     * @Author zohn
     * @Date 2020/1/26 19:46
     * @Param []
     * @Return void
     */
    static void outPutAsMap(){
        Stream<String> stream = Stream.of("APPL:Apple", "MSFT:Microsoft");
        Map<String, String> map = stream.collect(Collectors.toMap(
           // 把元素s映射为key
                s -> s.substring(0,s.indexOf(":")),
                // 把元素s映射为key
                s -> s.substring(s.indexOf(":") + 1)));
                System.out.println("======^_^======变量map值为: " + map + ", " + "当前类以及方法名字是: Main03.outPutAsMap()");
    }

    /**
     * 分组输出
     */
    static void outPutByGroup () {
        List<String> strings = Arrays.asList("Apple", "Banana", "Blackberry", "Coconut", "Avocado", "Cherry", "Apricots");
        Map<String, List<String>> collect = strings.stream().collect(Collectors.groupingBy(s -> s.substring(0, 1), Collectors.toList()));
        System.out.println("======^_^======变量collect值为: " + collect + ", " + "当前类以及方法名字是: Main03.outPutByGroup()");
    }
}
