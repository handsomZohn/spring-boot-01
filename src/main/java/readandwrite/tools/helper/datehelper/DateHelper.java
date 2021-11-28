package readandwrite.tools.helper.datehelper;


import lombok.experimental.var;
import lombok.val;
import readandwrite.tools.helper.stringhelper.StringHelper;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

/**
 * @Description 自己写的DateHelper
 * @CreateDate 18/08/14 11:33
 * @Author zohn
 * @Version 1.0
 */
public class DateHelper extends DateTools { // 烧茄子盖饭 尖叫腊肉盖饭
    private DateHelper() {
    }

    private final static String FORMAT_STR_14 = "yyyyMMddHHmmss";
    private final static String FORMAT_STR_8 = "yyyyMMdd";
    private final static String FORMAT_STR_17 = "yyyyMMddHHmmssSSS";

    public static String long2str14(long time) {
        Date d = new Date(time);
        DateFormat df = new SimpleDateFormat(FORMAT_STR_14);
        return df.format(d);
    }

    public static String long2str8(long time) {
        Date d = new Date(time);
        DateFormat df = new SimpleDateFormat(FORMAT_STR_8);
        return df.format(d);
    }

    public static String long2str17(long time) {
        Date d = new Date(time);
        DateFormat df = new SimpleDateFormat(FORMAT_STR_17);
        return df.format(d);
    }

    /**
     * 格式化时间  年月日
     */
    public static String formatYMD(String k_yxkssj) {
        StringBuffer sj = new StringBuffer();
        String year = k_yxkssj.substring(0, 4);
        String moth = k_yxkssj.substring(4, 6);
        if ("0".equals(k_yxkssj.substring(4, 5))) {
            moth = k_yxkssj.substring(5, 6);
        }
        String day = k_yxkssj.substring(6, 8);
        if ("0".equals(k_yxkssj.substring(6, 7))) {
            day = k_yxkssj.substring(7, 8);
        }
        sj.append(year);
        sj.append("年");
        sj.append(moth);
        sj.append("月");
        sj.append(day);
        sj.append("日");
        return sj.toString();
    }

    /**
     * 格式化日期yyyy-mm-dd 为 yyyymmdd
     */
    public static String fomat8Str(String str) {
        return str.replace("-", "");
    }

    /**
     * 获取当前时间 yyyy-mm-dd用于页面回显示服务器时间
     */
    public static String getServiceDate() {
        Date d = new Date(System.currentTimeMillis());
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        return df.format(d);
    }

    /**
     * 获取当前时间的前n天时间 yyyyMMdd
     */
    public static String getBeforDate(String dateStr, int diff) {
        return new DateTools().getBeforeTime(dateStr, FORMAT_STR_8, diff, FORMAT_STR_8);
    }

    /**
     * 格式化日期字符串
     *
     * @param dateString 日期字符串
     * @param source     源格式
     * @param target     目标格式
     * @return 格式化后的字符串
     */
    public static String dateFmt(String dateString, String source, String target) {
        if (StringHelper.isEmpty(dateString)) {
            return "";
        }
        DateTools myjt = new DateTools();
        return myjt.fmtDate(dateString, source, target);
    }

    /**
     * 得到当前的时间 格式为yyyyMMddhhmmssSSS
     *
     * @return
     */
    public static String getNow() {
        DateTools mydt = new DateTools();
        return mydt.getDate();// 当前时间
    }

    /**
     * 得到当前的时间 格式为format
     *
     * @return
     */
    public static String getNow(String format) {
        DateTools mydt = new DateTools();
        return mydt.getDate(format);// 当前时间
    }

    /**
     * 得到当前的时间 格式为yyyyMMdd
     *
     * @return
     */
    public static String getToday() {
        return getNow("yyyyMMdd");
    }

    /**
     * 获得当前日期前一个月，格式为yyyy-MM-dd
     */
    public static String dateFmt_qyr() {
        DateTools mydt = new DateTools();
        return mydt.getBeforeTimeByM(mydt.getDate("yyyyMMdd"), "yyyyMMdd", 1, "yyyy-MM-dd");
    }

    /**
     * 获得星期几
     *
     * @return
     */
    public static String getWeek(String yyyyMMdd) {

        return "";
    }

