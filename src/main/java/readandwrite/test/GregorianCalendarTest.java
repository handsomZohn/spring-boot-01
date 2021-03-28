package readandwrite.test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class GregorianCalendarTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		/*
		 *合同开始日期是201503
		 *合同满一年是 201602
		 *申报期开始：
		 *申报期结束： 
		 */
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMM");
		Date htksrq=sdf.parse("20150301".substring(0,6));//获得Date型合同开始年月
		System.out.println("201503" + "合同开始日期");
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(htksrq);
		cal.add(GregorianCalendar.MONTH, 11);
		String time1 = sdf.format(cal.getTime());//从合同开始后的第12个月的年月（合同满一年）
		System.out.println(time1 + "合同满一年");
		
		cal.setTime(htksrq);
		cal.add(GregorianCalendar.MONTH, 12);
		String sbqksny = sdf.format(cal.getTime()); //申报期-开始年月
		
		System.out.println(sbqksny + "申报期开始");
		
		
		cal.setTime(htksrq);
		cal.add(GregorianCalendar.MONTH, 23);
		String sbqjsny = sdf.format(cal.getTime()); //申报期-结束年月
		
		System.out.println(sbqjsny + "申报期结束");
		
		
		
		SimpleDateFormat sdf2=new SimpleDateFormat("yyyy");
		String thisMarch = sdf2.format(new Date());
		
		System.out.println(thisMarch + "04");
		
		
		SimpleDateFormat sdf21=new SimpleDateFormat("yyyyMMddHHmmss");
		Date date=sdf21.parse("20160401132121");
		cal.setTime(date);
		//cal.add(Calendar.MONTH, 11);
		cal.add(Calendar.MONTH, 13);
		String s=sdf21.format(cal.getTime());
		System.out.println("合同开始日期" + "201604");
		System.out.println("合同开始日期推迟13个月" + s.substring(0, 6));
	}

}
