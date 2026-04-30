package leetcode.simulation;

public class robotSimulationII {
    public static void main(String[] args) {
        Robot robot = new Robot(6, 3);

        robot.step(2);
        robot.step(2);

        int[] pos1 = robot.getPos();
        System.out.println("getPos: [" + pos1[0] + ", " + pos1[1] + "]");

        String dir1 = robot.getDir();
        System.out.println("getDir: " + dir1);

        robot.step(2);
        robot.step(1);
        robot.step(4);

        int[] pos2 = robot.getPos();
        System.out.println("getPos: [" + pos2[0] + ", " + pos2[1] + "]");

        String dir2 = robot.getDir();
        System.out.println("getDir: " + dir2);
    }

    static class Robot {
        int width, height;
        int x = 0, y = 0;
        int dir = 0; // 0=East,1=North,2=West,3=South
        int perimeter;

        public Robot(int width, int height) {
            this.width = width;
            this.height = height;
            perimeter = 2 * (width + height) - 4;
        }

        public void step(int num) {
            num %= perimeter;
            if (num == 0) {
                num = perimeter;
            }
            while (num > 0) {
                if (dir == 0) {
                    int move = Math.min(num, width - 1 - x);
                    x += move;
                    num -= move;
                    if (move == 0) {
                        dir = 1;
                    }
                } else if (dir == 1) {
                    int move = Math.min(num, height - 1 - y);
                    y += move;
                    num -= move;
                    if (move == 0) {
                        dir = 2;
                    }
                } else if (dir == 2) {
                    int move = Math.min(num, x);
                    x -= move;
                    num -= move;
                    if (move == 0) {
                        dir = 3;
                    }
                } else {
                    int move = Math.min(num, y);
                    y -= move;
                    num -= move;
                    if (move == 0) {
                        dir = 0;

                    }
                }
            }
        }

        public int[] getPos() {
            return new int[]{x, y};
        }

        public String getDir() {
            return new String[]{"East", "North", "West", "South"}[dir];
        }
    }
}