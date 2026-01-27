package leetcode;

import java.util.Arrays;

public class zeroArrayTransformation {
    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 1};
        int[][] queries = {{1, 3}, {0, 2}};
        System.out.println(isZeroArray(nums, queries));
    }

    public static boolean isZeroArray(int[] nums, int[][] queries) {
        int[] diff = new int[nums.length];
        for (int[] q : queries) {
            int l = q[0];
            int r = q[1];
            diff[l]++;
            if (r + 1 < nums.length) {
                diff[r + 1]--;
            }
        }
        int count = 0;
        for (int i = 0; i < diff.length; i++) {
            count += diff[i];
            if (nums[i] > count) {
                return false;
            }
        }
        return true;
    }
}

