package readandwrite.book.cyc2018.newCharacteristics.eeight.lambdaExample;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 *@Description  Java 8 Predicate 的例子，展示了过滤集合数据的多种常用方法 这个类没有通过我自己写的测试找的例子是错误的--呜呜
 *@CreateDate   18/07/19 13:31
 *@Author        zohn
 *@Version       1.0
 *
 */
public class PredicateExample {
    public static void main(String[] args) {
        List<String> language = Arrays.asList("Java", "Scala", "C++", "Haskell", "Lisp");
        System.out.println("Language which start with J:");
        // filter(language, (str) -> str.);
    }

    public static void filter(List<String> names, Predicate condition){
        for (String name: names) {
            if (condition.test(name)){
                System.out.println(name + "");
            }
        }
    }

}
