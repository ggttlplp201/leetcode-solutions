package leetcode;

import java.util.*;

public class leet784 {
    public static void main(String[] args) {
        String s = "a1b2";
        System.out.println(letterCasePermutation(s));
    }

    public static List<String> letterCasePermutation(String s) {
        List<String> res = new ArrayList<>();
        res.add("");
        for (int i = 0; i < s.length(); i++) {
            int size = res.size();
            if (Character.isLetter(s.charAt(i))) {
                for (int j = 0; j < size; j++) {
                    String curr = res.get(j);
                    res.set(j, curr + Character.toUpperCase(s.charAt(i)));
                    res.add(curr + Character.toLowerCase(s.charAt(i)));
                }
            } else {
                for (int j = 0; j < res.size(); j++) {
                    res.set(j, res.get(j) + s.charAt(i));
                }
            }
        }
        return res;
    }
}
