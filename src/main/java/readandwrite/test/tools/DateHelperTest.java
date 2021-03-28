package readandwrite.test.tools;



import org.junit.jupiter.api.Test;
import readandwrite.tools.helper.datehelper.DateHelper;

import java.util.Date;

/**
 *@Description DateHelper测试类
 *@CreateDate 2020\3\13 0013 10:23
 *@Author zohn
 *@Version 1.0
 */
public class DateHelperTest {

    @Test
    public void testDateHelper() {
        // 日期增量
        int rqzl = 1;
        // 获取当前时间
        String dqsj = DateHelper.getNow("yyyyMMdd");
        // 获取当前时间的后一天
        String rq = DateHelper.getBeforDate(dqsj, -rqzl * 24);

        System.out.println("当前日期：" + dqsj + "当前日期的后一天：" + rq);
    }

    @Test
    public void getBeforeOrAfterDay(){
        String after2Days = DateHelper.getBeforeOrAfterDay(-2);
        System.out.println("======^_^======变量after2Days值为: " + after2Days + ", " + "当前类以及方法名字是: DateHelperTest.getBeforeOrAfterDay()");
    }
}
