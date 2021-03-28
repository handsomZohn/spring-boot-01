package readandwrite.javase.string;

import java.text.DecimalFormat;

public class StringTest {

	public static void main(String[] args) {
		String str = "aa12";
		System.out.println("substring(int):" + str.substring(1)
				+ "\n substring(int,int):" + str.substring(0, 2));
		System.out.println(str.indexOf("2"));

		String sql = "and not exists (select '' from shgyx_rygl_wtrysqmxb mx where mx.zyid = b.zyid"
				+ "  and mx.wtrylx = '01' and mx.qxshyj = '2' and not exists (select ''"
				+ "  from shgyx_rygl_wtrysqmxb mx1 where mx.zyid = mx1.zyid"
				+ "  and mx.gzbny = mx1.gzbny and mx1.qxshyj in ('0', '1'))) and not exists"
				+ " (select ''"
				+ "  from shgyx_rygl_wtrysqmxb mx where mx.zyid = b.zyid and mx.gzbny = f.jfny"
				+ "  and mx.wtrylx = '02' and mx.qxshyj = '2' and not exists (select ''"
				+ "  from shgyx_rygl_wtrysqmxb mx1 where mx.zyid = mx1.zyid and mx.gzbny = mx1.gzbny"
				+ "  and mx1.qxshyj in ('0', '1')))";

		String tjny01 = "201705".substring(0, 4) + "01";
		// System.out.println(tjny01);

		String tjny = "82";
		String tjny_qntq = "40";
		int tjny_parseInt = Integer.parseInt(tjny);
		double tjny_parseDouble = Double.parseDouble(tjny);
		double tjny_qntq_parseDouble = Double.parseDouble(tjny_qntq);

		int tjny_qntq_parseInt = Integer.parseInt(tjny_qntq);
		System.out.println((-Integer.parseInt(tjny_qntq))
				/ Integer.parseInt(tjny_qntq));

		System.out.println((tjny_parseDouble - tjny_qntq_parseDouble)/tjny_qntq_parseDouble);

		System.out.println(tjny_parseInt);
		System.out.println(tjny_qntq_parseInt);

		System.out.println((tjny_parseInt - tjny_qntq_parseInt)
				/ tjny_qntq_parseInt);
		double d1 = 4.00056;
		double d2 = 5;
		System.out.println(d1 / d2);
		System.out.println(Math.round(d1));;
		DecimalFormat decimalFormat = new DecimalFormat("#.00");
		System.out.println(decimalFormat.format(d1));
		

		/*"insert into syry_dajsdjb" +
		"  (DAJSLSH," + 
		"   DWBH,\n" + 
		"   CDJG,\n" + 
		"   JPBALSH,\n" + 
		"   JSRQ,\n" + 
		"   LDBMJBR,\n" + 
		"   DWJSR,\n" + 
		"   JSXZQHDM,\n" + 
		"   CZYDWID,\n" + 
		"   CZYID,\n" + 
		"   CZSJ,\n" + 
		"   DWXZ,\n" + 
		"   DWJJLX,\n" + 
		"   DWHY,\n" + 
		"   JSXZQHDM_BF,\n" + 
		"   XGBZ1,\n" + 
		"   XGBZ2)\n" + 
		"values\n" + 
		"  ('7d7670e33e420020070607033515',\n" + 
		"   '7d7670e10db501',\n" + 
		"   '0',\n" + 
		"   '',\n" + 
		"   '20070607000000',\n" + 
		"   '',\n" + 
		"   '¹ùÀö¾ü',\n" + 
		"   '110112000000',\n" + 
		"   '0000000640',\n" + 
		"   '',\n" + 
		"   '20070607000000',\n" + 
		"   '',\n" + 
		"   '',\n" + 
		"   '',\n" + 
		"   '',\n" + 
		"   '',\n" + 
		"   '');";
*/
	}
}
