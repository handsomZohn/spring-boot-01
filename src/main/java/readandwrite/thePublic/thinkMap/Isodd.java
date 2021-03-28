package readandwrite.thePublic.thinkMap;


import org.junit.jupiter.api.Test;

/**
 *@Description 判断一个数是否为奇数
 *@CreateDate 2020\3\19 0019 15:36
 *@Author zohn
 *@Version 1.0
 */
public class Isodd {

    public void isodd(int i){
        if (i % 2 == 1){
            System.out.println("是奇数");
        } else {
            System.out.println("是偶数");
        }
    }

    @Test
    public void isoddTest(){
        isodd(10);
    }

    public boolean isodd02(int i){
        // V1.00.00 存在问题：括号中本来就是boolean值可直接返回，升级为V2.00.00

        // if (i % 2 == 1) {
        //     return true;
        // } else {
        //     return false;
        // }

        // V2.00.00 存在问题：如果传递进来的是负数呢，升级为V3.00.00
        // return i % 2 == 1;

        // V3.00.00 存在问题： == 1 和 == -1 返回后都表示是奇数只有 == 0表示为偶数，升级为V3.10.00
        // return i % 2 == 1 || i % 2 == -1;

        // V3.10.00 存在问题：取模操作比较慢  升级为V4.00.00
        // return i % 2 != 0;

        // V4.00.00 存在问题：再次升级 V5.00.00
        // return i >> 1 << 1 != i;

        // V5.00.00
        return (i & 1) == 1;

        // 按位与操作和取模操作，实际运行的时间是差不多的，为什么呢？
        // 编译器会将对2的指数的取模操作，优化成位运算操作。
    }

    @Test
    public void isodd02Test(){
        boolean b = isodd02(20);
        System.out.println("======^_^======变量b值为: " + b + ", " + "当前类以及方法名字是: Isodd.isodd02Test()");
    }
}
