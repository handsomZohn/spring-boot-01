package readandwrite.javase.dataType;

import java.math.BigDecimal;

public class AboutBigdecimal {
    public static void main(String[] args) {
        BigDecimal bigDecimal = new BigDecimal(10);
        BigDecimal bigDecimal1 = new BigDecimal(10.00);
        bigDecimal1 = null; // NPE
        System.out.println(bigDecimal.compareTo(bigDecimal1));
    }
}
