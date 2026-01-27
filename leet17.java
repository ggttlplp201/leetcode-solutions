package leetcode;

import java.util.*;

public class leet17 {
    public static void main(String[] args) {
        String digits = "234";
        System.out.println(letterCombinations(digits));
    }

    public static List<String> letterCombinations(String digits) {

        Map<Character, String> phone = new HashMap<>();
        phone.put('2', "abc");
        phone.put('3', "def");
        phone.put('4', "ghi");
        phone.put('5', "jkl");
        phone.put('6', "mno");
        phone.put('7', "pqrs");
        phone.put('8', "tuv");
        phone.put('9', "wxyz");

        List<String> ans = new ArrayList<>();
        ans.add("");

        for (int i = 0; i < digits.length(); i++) {
            char digit = digits.charAt(i); //3
            String letters = phone.get(digit); //def
            List<String> next = new ArrayList<>();
            for (int j = 0; j < ans.size(); j++) {
                String prefix = ans.get(j); //a, b, c
                for (int k = 0; k < letters.length(); k++) {
                    next.add(prefix + letters.charAt(k)); //ad ae af, bd, be, bf, cd, ce, cf
                }
            }
            ans = next;
        }
        return ans;
    }
}
