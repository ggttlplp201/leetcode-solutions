package leetcode;

import java.net.Inet4Address;

public class leet3453 {
    public static void main(String[] args) {
        int[][] squares = {{0, 0, 2}, {1, 1, 1}};
        System.out.println(separateSquares(squares));
    }

    public static double separateSquares(int[][] squares) {
        double min = Integer.MAX_VALUE;
        double max = Integer.MIN_VALUE;
        double totalArea = 0;
        for (int[] square : squares) {
            totalArea += Math.pow(square[2], 2);
            int curr = square[1];
            min = Math.min(min, curr);
            max = Math.max(max, curr + square[2]);

        }
        totalArea /= 2;
        //run binary search
        while (max - min >= 1e-6) {
            double mid = min + (max - min) / 2; //mid = y line
            double area = 0;
            for (int[] square : squares) {
                int bottom = square[1];
                int top = square[1] + square[2];
                if (mid <= bottom) {
                } else if (mid >= top) {
                    area += (double) square[2] * square[2];
                } else {
                    area += (double) square[2] * (mid - bottom);
                }

            }
            if (area < totalArea) {
                min = mid;
            } else {
                max = mid;
            }
        }
        return max;
    }
}
