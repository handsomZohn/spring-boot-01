package readandwrite.javase.dataType;


import org.junit.jupiter.api.Test;

public class AboutByte {

    @Test
    public void byteTest(){
        // max value of byte
        byte maxValue = Byte.MAX_VALUE;
        byte minValue = Byte.MIN_VALUE;

        int maxValue1 = Integer.MAX_VALUE;

        System.out.println("======^_^======variable maxValue1 value is : " + maxValue1 + ", " + " current method and class name is : AboutByte.byteTest()");


        int i = 1 << 32;

        System.out.println("======^_^======variable i value is : " + i + ", " + " current method and class name is : AboutByte.byteTest()");

        int i1 = Math.multiplyExact(10, 2);

        System.out.println("======^_^======variable i1 value is : " + i1 + ", " + " current method and class name is : AboutByte.byteTest()");

        double pow = Math.pow(2, 32);
        
        

        System.out.println("======^_^======variable pow value is : " + pow + ", " + " current method and class name is : AboutByte.byteTest()");



        int a = 2, b = 31, d = 1;

        for (int j = 0; j < b; j++) {
            d = a * d;
        }

        System.out.println("======^_^======variable d value is : " + d + ", " + " current method and class name is : AboutByte.byteTest()");

    }
}
