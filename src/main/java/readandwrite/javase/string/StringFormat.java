package readandwrite.javase.string;


import org.junit.jupiter.api.Test;

public class StringFormat {

    /**
     * @Description 字符串拼接 将2转为02 类似
     * @Author z
     * @Date 2020\5\28 0028 15:32
     * @Param []
     * @Return void
     */
    @Test
    public void liangwei() {
        String placeNum = String.format("%02d", Integer.parseInt("10"));
        System.out.println(placeNum);

        String pn = String.format("%02d", Integer.parseInt("9"));
        System.out.println(pn);
    }
}
