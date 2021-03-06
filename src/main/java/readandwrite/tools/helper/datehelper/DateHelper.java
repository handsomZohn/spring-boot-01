package readandwrite.tools.helper.datehelper;



import readandwrite.tools.helper.stringhelper.StringHelper;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
     * @参数类型:@return
     * @返回值:String
     */
    public static String getBeforeOrAfterDay(int num){
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DAY_OF_MONTH, num);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
        return sdf.format(c.getTime());
    }
}
