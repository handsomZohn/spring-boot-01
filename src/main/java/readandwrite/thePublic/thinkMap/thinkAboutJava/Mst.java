package readandwrite.thePublic.thinkMap.thinkAboutJava;

import java.lang.reflect.Field;

// 关于一道面试题
public class Mst {
    public static void main(String[] args) {
        Integer a = 1;
        Integer b = 2;
        System.out.printf("a = %s, b = %s \n", a, b);
        swap(a, b);
        System.out.printf("a = %s, b = %s \n", a, b);
    }

    // 特别提醒这种方式是错误的
    // 特别提醒这种方式是错误的
    // 特别提醒这种方式是错误的
    /*
    public static void swap (Integer a, Integer b) {
        Integer temp = a;
        a = b;
        b = temp;
    }*/

    // 这样写的话  面试官肯定会黑人问号的~~
    /*
    public static void swap (Integer a, Integer b) {
        // TODO 实现
        // 无法实现
    }*/

    // !!!!!!!!!!!!!!
    // a = 1, b = 2
    // a = 2, b = 2
    // !!!!!!!!!!!!!!
    // 在value.set的时候将Integer的缓存值改变了，因为value.set(Object v1, Object v2)两个参数都是对象类型，所以temp会做自动
    // 装箱操作，会调用valueOf方法，这样会取到错误的缓存值，所以为了避免这种情况，就只能不需要调用缓存值，直接new Integer（）就
    // 可以跳过缓存。

    /*
    public static void swap(Integer a, Integer b) {
        int temp = a.intValue();
        try {
            Field value = Integer.class.getDeclaredField("value");
            value.setAccessible(true);
            value.set(a, b);
            value.set(b, temp);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }*/

    // if (i >= IntegerCache.low && i <= IntegerCache.high)
    //       return IntegerCache.cache[i + (-IntegerCache.low)];

    public static void swap (Integer a, Integer b) {
        int temp = a.intValue();
        try {
            Field value = Integer.class.getDeclaredField("value");
            value.setAccessible(true);
            value.set(a, b);
            value.set(b, new Integer(temp));
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }


}
