package leetcode.dp;

public class champagneTower {
    public static void main(String[] args) {
        System.out.println(champagneTower(2, 1, 1));
    }

    public static double champagneTower(int poured, int query_row, int query_glass) {
        double[][] dp = new double[101][101];
        dp[0][0] = poured;
        for (int r = 0; r < 100; r++) {
            for (int c = 0; c <= r; c++) {
                if (dp[r][c] > 1) {
                    double overflow = dp[r][c] - 1;
                    overflow /= 2;
                    dp[r + 1][c] += overflow;
                    dp[r + 1][c + 1] += overflow;
                }
            }
        }
        return Math.min(1, dp[query_row][query_glass]);
    }
}
