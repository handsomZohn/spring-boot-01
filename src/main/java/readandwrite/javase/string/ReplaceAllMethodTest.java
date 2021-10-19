package readandwrite.javase.string;

/**
 *
 */
public class ReplaceAllMethodTest {
    public static void main(String[] args) {
        String str = "410000000000";
        // 这个里面的是char类型 所以可以用单引号
        String replace = str.replace('0', '_');
        String s = str.replaceAll("0", "_");
        System.out.println(replace);
        System.out.println(s);
    }
}