    /**
     * 得到当前的时间 格式为yyyy-MM-dd
     *
     * @return
     */
    public static String getTodayFmt() {
        return getNow("yyyy-MM-dd");
    }

    /**
     * 格式化日期字符串  输入
     */
    public static String dateFmt_ymdhms(String rq) {
        return dateFmt(rq, "yyyy-MM-dd", "yyyyMMddHHmmss");
    }

    /**
     * 格式化日期字符串  输入_查询结束时间
     */
    public static String dateFmt_ymdhms_cx(String rq) {
        return dateFmt(rq, "yyyy-MM-dd", "yyyyMMdd") + "235959";
    }

    /**
     * 格式化日期字符串  输出
     */
    public static String dateFmt_ymd(String rq) {
        return dateFmt(rq, "yyyyMMddHHmmss", "yyyy-MM-dd");
    }

    /**
     * 格式化日期字符串  输出
     */
    public static String dateFmt_ymToymdhms(String rq) {
        return dateFmt(rq, "yyyy-MM", "yyyyMMddHHmmss");
    }

    /**
     * 格式化日期字符串  输出
     */
    public static String dateFmt_ym(String rq) {
        return rq.substring(0, 4) + "-" + rq.substring(4, 6);
    }

    /**
     * 格式化日期字符串  输入
     */
    public static String dateFmt_ymdhms_begin(String rq) {
        return dateFmt(rq, "yyyy-MM-dd", "yyyyMMdd") + "000000";
    }

    /**
     * 格式化日期字符串  输入
     */
    public static String dateFmt_ymhms_begin(String rq) {
        return dateFmt(rq, "yyyy-MM", "yyyyMMdd") + "000000";
    }

    /**
     * 格式化日期字符串  输入
     */
    public static String dateFmt_ymdhms_end(String rq) {
        return dateFmt(rq, "yyyy-MM-dd", "yyyyMMdd") + "235959";
    }

    /**
     * 格式化日期字符串  输入
     */
    public static String dateFmt_ymhms_end(String rq) {
        return dateFmt(rq, "yyyy-MM", "yyyyMMdd") + "235959";
    }


