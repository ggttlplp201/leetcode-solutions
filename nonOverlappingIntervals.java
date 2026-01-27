package leetcode;

import java.util.Arrays;

public class nonOverlappingIntervals {
    public static void main(String[] args) {
        //int[][] intervals = {{1, 100}, {11, 22}, {1, 11}, {2, 12}};
        int[][] intervals = {{1, 2}, {1, 2}, {1, 2}, {1, 4}, {1, 4}, {1, 4}};
        boolean[][] arr = new boolean[intervals.length][2];
        Arrays.sort(intervals, (a, b) -> Double.compare(a[0], b[0]));
        for (int i = 0; i < intervals.length - 1; i++) {
            int next = i + 1;
            if (intervals[next][0] < intervals[i][1]) {
                if (intervals[next][1] > intervals[i][1]) {
                    intervals[next][0] = intervals[next + 1][0];
                    intervals[next][1] = intervals[next + 1][1];
                    intervals[next + 1][0] = Integer.MAX_VALUE - 1;
                    intervals[next + 1][1] = Integer.MAX_VALUE;
                    i--;
                } else if (intervals[next][1] < intervals[i][1]) {
                    intervals[i][0] = Integer.MAX_VALUE - 1;
                    intervals[i][1] = Integer.MAX_VALUE;
                } else {
                    intervals[i][0] = Integer.MAX_VALUE - 1;
                    intervals[i][1] = Integer.MAX_VALUE;
                }
            }
        }
        int count = 0;
        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i][0] == (Integer.MAX_VALUE - 1)) {
                count++;
            }
        }
        if (count == intervals.length) {
            count = intervals.length - 1;
        }
        System.out.println(Arrays.deepToString(intervals));
        System.out.println(count);

    }
}
