package leetcode.hash;

import java.util.*;

public class findLengthOfLongestCommonPrefix {
    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new int[]{13, 27, 45}, new int[]{21, 27, 48}));
    }

    public static int longestCommonPrefix(int[] arr1, int[] arr2) {
        HashSet<Integer> s = new HashSet<>();
        for (int num : arr1) {
            while (num > 0) {
                s.add(num);
                num = num / 10;
            }
        }
        int common = 0;
        int max = 0;
        for (int num : arr2) {
            while (num > 0) {
                if (s.contains(num)) {
                    common = num;
                    if (Integer.toString(common).length() > Integer.toString(max).length()) {
                        max = common;
                    }
                }
                num = num / 10;
            }
        }
        if (common == 0) {
            return 0;
        }
        return Integer.toString(max).length();
    }
}
