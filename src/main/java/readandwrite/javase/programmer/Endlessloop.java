package readandwrite.javase.programmer;

/**
 * @Description 死循环
 * @Author zohn
 * @Date 2020\1\6 0006 15:07
 * @Param 
 * @Return 
 */
public class Endlessloop {
    public static void main(String[] args) {

        // 无限循环的又一种写法
        for (;;) {
            System.out.println(110);
            break;
        }

        while (true) {
            System.out.println(110);
            break;
        }
    }
}
