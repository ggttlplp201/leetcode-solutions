package leetcode;

import java.util.*;

public class spiralMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] matrix3 = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        int[][] matrix2 = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16},
                {17, 18, 19, 20},
                {21, 22, 23, 24}
        };
        System.out.println(spiralOrder(matrix));
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        int row = 0;
        int col = 0;
        int bound = matrix[0].length;
        int bound2 = matrix.length;
        int len = matrix.length * matrix[0].length;
        int count = 0;
        int lower = 0;
        ArrayList<Integer> res = new ArrayList<>();
        while (count < len) {
            while (col < bound) {
                res.add(matrix[row][col]);
                col++;
                count++;
                if (count >= len) {
                    return res;
                }
            }
            row++;
            col--;
            while (row < bound2) {
                res.add(matrix[row][col]);
                row++;
                count++;
                if (count >= len) {
                    return res;
                }
            }
            row--;
            col--;
            while (col > lower) {
                res.add(matrix[row][col]);
                col--;
                count++;
                if (count >= len) {
                    return res;
                }
            }
            while (row > lower) {
                res.add(matrix[row][col]);
                row--;
                count++;
                if (count >= len) {
                    return res;
                }
            }
            row++;
            col++;
            bound--;
            lower++;
            bound2--;
        }
        return res;
    }
}