    /**
     * 得到 几天后(几天前的日期)的 日期
     * 方法描述: 几天后num为正数，几天前num为负数
     *
     * @param num
     * @return
     */
    public static String getBeforeOrAfterDay(int num) {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DAY_OF_MONTH, num);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
        return sdf.format(c.getTime());
    }

    public static String dateToWeek(String dateTime) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String[] weekDays = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
        Calendar cal = Calendar.getInstance();
        Date date;
        try {
            date = sdf.parse(dateTime);
            cal.setTime(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
        return weekDays[w];
    }

    /**
     * 去除日期中的0
     * e.g. 2021-01-01转换为2021年1月1日
     *
     * @param dateTime
     * @return
     */
    public static String dateClearZero(String dateTime) {
        Integer year = Integer.parseInt(dateTime.substring(0, 4));
        Integer month = Integer.parseInt(dateTime.substring(5, 7));
        Integer day = Integer.parseInt(dateTime.substring(8, 10));
        StringBuilder res = new StringBuilder();
        if (year > 0) {
            res.append(year + "年");
        }
        if (month > 0) {
            res.append(month + "月");
        }
        if (day > 0) {
            res.append(day + "日");
        }
        return res.toString();
    }

    /**
     * new Date() 转 YYYY-MM-dd HH:mm:ss
     * e.g. Sun Jun 06 18:13:23 CST 2021 转为
     */


    /**
     * @return java.lang.String
     * @Author viy
     * @Description 获取指定日期的前几日后几日，如不指定默认今天
     * @Date 11:14 2021/11/23
     * @Param [num, year, month, day]
     **/
    public static String getBeforeOrAfterDay(int num, int year, int month, int day) {
        Calendar c = Calendar.getInstance();

        // 要获取指定日期，传入年月日
        if (year != 0 && month != 0 && day != 0) {
            c.set(year, month - 1, day);
        }
        c.add(Calendar.DATE, num);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
        return sdf.format(c.getTime());
    }

    /**
     * @return int[]
     * @Author viy
     * @Description 数组形式返回年月日
     * @Date 11:32 2021/11/23
     * @Param []
     **/
    public static int[] getYMD() {
        Calendar instance = Calendar.getInstance();
        int year = instance.get(Calendar.YEAR);
        int month = instance.get(Calendar.MONTH) + 1;
        int day = instance.get(Calendar.DAY_OF_MONTH);
        int[] ints = {year, month, day};
        return ints;
    }

    /**
     * @return java.lang.String
     * @Description 获取当前日期
     * @Date 15:10 2021/11/23
     * @Param []
     **/
    public static String getNowDate(String fmt) {
        return new SimpleDateFormat(fmt).format(Calendar.getInstance().getTime());
    }


    /*public static void getDateIntervalDays(String date, String date2) throws ParseException{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date parse = sdf.parse(date);
        Date parse1 = sdf.parse(date2);
        int l = (int) ((parse1.getTime() - parse.getTime()) / (1000 * 3600 * 24));
        System.out.println(l);
    }*/

    /**
     * @return int
     * @Description 获取两个日期时间间隔 包括两端
     * @Date 15:45 2021/11/23
     * @Param [dateStart, dateEnd]
     **/
    public static int getDateIntervalDays(String dateStart, String dateEnd) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date parse = null;
        Date parse1 = null;
        try {
            parse = sdf.parse(dateStart);
            parse1 = sdf.parse(dateEnd);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        int l = (int) ((parse1.getTime() - parse.getTime()) / (1000 * 3600 * 24));
        return l;
    }


    /**
     * @return java.lang.String
     * @Author viy
     * @Description 获取前num个月[获取后num个月，传递负数]
     * @Date 20:16 2021/11/28
     * @Param [num, nowDate（yyyy-MM格式）]
     **/
    public static String getBeforeOrAfterMonth(int num, String nowDate) {
        YearMonth parse = YearMonth.parse(nowDate);
        // plus 向后取 传递复数向前取
        // String s = parse.plus(num, ChronoUnit.MONTHS).toString();
        // minus 向前取 传递复数向后取
        String s1 = parse.minus(num, ChronoUnit.MONTHS).toString();
        return s1;
    }


    /**
     * @return int
     * @Author viy
     * @Description 获取月份间隔
     * @Date 20:44 2021/11/28
     * @Param [startDate, endDate]
     **/
    public static int getMonthsInterval(String startDate, String endDate) {
        int interval = 0;
        SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
        Date startDate1 = null;
        Date endDate1 = null;
        try {
            startDate1 = fmt.parse(startDate);
            endDate1 = fmt.parse(endDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(startDate1);
        int sYear = calendar.get(Calendar.YEAR);
        int sMonth = calendar.get(Calendar.MONTH);
        calendar.setTime(endDate1);
        int eYear = calendar.get(Calendar.YEAR);
        int eMonth = calendar.get(Calendar.MONTH);
        interval = ((eYear - sYear) * 12 + (eMonth - sMonth));
        return interval + 1;
    }

    /**
     * @Author viy
     * @Description 根据日期获取当月第一天和最后一天
     * @Date 21:05 2021/11/28
     * @Param [date, startOrEnd]
     * @return java.lang.String
     **/
    /**
     * @return java.lang.String
     * @Description 根据日期获取当月最后一天
     * @Date 21:05 2021/11/28
     * @Param [date, startOrEnd]
     **/
    public static String getLastDayOfMonth(String date) {
        Calendar cale = Calendar.getInstance();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        try {
            cale.setTime(formatter.parse(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        cale.add(Calendar.MONTH, 1);
        cale.set(Calendar.DAY_OF_MONTH, 0);
        return formatter.format(cale.getTime());
    }


    public static void main(String[] args) throws ParseException {
        String nowDate = getNowDate("yyyy-MM");
        String beforeOrAfterMonth = getBeforeOrAfterMonth(1, nowDate);
        System.out.println(beforeOrAfterMonth);

        int monthsInterval = getMonthsInterval("2021-08-23", "2021-11-21");
        System.out.println(monthsInterval);

        String firstOrLastDayOfMonth = getLastDayOfMonth("2021-11-11");
        System.out.println(firstOrLastDayOfMonth);
    }
}
