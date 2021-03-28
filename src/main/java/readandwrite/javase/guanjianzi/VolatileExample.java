package readandwrite.javase.guanjianzi;

/**
 * @Description VolatileExample
 * @CreateDate 18/08/30 12:40
 * @Author zohn
 * @Version 1.0
 */
public class VolatileExample {

    private static int nextSerialNumber = 0;

    public static int getNextSerialNumber() {
        return nextSerialNumber++;
    }

    public static void main(String[] args) {
        int i = 0;
        while (i < 200) {
            new Thread(() ->
                    System.out.println(getNextSerialNumber())
            ).start();
        /*new Thread(() ->
                System.out.println(getNextSerialNumber())
        ).start();
        new Thread(() ->
                System.out.println(getNextSerialNumber())
        ).start();
        new Thread(() ->
                System.out.println(getNextSerialNumber())
        ).start();
        new Thread(() ->
                System.out.println(getNextSerialNumber())
        ).start();*/
            i++;
        }
    }
}
