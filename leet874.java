package leetcode;

import java.util.*;

class Pair {
    int x;
    int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Pair)) {
            return false;
        }
        Pair p = (Pair) o;
        return x == p.x && y == p.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}

public class leet874 {
    public static void main(String[] args) {
        System.out.println(robotSim(new int[]{4, -1, 3}, new int[][]{}));
    }

    public static int robotSim(int[] commands, int[][] obstacles) {
        String facing;
        int maxDist = Integer.MIN_VALUE;
        Pair curr = new Pair(0, 0);
        HashSet<Pair> obs = new HashSet<>();
        for (int i = 0; i < obstacles.length; i++) {
            obs.add(new Pair(obstacles[i][0], obstacles[i][1]));
        }
        int i = 0;
        int idx = 0;
        String[] dirs = {"N", "E", "S", "W"};
        while (i < commands.length) {
            //if next move is obstacle, skip to next command
            int move = commands[i];
            if (move == -2) {
                idx = (idx + 3) % 4; // left
                i++;
                continue;
                //move = commands[i];
            }
            if (move == -1) {
                idx = (idx + 1) % 4; // right
                i++;
                continue;
                //move = commands[i];
            }
            facing = dirs[idx];

            if (facing.equals("N")) {
                for (int j = 0; j < move; j++) {
                    if (obs.contains(new Pair(curr.x, curr.y + 1))) {
                        break;
                    }
                    curr.y++;
                }
            } else if (facing.equals("E")) {
                for (int j = 0; j < move; j++) {
                    if (obs.contains(new Pair(curr.x + 1, curr.y))) {
                        break;
                    }
                    curr.x++;
                }
            } else if (facing.equals("S")) {
                for (int j = 0; j < move; j++) {
                    if (obs.contains(new Pair(curr.x, curr.y - 1))) {
                        break;
                    }
                    curr.y--;
                }
            } else {
                for (int j = 0; j < move; j++) {
                    if (obs.contains(new Pair(curr.x - 1, curr.y))) {
                        break;
                    }
                    curr.x--;
                }
            }
            int dist = curr.x * curr.x + curr.y * curr.y;
            if (dist > maxDist) {
                maxDist = dist;
            }
            i++;
        }
        return maxDist;
    }
}
