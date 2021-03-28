package readandwrite.javase.array;

import java.util.Arrays;

public class Zsgzsxxg {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//zsgzsxxg();
		ssub();
	}

	/**
	 * 展示工种顺序修改
	 */
	public static void zsgzsxxg() {
		String lscpvb = "RIA";// 算法
		String[] ppzyvb = { "IRA", "RIE", "RIE", "RIE", "RIE", "RIE", "RIE",
				"RIE", "RIE", "RIE", "IRA", "IRA", "IRA", "RIE", "RAI", "RAI",
				"RIC", "RIC", "RIC", "RIC", "RIC", "RIC", "RIC", "RIC", "RI",
				"RI", "RIC", "RI", "RIC", "RIC", "RIC", "RIC", "RIC", "RIC",
				"RIC", "RIC", "RIC", "RIC", "RIC", "RIC", "RSI", "IRS", "IRS",
				"ISA", "IRS", "IRS", "IRS", "IRS", "ISA", "SIA" };// 带排序数组
		// 字典顺序排序
		Arrays.sort(ppzyvb);

		for (int i = 0; i < ppzyvb.length; i++) {
			System.out.println(ppzyvb[i]);
		}

		System.out.println("------------分割线------------");

		for (int i = 0; i < ppzyvb.length; i++) {
			if (ppzyvb[i].equals(lscpvb)) {
				//排序后的第一段
				String[] copyOfRange = Arrays.copyOfRange(ppzyvb, i,
						ppzyvb.length);
				//排序后的第二段
				String[] copyOfRange2 = Arrays.copyOfRange(ppzyvb, 0, i);
				//扩容
				copyOfRange = Arrays.copyOf(copyOfRange, ppzyvb.length);
				System.arraycopy(copyOfRange2, 0, copyOfRange, ppzyvb.length-i, copyOfRange2.length);
				for (int j = 0; j < copyOfRange.length; j++) {
					System.out.println(copyOfRange[j]);
				}
				break;
			} else if (ppzyvb[i].equals(lscpvb.substring(0, 2))) {
				//排序后的第一段
				String[] copyOfRange = Arrays.copyOfRange(ppzyvb, i,
						ppzyvb.length);
				//排序后的第二段
				String[] copyOfRange2 = Arrays.copyOfRange(ppzyvb, 0, i);
				//扩容
				copyOfRange = Arrays.copyOf(copyOfRange, ppzyvb.length);
				System.arraycopy(copyOfRange2, 0, copyOfRange, ppzyvb.length-i, copyOfRange2.length);
				
				for (int j = 0; j < copyOfRange.length; j++) {
					System.out.println(copyOfRange[j]);
				}
				break;
			}
		}
		
		char[] charArray = lscpvb.toCharArray();
		String[] strArray = new String[charArray.length];
		for (int i = 0; i < charArray.length; i++) {
			char c = charArray[i];
			System.out.println(c);
		}
		// 按照指定顺序排序类似这样
		/**
		 * RIA RI [只有两个字母] RI* [*代表一个任意字母] R** [*代表一个任意字母] *** [*代表一个任意字母]
		 */
	}
	
	public static void ssub(){
		String str = "RIA";
		System.out.println(str.substring(0, 1));
		System.out.println(str.substring(1, 2));
		System.out.println(str.substring(2));
	}

}
