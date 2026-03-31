package leetcode;

public class leet868 {
    public static void main(String[] args) {
        System.out.println(binaryGap(13));
    }

    public static int binaryGap(int n) {
        String s = Integer.toBinaryString(n);
        if (s.chars().filter(c -> c == '1').count() == 1) {
            return 0;
        }
        int longest = 1;
        int len = 1;
        int i = s.indexOf('1') + 1;
        while (i < s.length()) {
            if (s.charAt(i) != '1') {
                len++;
            } else {
                longest = Math.max(longest, len);
                len = 1;
            }
            i++;
        }
        return longest;
    }
}
