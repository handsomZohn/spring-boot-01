package readandwrite.javase.string;

/**
 * @ClassName BeEqualsToAndEquals
 * @Description == 和 equals
 * @Date 2022/3/2 15:58
 * @Version 1.0
 **/
public class BeEqualsToAndEquals {
    public static void main(String[] args) {
        String str = "str";
        String str1 = "str";

        String str2 = new String("str");
        String str3 = new String("str");

        System.out.println(str == str1);
        System.out.println(str2.equals(str3));
    }
}
