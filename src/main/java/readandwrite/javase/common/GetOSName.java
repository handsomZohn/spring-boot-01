package readandwrite.javase.common;

/**
 *@Description 获取当前操作系统类型 win 或者 linux
 *@CreateDate 2020/4/2 21:23
 *@Author zohn
 *@Version 1.0
 */
public class GetOSName {
    public static void main(String[] args) {
        System.out.println("Name of OS: " + System.getProperty("os.name"));
        System.out.println("Arch of OS: " + System.getProperty("os.arch"));
        System.out.println("plugin.confPath: " + System.getProperty("user.dir"));
    }
}
