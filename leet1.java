package leetcode;

import java.util.Arrays;

public class leet1 {
    static void main(String[] args) {

    }

    public int[] twoSum(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int[] temp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            temp[i] = nums[i];
        }
        Arrays.sort(nums);
        int[] ans = new int[2];
        while (left < right) {
            if (nums[left] + nums[right] < target) {
                left++;
            }
            if (nums[left] + nums[right] > target) {
                right--;
            }
            if (nums[left] + nums[right] == target) {
                break;
            }
        }
        int leftValue = nums[left];
        int rightValue = nums[right];
        for (int i = 0; i < temp.length; i++) {
            if (temp[i] == leftValue) {
                ans[0] = i;
                break;
            }

        }
        for (int i = temp.length - 1; i >= 0; i--) {
            if (temp[i] == rightValue) {
                ans[1] = i;
                break;
            }
        }
        return ans;
    }
}
