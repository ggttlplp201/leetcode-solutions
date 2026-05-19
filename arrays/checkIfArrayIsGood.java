package leetcode.arrays;

import java.util.Arrays;
import java.util.Collections;

public class checkIfArrayIsGood {
    public static void main(String[] args) {
        System.out.println(isGood(new int[]{2, 2}));
    }

    public static boolean isGood(int[] nums) {
        Arrays.sort(nums);
        int max = nums[nums.length - 1];
        if (nums.length > max + 1) {
            return false;
        }
        int num = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] != num) {
                return false;
            }
            num++;
        }
        if (nums.length > 1) {
            return nums[nums.length - 1] == max && nums[nums.length - 2] == max;
        }
        return false;
    }
}
