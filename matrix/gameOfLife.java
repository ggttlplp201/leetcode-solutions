package leetcode.matrix;

import java.util.*;

class Pair {
    int x;
    int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }


}

public class gameOfLife {
    public static void main(String[] args) {
        int[][] board = {{0, 1, 0}, {0, 0, 1}, {1, 1, 1}, {0, 0, 0}};
        gameOfLife(board);
    }

    public static void gameOfLife(int[][] board) {
        //to modify simultaneously in place, hold all coordiates as a pair and change array at the end

        ArrayList<Pair> coordinates = new ArrayList<>(); //stores coordinates that needs to flip
        int live;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                live = 0;
                if (i - 1 >= 0 && j - 1 >= 0) { //top left
                    if (board[i - 1][j - 1] == 1) {
                        live++;
                    }
                }
                if (i - 1 >= 0) { //top
                    if (board[i - 1][j] == 1) {
                        live++;
                    }
                }
                if (i - 1 >= 0 && j + 1 < board[0].length) { //top right
                    if (board[i - 1][j + 1] == 1) {
                        live++;
                    }
                }
                if (j - 1 >= 0) { //left
                    if (board[i][j - 1] == 1) {
                        live++;
                    }
                }
                if (j + 1 < board[0].length) { //right
                    if (board[i][j + 1] == 1) {
                        live++;
                    }
                }
                if (i + 1 < board.length && j - 1 >= 0) { //bottom left
                    if (board[i + 1][j - 1] == 1) {
                        live++;
                    }
                }
                if (i + 1 < board.length) { //bottom
                    if (board[i + 1][j] == 1) {
                        live++;
                    }
                }
                if (i + 1 < board.length && j + 1 < board[0].length) { //bottom right
                    if (board[i + 1][j + 1] == 1) {
                        live++;
                    }
                }
                if (board[i][j] == 1 && live < 2) {
                    coordinates.add(new Pair(i, j));
                } else if (board[i][j] == 1 && live > 3) {
                    coordinates.add(new Pair(i, j));
                } else if (board[i][j] == 0 && live == 3) {
                    coordinates.add(new Pair(i, j));
                }
            }
        }
        for (Pair p : coordinates) {
            board[p.x][p.y] = 1 - board[p.x][p.y];
        }
    }
}

//top left: (i - 1, j - 1)
//top: (i - 1, j)
//top right: (i - 1, j + 1)
//left: (i, j - 1)
//right: (i, j + 1)
//bottom left: (i + 1, j - 1)
//bottom: (i + 1, j)
//bottom right: (i + 1, j + 1)

