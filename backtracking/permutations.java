package leetcode.backtracking;

import java.util.*;

public class permutations {
    public static void main(String[] args) {
        System.out.println(permute(new int[]{1, 2, 3}));
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        backtrack(curr, res, nums);
        return res;
    }

    public static void backtrack(List<Integer> curr, List<List<Integer>> res, int[] nums) {
        if (curr.size() == nums.length) {
            res.add(new ArrayList<>(curr));
            return;
        }
        for (int num : nums) { //only add unique numbers
            if (curr.contains(num)) {
                continue;
            }
            curr.add(num);
            backtrack(curr, res, nums);
            curr.removeLast();
        }
    }
}
