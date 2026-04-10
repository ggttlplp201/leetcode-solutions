package leetcode;

import java.util.*;

public class leet77 {
    public static void main(String[] args) {
        System.out.println(combine(4, 2));
    }

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> currList = new ArrayList<>();
        backtrack(1, currList, res, n, k);
        return res;
    }

    public static void backtrack(int start, List<Integer> currList, List<List<Integer>> res, int n, int k) {
        if (currList.size() == k) {
            res.add(new ArrayList<>(currList));
            return;
        }
        for (int i = start; i <= n; i++) {
            currList.add(i);
            backtrack(i + 1, currList, res, n, k);
            currList.removeLast();
        }
    }
}
