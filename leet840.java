package leetcode;

public class leet840 {
    public static void main(String[] args) {
        int[][] grid = {{4, 3, 8, 5, 5, 5}, {9, 5, 1, 5, 5, 5}, {2, 7, 6, 5, 5, 5}};
        System.out.println(numMagicSquaresInside(grid));
    }

    public static int numMagicSquaresInside(int[][] grid) {
        //center must be 5
        //all numbers must be between 1 and 9 and unique
        //check sum
        int sum = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        for (int i = 0; i <= rows - 3; i++) {
            for (int j = 0; j <= cols - 3; j++) {
                if (grid[i + 1][j + 1] != 5) {
                    continue;
                }
                boolean[] seen = new boolean[10];
                boolean ok = true;
                for (int r = 0; r < 3 && ok; r++) {
                    for (int c = 0; c < 3; c++) {
                        int val = grid[i + r][j + c];
                        if (val < 1 || val > 9 || seen[val]) {
                            ok = false;
                            break;
                        }
                        seen[val] = true;
                    }
                }
                if (!ok) {
                    continue;
                }
                int r1 = grid[i][j] + grid[i][j + 1] + grid[i][j + 2];
                int r2 = grid[i + 1][j] + grid[i + 1][j + 1] + grid[i + 1][j + 2];
                int r3 = grid[i + 2][j] + grid[i + 2][j + 1] + grid[i + 2][j + 2];

                int c1 = grid[i][j] + grid[i + 1][j] + grid[i + 2][j];
                int c2 = grid[i][j + 1] + grid[i + 1][j + 1] + grid[i + 2][j + 1];
                int c3 = grid[i][j + 2] + grid[i + 1][j + 2] + grid[i + 2][j + 2];

                int d1 = grid[i][j] + grid[i + 1][j + 1] + grid[i + 2][j + 2];
                int d2 = grid[i][j + 2] + grid[i + 1][j + 1] + grid[i + 2][j];

                if (r1 == 15 && r2 == 15 && r3 == 15 &&
                        c1 == 15 && c2 == 15 && c3 == 15 &&
                        d1 == 15 && d2 == 15) {
                    sum++;
                }
            }
        }
        return sum;

    }
}
