package leetcode;

import java.util.*;

public class leet76 {
    public static void main() {

    }

    public static String minWindow(String s, String t) {
        HashMap<Character, Integer> targetMap = new HashMap<>();
        HashMap<Character, Integer> windowMap = new HashMap<>();
        for (char c : t.toCharArray()) {
            targetMap.put(c, targetMap.getOrDefault(c, 0) + 1);
        }

        int left = 0;
        int right = 0;
        int formed = 0;
        int required = targetMap.size();

        int[] result = {-1, -1, -1};
        int minLength = Integer.MAX_VALUE;

        while (right < s.length()) {
            char c = s.charAt(right);
            if (windowMap.containsKey(c)) {
                windowMap.put(c, windowMap.get(c) + 1);
            } else {
                windowMap.put(c, 1);
            }
            if (targetMap.containsKey(c) && windowMap.get(c).intValue() == targetMap.get(c).intValue()) {
                formed++;
            }
            while (left <= right && formed == required) {
                if (right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    result[0] = minLength;
                    result[1] = left;
                    result[2] = right;
                }
                char leftChar = s.charAt(left);
                windowMap.put(leftChar, windowMap.get(leftChar) - 1);
                if (targetMap.containsKey(leftChar) && windowMap.get(leftChar).intValue() < targetMap.get(leftChar).intValue()) {
                    formed--;
                }
                left++;
            }
            right++;
        }
        if (result[0] == -1) {
            return "";
        } else {
            return s.substring(result[1], result[2] + 1);
        }
    }
}
