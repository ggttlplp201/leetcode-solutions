package leetcode.sliding_window;

import java.util.HashSet;

public class checkAllBinaryCodes {
    public static void main(String[] args) {
        System.out.println(hasAllCodes("0110", 1));
    }

    public static boolean hasAllCodes(String s, int k) {
        //collect all unique substrings of length k in s
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i <= s.length() - k; i++) {
            set.add(s.substring(i, i + k));
        }
        return set.size() == Math.pow(2, k);
    }
}
