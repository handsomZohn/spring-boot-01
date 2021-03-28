package readandwrite.javase.string;

public class StringTest03 {

	/*public static void main(String[] args) {
		String tjny = "201712";
		System.out.println(tjny.substring(4, 5).equals("0")?tjny.substring(5):tjny.substring(4) + "月");
		System.out.println(tjny.substring(5));
		System.out.println(tjny.substring(4));
		
		System.out.println(tjny.substring(0, 4)+"年" + (tjny.substring(4, 5).equals("0")?tjny.substring(5):tjny.substring(4) + "月"));
	}*/
	
	public static void main(String[] args) {
//		String finalreturn = "";
//		String bhgyy = "与“Moumou”政策相冲突！";
//		int endindex = bhgyy.indexOf("政策相冲突");
//		String zcmc = bhgyy.substring(1, endindex);
//		String xsbhgyy = "正在享受其他政策，不能同时享受本政策";
//		int indexOf = xsbhgyy.indexOf("政");
//		
//		finalreturn = xsbhgyy.substring(0, 4) + zcmc + xsbhgyy.substring(6, xsbhgyy.length());
//		System.out.println(finalreturn);
		
		//System.out.println("20170305131414".substring(0, 6));
		
		System.out.println("".equals(null));
		// System.out.println(null.equals(""));

		String str = "1000210004";
		String str02 = "1000210000";
		if (str02.endsWith("0000")) {
			System.out.println(str02.substring(0,5));;
		}
	}
	
	
}
