package readandwrite.javase.string;

public class StringTest02 {

	public static void main(String[] args) {
//		System.out.print("aa\raa");
//		System.out.print("aa\naa");
//		System.out.println("aa\faa");
//		System.out.println("aa\taa");
//		System.out.println("aacII\b");
//		System.out.println("\\");
		// \r	回车
		// \f 	换页
		// \n 	换行
		// \t	制表符
		// \	转义
		// \b	单词边界
		
		
		ppdgkg();
	}
	
	// java 正则 匹配多个空格
	public static void ppdgkg(){
		String str = "   ";
		String reg_str = "\\s*";
		System.out.println(str.matches(reg_str));
	}
}
