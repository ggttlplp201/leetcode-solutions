package leetcode;

import java.util.Arrays;

public class removeElement {
    public static void main(String[] args) {
        int[] nums = {3, 2, 2, 3};
        int[] nums2 = {0, 1, 2, 2, 3, 0, 4, 2};
        int val = 3;
        System.out.println(remove(nums, val));
    }

    public static int remove(int[] nums, int val) {
        int k = 0;
        for (int num : nums) {
            if (num == val) {
                k++;
            }
        }
        //edge case
        boolean edge = true;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                edge = false;
                break;
            }
        }
        if (edge) {
            return 0;
        }

        int left = 0;
        int right = nums.length - 1;
        int toSwap;
        while (left < right) {
            while (nums[right] == val) {
                right--;
            }
            toSwap = nums[right];
            if (nums[left] == val) {
                nums[right] = nums[left];
                nums[left] = toSwap;
            } else {
                left++;
            }
            if (nums[left] == val && nums[right] == val) {
                right--;
            }
        }

        return nums.length - k;
    }
}
