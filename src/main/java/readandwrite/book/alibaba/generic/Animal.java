package readandwrite.book.alibaba.generic;

import java.util.ArrayList;
import java.util.List;

public class Animal {

    public static void main(String[] args) {
        List<Dog> dogs = new ArrayList<>();
        // 不会报错
        int i = countLegs(dogs);
        // 直接编译报错
        // countLegs001(dogs);
        System.out.println("======^_^======变量i值为: " + i + ", " + "当前类以及方法名字是: Animal.main()");
    }

    // 规定了上边界但是不关心具体类型是什么，所以对于传入的 Animal以及其 的所有子类都可以支持，并且不会报错
    static int countLegs (List<? extends Animal> animals) {
        int retVal = 0;
        for (Animal animal : animals) {
            retVal += animal.countLegs(animals);
        }
        return retVal;
    }


    static int countLegs001 (List<Animal> animals) {
        int retVal = 0;
        for (Animal animal : animals) {
            retVal += animal.countLegs(animals);
        }
        return retVal;
    }

}
