package readandwrite.javase.io.readproperties;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesDemo {
    public static final Properties p = new Properties();
    public static final String path = "./dmb.properties";

    /**
     * 通过类装载器 初始化Properties
     */
    public static void init() {
        //转换成流
        InputStream inputStream =
                PropertiesDemo.class.getClassLoader().getResourceAsStream(path);
        try {
            //从输入流中读取属性列表（键和元素对）
            p.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 修改或者新增key
     * @param key
     * @param value
     */
    public static void update(String key, String value) {
        p.setProperty(key, value);
        FileOutputStream oFile = null;
        try {
            oFile = new FileOutputStream(path);
            //将Properties中的属性列表（键和元素对）写入输出流
            p.store(oFile, "");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                oFile.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    /**
     * 通过key获取value
     * @param key
     * @return
     */
    public static String get(String key) {
        return p.getProperty(key);
    }


    public static void main(String[] args) {
        init();
        String jycs_d_yxfw = get("jycs_d_yxfw");
        System.out.println("======^_^======variable jycs_d_yxfw value is : " + jycs_d_yxfw + ", " + " current method and class name is : PropertiesDemo.main()");
        update("jycs_d_yxfw", "jycs_d_yxfw");
        String jycs_d_yxfw1 = get("jycs_d_yxfw");
        System.out.println("======^_^======variable jycs_d_yxfw1 value is : " + jycs_d_yxfw1 + ", " + " current method and class name is : PropertiesDemo.main()");
    }
}
