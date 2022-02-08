package readandwrite.javase.array;

/**
 * @ClassName ByteArray
 * @Description byte数组转字符串
 * @Date 2022/1/24 14:55
 * @Version 1.0
 **/
public class ByteArray {
    public static void main(String[] args) {
        byte[] byteArray = new byte[]{65, 66, 67, 68, 69};
        String s = new String(byteArray);
        System.out.println(s);
    }
}
