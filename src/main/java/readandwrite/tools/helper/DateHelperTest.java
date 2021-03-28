package readandwrite.tools.helper;



import org.junit.jupiter.api.Test;
import readandwrite.tools.helper.datehelper.DateHelper;

/**
 *@Description  
 *@CreateDate   18/08/14 11:44
 *@Author        zohn
 *@Version       1.0
 *
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
}
