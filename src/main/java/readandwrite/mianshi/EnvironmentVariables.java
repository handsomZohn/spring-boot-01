package readandwrite.mianshi;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

/**
 * 获取os环境变量
 * @author Administrator
 */
public class EnvironmentVariables {
    public static void main(String[] args) {
        Properties properties = new Properties();
        InputStream resourceAsStream = EnvironmentVariables.class.getResourceAsStream("./ev.properties");
        try {
            Thread.sleep(1000 * 100);
            properties.load(new InputStreamReader(resourceAsStream, "utf-8"));
            String key = "pwd";
            if (properties.containsKey(key)) {
                String property = properties.getProperty("pwd");
                System.out.println("======^_^======variable property value is : " + property + ", " + " current method and class name is : EnvironmentVariables.main()");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        // 通过system访问
        String java_home = System.getenv("JAVA_HOME");

        System.out.println("======^_^======variable java_home value is : " + java_home + ", " + " current method and class name is : EnvironmentVariables.main()");

        // remember reboot
        String mall_mysql_password = System.getenv("MALL_MYSQL_PASSWORD");
        
        System.out.println("======^_^======variable mall_mysql_password value is : " + mall_mysql_password + ", " + " current method and class name is : EnvironmentVariables.main()");
    }
}
