package readandwrite.test;

import java.sql.Connection;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JavaZhengzeTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String str = "qqqqqaaaadrrr  ssssaaa   bbbssdfsdfsdfs";
		Pattern p = Pattern.compile("(aaa\\s+bbb)");
		Matcher m = p.matcher(str);
		while (m.find()) {
			str = str.replaceFirst(m.group(1), m.group(1)
					.replaceAll("\\s", "-"));
		}
		// System.out.println(str);

		String str2 = ",,   bbbssdfsdfsdfs";
		Pattern p2 = Pattern.compile("(,,\\s+bbb)");
		Matcher m2 = p2.matcher(str2);
		while (m2.find()) {
			str2 = str2.replaceFirst(m2.group(1), m2.group(1).replaceAll("\\s",
					"-"));
		}
		 //System.out.println(str2);

		// 如："aa bb    cc  dd  ee   cs "变成"aa bb cc dd ee cs"
		// 正则表达式实现
		 String string = "0.0.0.0[]         0.255.255.255[] 552222";
		 String test = string.replaceAll("\\[]\\s{1,}", " "); // \s 匹配任何空白字符，包括空格、制表符、换页符等等。等价于[ \f\n\r\t\v]。 
		 String[] split = test.split(" ");
		 for (int i = 0; i < split.length; i++) {
		 //System.out.println(split[i]);
		 }
		// System.out.println(test);
		// string = test;
		// String[] str3 = string.split(" ");
		// for (String string2 : str3) {
		// System.out.println(string2);
		// }
		// for (int i = 0; i < str3.length; i++) {
		// System.out.println(str3[i]);
		// }

		// 用循环实现
		/*String str4 = "aa bb    cc  dd  ee   cs ";
		String s = "";
		for (int i = 0; i < str4.length() - 1; i++) {
			// 空格转成int型代表数字是32
			if ((int) str4.charAt(i) == 32 && (int) str4.charAt(i + 1) == 32) {
				continue;
			}
			s += str4.charAt(i);
		}
		if ((int) str4.charAt(str4.length() - 1) != 32)
			s += str4.charAt(str4.length() - 1);
		System.out.println(s);*/

		 System.out.println();
		 
		 Connection conn = null;
	}

}


class Operator{
	public static void main(String[] args) {
		int i = 0;
		int j = 0;
		System.out.println( i +++ j);
		
		HashMap map = new HashMap();
	}
}