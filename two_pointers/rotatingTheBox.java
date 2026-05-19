package leetcode.two_pointers;

import java.util.Arrays;

public class rotatingTheBox {
    public static void main(String[] args) {
        char[][] box = {
                {'#', '#', '*', '.', '*', '.'},
                {'#', '#', '#', '*', '.', '.'},
                {'#', '#', '#', '.', '#', '.'}
        };
        char[][] box2 = {{'#', '.', '#'}};
        char[][] rotated = rotateTheBox(box);
        for (char[] chars : rotated) {
            System.out.println(Arrays.toString(chars));
        }
    }

    public static char[][] rotateTheBox(char[][] boxGrid) {
        int m = boxGrid.length;
        int n = boxGrid[0].length;
        //move stones to the right then rotate
        for (int i = 0; i < m; i++) {
            int empty = n - 1;
            for (int j = n - 1; j >= 0; j--) {
                if (boxGrid[i][j] == '*') {
                    empty = j - 1;
                } else if (boxGrid[i][j] == '#') {
                    boxGrid[i][j] = '.';
                    boxGrid[i][empty] = '#';
                    empty--;
                }
            }
        }

        char[][] rotated = new char[n][m]; //n rows m cols
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                rotated[i][j] = boxGrid[m - 1 - j][i];
            }
        }
        return rotated;
    }
}
