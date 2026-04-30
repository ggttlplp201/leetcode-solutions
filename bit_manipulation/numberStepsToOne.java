package leetcode.bit_manipulation;

public class numberStepsToOne {
    public static void main(String[] args) {
        System.out.println(numSteps("1101"));
    }

    public static int numSteps(String s) {
        long num = Long.parseLong(s, 2);
        int count = 0;
        while (num != 1) {
            if (num % 2 != 0) {
                num += 1;
                count++;
            }
            if (num % 2 == 0) {
                num /= 2;
                count++;
            }
        }
        return count;
    }
}
