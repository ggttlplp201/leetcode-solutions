package leetcode;

import java.util.ArrayList;
import java.util.List;

public class leet79 {
    public static void main(String[] args) {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        System.out.println(exist(board, "ABCB"));
    }

    public static boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(i, j, word, visited, board, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean dfs(int i, int j, String word, boolean[][] visited, char[][] board, int index) {
        if (index == word.length()) {
            return true;
        }
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
            return false;
        }
        if (visited[i][j]) {
            return false;
        }
        if (board[i][j] != word.charAt(index)) {
            return false;
        }
        visited[i][j] = true;
        if (dfs(i, j + 1, word, visited, board, index + 1) || dfs(i, j - 1, word, visited, board, index + 1) || dfs(i + 1, j, word, visited, board, index + 1) || dfs(i - 1, j, word, visited, board, index + 1)) {
            return true;
        }
        visited[i][j] = false;
        return false;
    }
}
