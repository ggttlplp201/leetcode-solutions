package leetcode;

public class minTimeToReachLastRoomI {
    public static void main(String[] args) {
        int[][] moveTime = {
                {17, 56},
                {97, 80}
        };
        System.out.println(minTimeToReach(moveTime));
    }

    public static int minTimeToReach(int[][] moveTime) {
        int r = 0;
        int c = 0;
        int time = moveTime[0][0];
//        if (moveTime[r][c + 1] < moveTime[r + 1][c]) {
//            time += moveTime[r][c + 1];
//        } else if (moveTime[r][c + 1] > moveTime[r + 1][c]) {
//            time += moveTime[r + 1][c];
//        } else {
//            time += moveTime[r + 1][c];
//        }

        int curTime = 0;
        while (r != moveTime[0].length - 1 || c != moveTime.length - 1) {
            if (curTime >= time) {
                if (c == moveTime.length - 1) {
                    time += moveTime[r + 1][c] - curTime;
                    r++;
                } else if (r == moveTime[0].length - 1) {
                    time += moveTime[r][c + 1] - curTime;
                    c++;
                } else if (moveTime[r][c + 1] < moveTime[r + 1][c]) {
                    time += moveTime[r][c + 1] - curTime;
                    c++;
                } else if (moveTime[r][c + 1] > moveTime[r + 1][c]) {
                    time += moveTime[r + 1][c] - curTime;
                    r++;
                } else {
                    time += moveTime[r + 1][c] - curTime;
                    if (c < moveTime.length - 1) {
                        c++;
                    } else {
                        r++;
                    }
                }
            }
            curTime++;
        }
        return curTime;
    }
}
