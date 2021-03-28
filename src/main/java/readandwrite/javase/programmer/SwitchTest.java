package readandwrite.javase.programmer;

public class SwitchTest {
    /**
     * switch语法：：遇到匹配的项，没有break，后面的case块也会执行
     * 因为没有写break的时候，一旦匹配上之后，不会再去校验其余的case，会直接执行其余的case
     * @param args
     */
    public static void main(String[] args) {
        int condition = 1;
        switch (condition) {
            case 1 :
                System.out.println(1);
                // break;
            case 2 :
                System.out.println(2);
                break;
            case 3 :
                System.out.println(3);
                break;
        }
    }
}
