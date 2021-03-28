package readandwrite.javase.array;

import java.util.Arrays;

/**
 * 
 * <p>Title:</p>
 * <p>Description:排序string数组</p>
 * <p>Copyright: Copyright (c) 2017</p>
 * <p>Company: bksx</p>
 * <p>CreateDate:2017-6-7</p>
 * @author zohn
 * @version 1.0
 */
public class SortStringArr {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String[] str = {"abc","ab","az"};
		Arrays.sort(str);
		for (int i = 0; i < str.length; i++) {
			String string = str[i];
			System.out.println(string);
		}
		System.out.println();
	}

}
