package leetcode;

public class leet1975 {
    public static void main(String[] args) {
        int[][] matrix = {{10, -6, -6, -8}, {-3, -7, -8, -9}, {-4, -8, -5, -8}, {-9, -9, -6, -8}};
        System.out.println(maxMatrixSum(matrix));
    }

    public static long maxMatrixSum(int[][] matrix) {
        int count = 0;
        long sum = 0;
        int smallest = Integer.MAX_VALUE;
        //if a negative number is adj to a 0, then we keep the positive value of it
        boolean hasAdjZero = false;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                sum += Math.abs(matrix[i][j]);
                if (Math.abs(matrix[i][j]) < smallest) {
                    smallest = Math.abs(matrix[i][j]);
                }
                if (matrix[i][j] < 0) {
                    if (i == 0 && j == 0) { //top left corner
                        if (matrix[i][j + 1] == 0 || matrix[i + 1][j] == 0) {
                            hasAdjZero = true;
                        }
                    } else if (i == 0 && j == matrix[i].length - 1) { //bottom left corner
                        if (matrix[i][j - 1] == 0 || matrix[i + 1][j] == 0) {
                            hasAdjZero = true;
                        }
                    } else if (i == matrix.length - 1 && j == 0) { //top right corner
                        if (matrix[i][j + 1] == 0 || matrix[i - 1][j] == 0) {
                            hasAdjZero = true;
                        }
                    } else if (i == matrix.length - 1 && j == matrix[i].length - 1) { //bottom right corner
                        if (matrix[i - 1][j] == 0 || matrix[i][j - 1] == 0) {
                            hasAdjZero = true;
                        }
                    } else if (j + 1 <= matrix[i].length - 1 && i + 1 <= matrix.length - 1 && j - 1 >= 0 && i - 1 >= 0) {
                        if (matrix[i][j + 1] == 0 || matrix[i - 1][j] == 0 || matrix[i + 1][j] == 0 || matrix[i][j - 1] == 0) { //any other hex
                            hasAdjZero = true;
                        }
                    }
                    count++;
                }
            }
        }
        if (count % 2 == 0 || hasAdjZero) {
            return sum;
        }
        return sum - 2L * smallest;
    }
}


//        while (row + 1 < matrix.length && col + 1 < matrix[0].length) {
//            int biggest = Integer.MIN_VALUE;
//            //scan every 2x2
//            for (int i = row; i < row + 2; i++) {
//                for (int j = col; j < col + 2; j++) {
//                    int curr = matrix[i][j];
//                    if (curr < 0) {
//                        sum -= curr;
//                        count++;
//                        if (curr > biggest) {
//                            biggest = curr;
//                        }
//                    } else {
//                        sum += curr;
//                    }
//                }
//            }
//            if (count % 2 != 0) {
//                sum += 2L * biggest;
//            }
//            row++;
//            col++;
//        }
//        return sum;

