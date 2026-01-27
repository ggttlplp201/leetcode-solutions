package leetcode;

import java.util.Arrays;

public class leet2943 {
    public static void main(String[] args) {
        int n = 1;
        int m = 1;
        int[] hBars = {5, 3, 2, 4};
        int[] vBars = {36, 41, 6, 34, 33};
        System.out.println(maximizeSquareHoleArea(n, m, hBars, vBars));

    }

    public static int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        Arrays.sort(hBars);
        Arrays.sort(vBars);
        //find longest consecutive sequence
        int hx = 0;
        int temp = 0;
        int currLen = 0;
        int longestLen = 0;
        for (int i = 1; i < hBars.length; i++) {
            if (hBars[i] == hBars[i - 1]) {
                continue;
            }
            if (hBars[i] == hBars[i - 1] + 1) {
                currLen++;
            } else {
                temp = i; //temp = starting index
                currLen = 0;
            }
            if (currLen > longestLen) {
                longestLen = currLen;
                hx = temp;
            }
        }
        int hy = hx + longestLen;
        temp = 0;
        currLen = 0;
        longestLen = 0;
        int vx = 0;
        for (int i = 1; i < vBars.length; i++) { //6 31 33 34 36 41
            if (vBars[i] == vBars[i - 1]) {
                continue;
            }
            if (vBars[i] == vBars[i - 1] + 1) {
                currLen++;
            } else {
                temp = i;
                currLen = 0;
            }
            if (currLen > longestLen) {
                longestLen = currLen;
                vx = temp;
            }
        }
        int vy = vx + longestLen;
        int maxLen = Math.min(hBars[hy] - hBars[hx] + 2, vBars[vy] - vBars[vx] + 2);
        return maxLen * maxLen;
    }
}
