package leetcode.greedy;

import java.util.Arrays;

public class dividingArrayMinCost {
    public static void main(String[] args) {

    }

    public static int minimumCost(int[] nums) {
        int cost = nums[0];
        Arrays.sort(nums, 1, nums.length);
        cost += nums[1];
        cost += nums[2];
        return cost;
    }
}
