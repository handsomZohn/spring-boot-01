package readandwrite.tools.helper.datehelper;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTools {
    public DateTools() {
    }

    public String getDate() {
        return this.getDate("yyyyMMddHHmmss");
    }

    public String getDate(String fmt) {
        Date myDate = new Date(System.currentTimeMillis());
        SimpleDateFormat sDateformat = new SimpleDateFormat(fmt);
        return sDateformat.format(myDate).toString();
    }

    private Calendar getCal(String strdate, String fmt) {
        Calendar cal = null;

        try {
            if (strdate == null || fmt == null) {
                System.out.println("Error: Method: DateTools.getCal :Incorrect para");
                return cal;
            }

            SimpleDateFormat nowDate = new SimpleDateFormat(fmt);
            Date d = nowDate.parse(strdate, new ParsePosition(0));
            if (d == null) {
                System.out.println("Fatal: Method: DateTools.getCal :Incorrect Parse");
                return cal;
            }

            cal = Calendar.getInstance();
            cal.clear();
            cal.setTime(d);
        } catch (Exception var6) {
            System.out.println("Error: Method: DateTools.getCal :" + var6.getMessage());
        }

        return cal;
    }

    public int getWeekOfYear(String strdate, String fmt) {
        int ret = -1;

        try {
            if (strdate == null || fmt == null) {
                System.out.println("Error: Method: DateTools.getWeekOfYear :Incorrect para");
                return ret;
            }

            Calendar cal = this.getCal(strdate, fmt);
            if (cal == null) {
                System.out.println("Error: Method: DateTools.getWeekOfYear :Incorrect Calendar");
                return ret;
            }

            ret = cal.get(3);
        } catch (Exception var5) {
            System.out.println("Fatal: Method: DateTools.getWeekOfYear :" + var5.getMessage());
        }

        return ret;
    }

    public String[] getWeekDay(String strdate, String oldfmt, String newfmt) {
        String[] weekday = new String[7];

        try {
            if (strdate == null || oldfmt == null || newfmt == null) {
                System.out.println("Error: Method: DateTools.getWeekDay :Incorrect para");
                return weekday;
            }

            Calendar cal = this.getCal(strdate, oldfmt);
            if (cal == null) {
                System.out.println("Error: Method: DateTools.getWeekDay :Incorrect Calendar");
                return weekday;
            }

            int dayOfWeek = cal.get(7);
            cal.add(5, -dayOfWeek + 2);
            SimpleDateFormat sdf = new SimpleDateFormat(newfmt);
            weekday[0] = sdf.format(cal.getTime());

            for(int i = 1; i < 7; ++i) {
                cal.add(5, 1);
                weekday[i] = sdf.format(cal.getTime());
            }
        } catch (IndexOutOfBoundsException var9) {
            System.out.println("Fatal: Method: DateTools.getWeekDay :" + var9.getMessage());
        }

        return weekday;
    }

    public String[] getWeekDate(String year, int week, String newfmt) {
        String[] jweekday = new String[7];

        try {
            if (year == null || year.length() < 4 || week <= 0 || newfmt == null) {
                System.out.println("Error: Method: DateTools.getWeekDate :Incorrect para");
                return jweekday;
            }

            Calendar cal = this.getCal(year + "0101", "yyyyMMdd");
            if (cal == null) {
                System.out.println("Error: Method: DateTools.getWeekDate :Incorrect Calendar");
                return jweekday;
            }

            --week;
            cal.add(5, week * 7 - cal.get(7) + 2);
            SimpleDateFormat sdf = new SimpleDateFormat(newfmt);
            jweekday[0] = sdf.format(cal.getTime());

            for(int i = 1; i < 7; ++i) {
                cal.add(5, 1);
                jweekday[i] = sdf.format(cal.getTime());
            }
        } catch (IndexOutOfBoundsException var8) {
            System.out.println("Fatal: Method: DateTools.getWeekDate :" + var8.getMessage());
        }

        return jweekday;
    }

    public String getDayOfWeek(String strdate, String oldfmt, String fmt) {
        String sWeek = null;

        try {
            if (strdate == null || oldfmt == null || fmt == null) {
                System.out.println("Error: Method: DateTools.getDayOfWeek :Incorrect para");
                return sWeek;
            }

            Calendar cal = this.getCal(strdate, oldfmt);
            if (cal == null) {
                System.out.println("Error: Method: DateTools.getDayOfWeek :Incorrect Calendar");
                return sWeek;
            }

            int iWeek = cal.get(7);
            sWeek = fmt + (iWeek - 1 == 0 ? 7 : iWeek - 1);
        } catch (Exception var7) {
            System.out.println("Fatal: Method: DateTools.getDayOfWeek :" + var7.getMessage());
        }

        return sWeek;
    }

    public int getWeekNum(String year) {
        int weeknum = -1;

        try {
            if (year == null) {
                System.out.println("Error: Method: DateTools.getWeekNum :Incorrect para");
                return weeknum;
            }

            Calendar cal = this.getCal(year + "1231", "yyyyMMdd");
            if (cal == null) {
                System.out.println("Error: Method: DateTools.getWeekNum :Incorrect Calendar");
                return weeknum;
            }

            if (cal.get(3) == 1) {
                cal.add(5, -7);
            }

            weeknum = cal.get(3);
        } catch (Exception var4) {
            System.out.println("Fatal: Method: DateTools.getWeekNum :" + var4.getMessage());
        }

        return weeknum;
    }

    public String getNextWeek(String year, int week, int next) {
        String ret = null;

        try {
            if (year == null || week <= 0) {
                System.out.println("Error: Method: DateTools.getNextWeek :Incorrect para");
                return ret;
            }

            String[] weekday = this.getWeekDate(year, week, "yyyyMMdd");
            Calendar cal = this.getCal(weekday[0], "yyyyMMdd");
            if (cal == null) {
                System.out.println("Error: Method: DateTools.getNextWeek :Incorrect Calendar");
                return ret;
            }

            cal.add(5, 7 * next);
            if (next > 0) {
                cal.add(5, 6);
            }

            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
            String nextweekday = sdf.format(cal.getTime());
            int weekofyear = this.getWeekOfYear(nextweekday, "");
            ret = nextweekday.substring(0, 4) + Integer.toString(weekofyear);
        } catch (Exception var10) {
            System.out.println("Fatal: Method: DateTools.getNextWeek :" + var10.getMessage());
        }

        return ret;
    }

    public String cntTimeDifference(String startdate, String enddate, String fmt, String refmt) {
        String ret = null;

        try {
            if (startdate == null || enddate == null || fmt == null || refmt == null) {
                System.out.println("Error: Method: DateTools.cntTimeDifference :Incorrect para");
                return ret;
            }

            Date scal = this.getCal(startdate, fmt).getTime();
            Date ecal = this.getCal(enddate, fmt).getTime();
            if (scal == null || ecal == null) {
                System.out.println("Error: Method: DateTools.cntTimeDifference :Incorrect Calendar");
                return ret;
            }

            if (scal.after(ecal)) {
                System.out.println("Error: Method: DateTools.cntTimeDifference :Incorrect para startdate > enddate");
                return ret;
            }

            long diffMillis = ecal.getTime() - scal.getTime();
            long diffSecs = diffMillis / 1000L;
            long diffMins = diffMillis / 60000L;
            long diffHours = diffMillis / 3600000L;
            long diffDays = diffMillis / 86400000L;
            if (refmt.equals("ms")) {
                ret = Long.toString(diffMillis);
            } else if (refmt.equals("s")) {
                ret = Long.toString(diffSecs);
            } else if (refmt.equals("m")) {
                ret = Long.toString(diffMins);
            } else if (refmt.equals("h")) {
                ret = Long.toString(diffHours);
            } else if (refmt.equals("d")) {
                ret = Long.toString(diffDays);
            } else {
                ret = Long.toString(diffHours);
            }
        } catch (Exception var18) {
            System.out.println("Fatal: Method: DateTools.cntTimeDifference :" + var18.getMessage());
        }

        return ret;
    }

    public String getBeforeTime(String deftime, String oldfmt, int timediff, String newfmt) {
        return this.getBeforeTimeBym(deftime, oldfmt, timediff * 60, newfmt);
    }

    public String getBeforeTimeBym(String deftime, String oldfmt, int timediff, String newfmt) {
        String rq = null;

        try {
            if (deftime == null || deftime.equals("")) {
                System.out.println("Error: Method: DateTools.getBeforeTime :Incorrect para");
                return rq;
            }

            Calendar cal = this.getCal(deftime, oldfmt);
            if (cal == null) {
                System.out.println("Error: Method: DateTools.getBeforeTime :Incorrect Calendar");
                return rq;
            }

            cal.add(12, -timediff);
            SimpleDateFormat sdf = new SimpleDateFormat(newfmt);
            rq = sdf.format(cal.getTime());
        } catch (Exception var8) {
            System.out.println("Fatal: Method: DateTools.getBeforeTime :" + var8.getMessage());
        }

        return rq;
    }

    public String getBeforeTimeByM(String deftime, String oldfmt, int timediff, String newfmt) {
        String rq = null;

        try {
            if (deftime == null || deftime.equals("")) {
                System.out.println("Error: Method: DateTools.getBeforeTime :Incorrect para");
                return rq;
            }

            Calendar cal = this.getCal(deftime, oldfmt);
            if (cal == null) {
                System.out.println("Error: Method: DateTools.getBeforeTime :Incorrect Calendar");
                return rq;
            }

            cal.add(2, -timediff);
            SimpleDateFormat sdf = new SimpleDateFormat(newfmt);
            rq = sdf.format(cal.getTime());
        } catch (Exception var8) {
            System.out.println("Fatal: Method: DateTools.getBeforeTime :" + var8.getMessage());
        }

        return rq;
    }

    public String fmtDate(String mydate, String oldfmt, String newfmt) {
        String restr = null;

        try {
            if (mydate == null || oldfmt == null || newfmt == null) {
                System.out.println("Error: Method: DateTools.fmtDate :Incorrect para");
                return restr;
            }

            SimpleDateFormat newDate = new SimpleDateFormat(newfmt);
            Calendar cal = this.getCal(mydate, oldfmt);
            if (cal == null) {
                System.out.println("Error: Method: DateTools.fmtDate :Incorrect Calendar");
                return restr;
            }

            restr = newDate.format(cal.getTime());
        } catch (Exception var7) {
            System.out.println("Fatal: Method: DateTools.fmtDate :" + var7.getMessage());
        }

        return restr;
    }

    public static void main(String[] args) {
        DateTools dt = new DateTools();

        try {
            System.out.println(dt.getWeekOfYear("20040526", "yyyyMMdd"));
            System.out.println(dt.getWeekNum("2004"));
            System.out.println(dt.getNextWeek("2004", 51, 2));
            System.out.println(dt.getWeekOfYear("20041225", "yyyyMMdd"));
            System.out.println(dt.getWeekOfYear("20050101", "yyyyMMdd"));
            System.out.println(dt.getWeekOfYear("20050102", "yyyyMMdd"));
        } catch (Exception var3) {
            var3.printStackTrace();
        }

    }
}
