package readandwrite.javase.dataType;

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

		System.out.println();
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
}
