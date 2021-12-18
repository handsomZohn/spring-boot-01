package readandwrite.javase.dataType;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.Random;

public class AboutInt {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i = 21;

		System.out.println(0 + i + "");

		System.out.println(Integer.parseInt("0000"));

		System.out.println("Integer的最大值是:" + Integer.MAX_VALUE);
		System.out.println("Integer的最大值的2倍是:" + Integer.MAX_VALUE*2);

		System.out.println();

		System.out.println("Long的最大值是:" + Long.MAX_VALUE*2);

		long l = Math.abs(Long.MIN_VALUE) + Long.MAX_VALUE;
		System.out.println(l);

		// 如何计算Long.MIN_VALUE 和 Long.MAX_VALUE的和?
	}

	private void syso() {
		// TODO Auto-generated method stub

	}

}

class EffectiveJava {
	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			BigInteger bigInteger = new BigInteger(0, 0, new Random(2));
			System.out.println(bigInteger);
		}
	}


	public int returnI(){
		int i = 10;
		// 先加后返回11
		// return ++i;

		// 返回的是加之前的值
		// System.out.println(i++);
		// System.out.println(i);
		return i++;
	}


	@Test
	public void returnITest(){
		/*EffectiveJava effectiveJava = new EffectiveJava();
		int i = effectiveJava.returnI();
		System.out.println(i);*/

		int i = 0;
		int j = i++ + ++i;

		// 首选运行+运算
		// 0+ ++i
		// i++
		// 0 + ++1
		// 0+2=2
		System.out.println(i);
		System.out.println(j);
	}
}
