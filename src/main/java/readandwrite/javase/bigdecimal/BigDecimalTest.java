package readandwrite.javase.bigdecimal;

import java.math.BigDecimal;

/**
 * @ClassName BigDecimalTest
 * @Description BigDecimal 演练
 * @Date 2021/12/9 10:26
 * @Version 1.0
 **/
public class BigDecimalTest {

    public static void main(String[] args) {

        // 传递时，不要传递float类型  会出现精度丢失的情况
        BigDecimal bigDecimal = new BigDecimal("100.33");

        BigDecimal bigDecimal1 = new BigDecimal("50.33");

        BigDecimal subtract = bigDecimal.subtract(bigDecimal1);

        System.out.println(subtract);

    }
}
