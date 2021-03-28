package readandwrite.javase.dataType;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class AboutDouble {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		hdxsdhlw();
	}
	
	//给一个double类型的数据，获取到 其 其 小数点 后两位
	public static void hdxsdhlw(){
		//第一种
		DecimalFormat decimalFormat = new DecimalFormat("#########0.0000");//.后面0的个数表示保留位数
		double d1 = 1.23567;
		System.out.println(decimalFormat.format(d1) + "formater");
		//第二种
		BigDecimal bigDecimal = new BigDecimal(d1);
		double doubleValue = bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		System.out.println(doubleValue + "BigDecimal");
		//第三种   since 1.5
		String result = String.format("%.2f",d1);//%.表示.前任意位数 2表示.后两位
		System.out.println(result + "%.2f");
		//第四种
		NumberFormat numberInstance = NumberFormat.getNumberInstance();
		numberInstance.setMaximumFractionDigits(2);
		System.out.println(numberInstance.format(d1) + "numberFormat");
	}

}
