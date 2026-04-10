package leetcode;

import java.util.*;

public class leet39 {
    public static void main(String[] args) {
        System.out.println(combinationSum(new int[]{2, 3, 6, 7}, 7));
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        backtrack(res, curr, candidates, target, 0);
        return res;
    }

    public static void backtrack(List<List<Integer>> res, List<Integer> curr, int[] candidates, int target, int start) {
        if (getSum(curr) == target) {
            res.add(new ArrayList<>(curr));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (getSum(curr) + candidates[i] > target) {
                continue;
            }
            curr.add(candidates[i]);
            backtrack(res, curr, candidates, target, i);
            curr.removeLast();
        }
    }

    public static int getSum(List<Integer> curr) {
        int sum = 0;
        for (int i : curr) {
            sum += i;
        }
        return sum;
    }
}
