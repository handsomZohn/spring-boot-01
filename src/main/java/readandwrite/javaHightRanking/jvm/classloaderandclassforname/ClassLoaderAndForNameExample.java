package readandwrite.javaHightRanking.jvm.classloaderandclassforname;

/**
 *@Description  classloader 和 forName的区别
 *@CreateDate   18/07/31 17:49
 *@Author        zohn
 *@Version       1.0
 *
 */
public class ClassLoaderAndForNameExample {
    public static void main(String[] args) throws ClassNotFoundException {
        String wholeNameLine = "com.jvm.classloaderandclassforname.Line";
        String wholeNamePoint = "com.jvm.classloaderandclassforname.Point";
        System.out.println("下面是测试ClassLoader的效果");
        classLoaderTest(wholeNameLine,wholeNamePoint);
        System.out.println("-----------------------------------------------");
        System.out.println("下面是测试classForName的效果");
        classforNameTest(wholeNameLine,wholeNamePoint);
    }

    /**
     * classloader
     * @param wholeNameLine
     * @param wholeNamePoint
     * @throws ClassNotFoundException
     */
    private static void classLoaderTest(String wholeNameLine, String wholeNamePoint)  throws ClassNotFoundException {
        Class<?> line;
        Class<?> point;
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        line = systemClassLoader.loadClass(wholeNameLine);
        point = systemClassLoader.loadClass(wholeNamePoint);
        System.out.println("line   " + line.getName());
        System.out.println("point  " + point.getName());
    }

    /**
     * class.forName
     * @param wholeNameLine
     * @param wholeNamePoint
     * @throws ClassNotFoundException
     */
    private static void classforNameTest(String wholeNameLine, String wholeNamePoint) throws ClassNotFoundException {
        Class line = Class.forName(wholeNameLine);
        Class point = Class.forName(wholeNamePoint);
        System.out.println("line  " + line.getName());
        System.out.println("line  " + point.getName());
    }
}
