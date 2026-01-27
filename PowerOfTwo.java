package leetcode;

public class PowerOfTwo {
    private static int k = 0;

    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(16));
    }

    public static boolean isPowerOfTwo(int n) {
        return recursion(k, n);
    }

    private static boolean recursion(int k, int n) {
        int res = (int) Math.pow(2, k);
        if (res == n) {
            return true;
        }
        if (res < n) {
            return recursion(k + 1, n);
        }
        return false;
    }
}
