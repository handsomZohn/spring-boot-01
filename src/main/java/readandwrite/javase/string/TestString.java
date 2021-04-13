package readandwrite.javase.string;

import org.apache.commons.lang3.StringUtils;

public class TestString {
    public static void main(String[] args) {
        String str = null;
        // commons.lang3
        boolean empty = StringUtils.isEmpty(str);
        System.out.println(empty);

        boolean empty1 = org.springframework.util.StringUtils.isEmpty(str);
        System.out.println(empty1);
    }
}
