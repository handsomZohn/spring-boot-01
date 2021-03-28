package readandwrite.book.arithmetic;

/**
 *@Description 求斐波那契的前n项的和
 * 语句只执行一次 时间复杂度就是：O（1）
 *@CreateDate 2020\7\8 0008 13:24
 *@Author z
 *@Version 1.0
 */
public class Fbnq {
    /**
     * 时间复杂度呈指数级别
     * @param n
     * @return
     */
    int fib(int n){
        if (n < 2) {
            return n;
        }
        return fib(n - 1) + fib(n - 2);
    }

    public static int climbStairs (int n) {
        if (n == 1) {
            return 1;
        }

        int first = 1;
        int second = 2;
        for (int i = 3; i <= n; i++) {
            int third = first + second;
            first = second;
            second = third;
        }
        return second;
    }

    public static void main(String[] args) {
        int i = climbStairs(6);
        System.out.println("======^_^======variable i value is : " + i + ", " + " current method and class name is : Fbnq.main()");
    }
}
