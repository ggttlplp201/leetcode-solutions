package leetcode;

import java.util.Arrays;

public class leet34 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 3, 3, 3, 4, 5, 9};
        int target = 3;
        System.out.println(Arrays.toString(searchRange(nums, target)));
    }

    public static int[] searchRange(int[] nums, int target) {
        int left = findLeft(nums, target);
        if (left == -1) return new int[]{-1, -1};

        int right = findRight(nums, target);
        return new int[]{left, right};
    }


    private static int findLeft(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int ans = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] >= target) {
                if (nums[mid] == target) {
                    ans = mid;
                }
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return ans;
    }

    private static int findRight(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int ans = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= target) {
                if (nums[mid] == target) {
                    ans = mid;
                }
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return ans;
    }
}
