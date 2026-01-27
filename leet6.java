package leetcode;

public class leet6 {
    public static void main(String[] args) {
        String s = "ABCDE";
        int numRows = 4;
        System.out.println(convert(s, numRows));
    }

    public static String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        int n = s.length();

        int cycle = 2 * numRows - 2;
        int colsPerCycle = numRows - 1;

        int fullCycles = n / cycle;
        int remainder = n % cycle;

        int cols = fullCycles * colsPerCycle;

        if (remainder > 0) {
            cols += 1;
            if (remainder > numRows) {
                cols += remainder - numRows;
            }
        }
        String[][] res = new String[numRows][cols];
        int index = 0;
        int r = 0;
        int c = 0;
        while (index < s.length()) {
            if (r == numRows - 1) {
                while (r > 0) {
                    if (index == s.length()) {
                        break;
                    }
                    res[r][c] = s.substring(index, index + 1);
                    c++;
                    r--;
                    index++;
                    if (r == 0) {
                        break;
                    }
                }
            } else {
                res[r][c] = s.substring(index, index + 1);
                r++;
                index++;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[i].length; j++) {
                if (res[i][j] != null) {
                    sb.append(res[i][j]);
                }
            }
        }
        return sb.toString();
    }
}

//r, c = 0
//r++, c doesn't change
//at r == numRows (bottom), c++, r-- <- do this until r == 0 (top)
//repeat, r++, c doesn't change