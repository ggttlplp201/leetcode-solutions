package leetcode;

import java.util.ArrayList;
import java.util.Arrays;

public class leet1984 {
    public static void main(String[] args) {
        int[] nums = {87063, 61094, 44530, 21297, 95857, 93551, 9918};
        System.out.println(minimumDifference(nums, 6));
    }

    public static int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - k + 1; i++) {
            int diff = nums[i + k - 1] - nums[i];
            if (diff < minDiff) {
                minDiff = diff;
            }
//            for (int j = 1; j < k; j++) {
//                diff = nums[i + j] - nums[i + j - 1];
//                if (diff < minDiff) {
//                    minDiff = diff;
//                }
//            }
        }
        return minDiff;
    }
}
