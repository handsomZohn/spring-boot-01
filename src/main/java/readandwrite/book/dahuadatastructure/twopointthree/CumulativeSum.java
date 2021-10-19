package readandwrite.book.dahuadatastructure.twopointthree;

public class CumulativeSum {
    public static void main(String[] args) {
        int i = 0, sum = 0, n = 100;
        for (i = 1; i <= n; i++) {
            sum = sum + i;
        }

        System.out.println(sum);
    }
}
