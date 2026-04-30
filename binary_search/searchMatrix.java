package leetcode.binary_search;

public class searchMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        System.out.println(searchMatrix(matrix, 24));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        //for every row, check if target is within the row
        //if target > last element of this row, move on to next row
        int start = 0;
        int end = matrix[0].length - 1;
        int row = 0;
        while (row < matrix.length) {
            if (target >= matrix[row][start] && target <= matrix[row][end]) {
                //do binary search on this row
                while (start <= end) {
                    int mid = start + (end - start) / 2;
                    if (matrix[row][mid] == target) {
                        return true;
                    } else if (matrix[row][mid] < target) {
                        start = mid + 1;
                    } else {
                        end = mid - 1;
                    }
                }
            }
            row++;
        }
        return false;
    }
}
