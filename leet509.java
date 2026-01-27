package leetcode;

public class leet509 {
    public static void main(String[] args) {
        System.out.println(fib(3));
    }

    public static int fib(int n) {
        if (n <= 1) {
            return n;
        }
        int prev1 = 1; //n - 1
        int prev2 = 0; //n - 2
        for (int i = 2; i <= n; i++) {
            int curr = prev1 + prev2;
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }
}
