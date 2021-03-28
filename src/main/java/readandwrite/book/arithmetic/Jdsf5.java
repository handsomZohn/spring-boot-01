package readandwrite.book.arithmetic;

import javax.swing.JOptionPane;

public class Jdsf5 {

	/**
	 * 【程序5】 题目：利用条件运算符的嵌套来完成此题：学习成绩> =90分的同学用A表示，60-89分之间的用B表示，60分以下的用C表示。
	 * 1.程序分析：(a> b)?a:b这是条件运算符的基本例子。
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		String str = "";
		str = JOptionPane.showInputDialog("请输入分数值(输入exit退出):");// java弹输入框让输入
		int mark = 0;
		try {
			
			if("exit".equals(str)){
				System.exit(0);
			}
			mark = Integer.parseInt(str);
		} catch (NumberFormatException e) {
			throw new RuntimeException("分数格式错误!!!");
			// e.printStackTrace();
		}
		System.out.println(mark > 90 ? "A" : (mark > 60 ? "B" : "C"));
	}
}
