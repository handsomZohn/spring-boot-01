package com.zohn.springboot01.xdvideo.utils;

import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringTools {
    public StringTools() {
    }

    public static String toTrim(String str) {
        if (str == null) {
            return "";
        } else {
            return str.trim().equalsIgnoreCase("null") ? "" : str.trim();
        }
    }

    public static boolean isEmpty(String str) {
        boolean ret = false;
        if (toTrim(str).equals("")) {
            ret = true;
        }

        return ret;
    }

    public static String dealNull(String str) {
        String returnstr = null;
        if (str == null) {
            returnstr = "";
        } else {
            returnstr = str;
        }

        return returnstr;
    }

    public static Object dealNull(Object obj) {
        Object returnstr = null;
        if (obj == null) {
            returnstr = "";
        } else {
            returnstr = obj;
        }

        return returnstr;
    }

    public static int dealEmpty(String s) {
        s = dealNull(s);
        return s.equals("") ? 0 : Integer.parseInt(s);
    }

    public static String iso2gbk(String isostr) {
        if (isostr != null) {
            byte[] tmpbyte = null;

            try {
                tmpbyte = isostr.getBytes("ISO8859_1");
            } catch (Exception var4) {
                System.out.println("Error: Method: StringTools.iso2gbk :" + var4.getMessage());
            }

            try {
                isostr = new String(tmpbyte, "GBK");
            } catch (Exception var3) {
                System.out.println("Error: Method: StringTools.iso2gbk :" + var3.getMessage());
            }
        }

        return isostr;
    }

    public static String gbk2iso(String gbkstr) {
        if (gbkstr != null) {
            byte[] tmpbyte = null;

            try {
                tmpbyte = gbkstr.getBytes("GBK");
            } catch (Exception var4) {
                System.out.println("Error: Method: StringTools.gbk2iso :" + var4.getMessage());
            }

            try {
                gbkstr = new String(tmpbyte, "ISO8859_1");
            } catch (Exception var3) {
                System.out.println("Error: Method: StringTools.gbk2iso :" + var3.getMessage());
            }
        }

        return gbkstr;
    }

    public static String htmlEncode(String txt) {
        if (txt != null) {
            txt = replace(txt, "&", "&amp;");
            txt = replace(txt, "&amp;amp;", "&amp;");
            txt = replace(txt, "&amp;quot;", "&quot;");
            txt = replace(txt, "\"", "&quot;");
            txt = replace(txt, "&amp;lt;", "&lt;");
            txt = replace(txt, "<", "&lt;");
            txt = replace(txt, "&amp;gt;", "&gt;");
            txt = replace(txt, ">", "&gt;");
            txt = replace(txt, "&amp;nbsp;", "&nbsp;");
            txt = replace(txt, " ", "&nbsp;");
        }

        return txt;
    }

    public static String unHtmlEncode(String txt) {
        if (txt != null) {
            txt = replace(txt, "&amp;", "&");
            txt = replace(txt, "&quot;", "\"");
            txt = replace(txt, "&lt;", "<");
            txt = replace(txt, "&gt;", ">");
            txt = replace(txt, "&nbsp;", " ");
        }

        return txt;
    }

    public static String ScriptEncode(String txt) {
        if (txt != null) {
            txt = replace(txt, "script", "s cript");
            txt = replace(txt, "SCRIPT", "s cript");
            txt = replace(txt, "Script", "s cript");
            txt = replace(txt, "SCript", "s cript");
            txt = replace(txt, "<marquee", "&lt;marquee");
            txt = replace(txt, "<Marquee", "&lt;marquee");
            txt = replace(txt, "<MARQUEE", "&lt;marquee");
            txt = replace(txt, "<html", "&lt;html");
            txt = replace(txt, "<Html", "&lt;html");
            txt = replace(txt, "<HTML", "&lt;HTML");
            txt = replace(txt, "<head", "&lt;head");
            txt = replace(txt, "<HEAD", "&lt;HEAD");
            txt = replace(txt, "<Head", "&lt;head");
            txt = replace(txt, "<title", "&lt;title");
            txt = replace(txt, "<TITLE", "&lt;TITLE");
            txt = replace(txt, "<Title", "&lt;title");
            txt = replace(txt, "<body", "&lt;body");
            txt = replace(txt, "<BODY", "&lt;BODY");
            txt = replace(txt, "<Body", "&lt;body");
            txt = replace(txt, "<frame", "&lt;frame");
            txt = replace(txt, "<FRAME", "&lt;FRAME");
            txt = replace(txt, "<Frame", "&lt;frame");
            txt = replace(txt, "<frameset", "&lt;frameset");
            txt = replace(txt, "<FRAMESET", "&lt;FRAMESET");
            txt = replace(txt, "<Frameset", "&lt;frameset");
            txt = replace(txt, "<meta", "&lt;meta");
            txt = replace(txt, "<META", "&lt;META");
            txt = replace(txt, "<Meta", "&lt;Meta");
        }

        return txt;
    }

    public static boolean isNumber(String validString) {
        try {
            byte[] tempbyte = validString.getBytes();

            for (int i = 0; i < validString.length(); ++i) {
                if (tempbyte[i] < 48 || tempbyte[i] > 57) {
                    return false;
                }
            }

            return true;
        } catch (Exception var3) {
            var3.printStackTrace();
            return false;
        }
    }

    public static boolean isChar(String validString) {
        byte[] tempbyte = validString.getBytes();

        for (int i = 0; i < validString.length(); ++i) {
            if (tempbyte[i] < 48 || tempbyte[i] > 57 & tempbyte[i] < 65 || tempbyte[i] > 122 || tempbyte[i] > 90 & tempbyte[i] < 95 || tempbyte[i] > 95 & tempbyte[i] < 97) {
                return false;
            }
        }

        return true;
    }

    public static boolean isLetter(String validString) {
        byte[] tempbyte = validString.getBytes();

        for (int i = 0; i < validString.length(); ++i) {
            if (tempbyte[i] < 65 || tempbyte[i] > 122 || tempbyte[i] > 90 & tempbyte[i] < 97) {
                return false;
            }
        }

        return true;
    }

    public static String toTureAsciiStr(String str) {
        StringBuffer sb = new StringBuffer();
        byte[] bt = str.getBytes();

        for (int i = 0; i < bt.length; ++i) {
            if (bt[i] < 0) {
                sb.append((char) (bt[i] & 127));
            } else {
                sb.append('\u0000');
                sb.append((char) bt[i]);
            }
        }

        return sb.toString();
    }

    public static String unToTrueAsciiStr(String str) {
        byte[] bt = str.getBytes();
        int l = 0;
        int length = bt.length;
        int j = 0;

        int i;
        for (i = 0; i < length; ++i) {
            if (bt[i] == 0) {
                ++l;
            }
        }

        byte[] bt2 = new byte[length - l];

        for (i = 0; i < length; ++i) {
            if (bt[i] == 0) {
                ++i;
                bt2[j] = bt[i];
            } else {
                bt2[j] = (byte) (bt[i] | 128);
            }

            ++j;
        }

        String tt = new String(bt2);
        return tt;
    }

    public static int getCount(String str, String sign) {
        if (str == null) {
            return 0;
        } else {
            StringTokenizer s = new StringTokenizer(str, sign);
            return s.countTokens();
        }
    }

    public static int getStrCount(String str, String sign) {
        Pattern p = Pattern.compile(sign);
        Matcher m = p.matcher(str);

        int i;
        for (i = 0; m.find(); ++i) {
            ;
        }

        return i;
    }

    /**
     * @deprecated
     */
    public static String StrReplace(String sourceString, String toReplaceString, String replaceString) {
        String returnString = sourceString;
        int stringLength = 0;
        if (toReplaceString != null) {
            stringLength = toReplaceString.length();
        }

        if (sourceString != null && sourceString.length() > stringLength) {
            // int max = false;
            String S4 = "";

            for (int i = 0; i < sourceString.length(); ++i) {
                int max = i + toReplaceString.length() > sourceString.length() ? sourceString.length() : i + stringLength;
                String S3 = sourceString.substring(i, max);
                if (!S3.equals(toReplaceString)) {
                    S4 = S4 + S3.substring(0, 1);
                } else {
                    S4 = S4 + replaceString;
                    i += stringLength - 1;
                }
            }

            returnString = S4;
        }

        return returnString;
    }

    public static String[] split(String source, String div) {
        int arynum = 0;
        //int intIdx = false;
        //int intIdex = 0;
        int div_length = div.length();
        int intIdx;
        if (source.compareTo("") != 0) {
            if (source.indexOf(div) != -1) {
                intIdx = source.indexOf(div);

                for (int var6 = 1; source.indexOf(div, intIdx + div_length) != -1; arynum = var6++) {
                    intIdx = source.indexOf(div, intIdx + div_length);
                }

                arynum += 2;
            } else {
                arynum = 1;
            }
        } else {
            arynum = 0;
        }

        intIdx = 0;
        //intIdex = 0;
        String[] returnStr = new String[arynum];
        if (source.compareTo("") == 0) {
            return returnStr;
        } else if (source.indexOf(div) == -1) {
            returnStr[0] = source.substring(0, source.length());
            return returnStr;
        } else {
            intIdx = source.indexOf(div);
            returnStr[0] = source.substring(0, intIdx);

            int intCount;
            for (intCount = 1; source.indexOf(div, intIdx + div_length) != -1; ++intCount) {
                int intIdex = source.indexOf(div, intIdx + div_length);
                returnStr[intCount] = source.substring(intIdx + div_length, intIdex);
                intIdx = source.indexOf(div, intIdx + div_length);
            }

            returnStr[intCount] = source.substring(intIdx + div_length, source.length());
            return returnStr;
        }
    }

    public static String replace(String str, String substr, String restr) {
        if (str == null) {
            return "";
        } else {
            String[] tmp = split(str, substr);
            String returnstr = null;
            if (tmp.length != 0) {
                returnstr = tmp[0];

                for (int i = 0; i < tmp.length - 1; ++i) {
                    returnstr = dealNull(returnstr) + restr + tmp[i + 1];
                }
            }

            return dealNull(returnstr);
        }
    }

    public static String fmtString(String msg, int fixLength) {
        if (msg == null) {
            msg = "";
        }

        if (msg.trim().equals("null") || msg.trim().equals("")) {
            msg = "";
        }

        byte[] data = msg.getBytes();
        if (data.length < fixLength) {
            return msg;
        } else {
            byte[] tmp = new byte[fixLength];
            System.arraycopy(data, 0, tmp, 0, fixLength);
            data = tmp;
            int count = 0;

            for (int i = 0; i < data.length && data[data.length - 1 - i] < 0; ++i) {
                ++count;
            }

            switch (count % 2) {
                case 1:
                    byte[] tmp2 = new byte[data.length - 1];
                    System.arraycopy(data, 0, tmp2, 0, data.length - 1);
                    data = tmp2;
                default:
                    String reSult = new String(data) + "...";
                    return reSult;
            }
        }
    }

    public static String[] strToArray(String str, int len) {
        try {
            if (len <= 0) {
                return null;
            } else {
                // int alen = false;
                if (str == null) {
                    return null;
                } else if (!str.trim().equals("null") && !str.trim().equals("")) {
                    int alen = str.length();
                    if (alen == 0) {
                        return null;
                    } else {
                        alen = str.length() / len;
                        String[] temp = new String[alen];

                        for (int i = 0; i < alen; ++i) {
                            temp[i] = str.substring(i * len, (i + 1) * len);
                        }

                        return temp;
                    }
                } else {
                    return null;
                }
            }
        } catch (Exception var5) {
            System.out.println("getArray is err" + var5.getMessage());
            var5.printStackTrace();
            return null;
        }
    }

    public static String dataFormat(int number, int num) {
        try {
            // int len = false;
            String temp = Integer.toString(number);
            int len = temp.length();
            if (len < num) {
                for (int i = 0; i < num - len; ++i) {
                    temp = "0" + temp;
                }
            }

            return temp;
        } catch (Exception var5) {
            var5.printStackTrace();
            return "0";
        }
    }

    public static String dataFormat(String str, int num) {
        try {
            // int len = false;
            String temp = toTrim(str);
            if (temp.equals("")) {
                temp = "0";
            }

            int len = temp.length();
            if (len < num) {
                for (int i = 0; i < num - len; ++i) {
                    temp = "0" + temp;
                }
            }

            return temp;
        } catch (Exception var5) {
            var5.printStackTrace();
            return "0";
        }
    }

    public static void main(String[] args) {
        replace((String) null, "", "");
    }
}
