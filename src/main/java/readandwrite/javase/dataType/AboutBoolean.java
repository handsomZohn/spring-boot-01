package readandwrite.javase.dataType;

public class AboutBoolean {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        if (true || false) {
            System.out.println("false----");
        }

        Boolean valueOf = Boolean.valueOf(false);

        System.out.println(valueOf);

        /**
         * 用==比较和.equals比较是相同的；
         */
        System.out.println(Boolean.FALSE == Boolean.TRUE);
        System.out.println(Boolean.TRUE.equals(Boolean.FALSE));

    }

}
