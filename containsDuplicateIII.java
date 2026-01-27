package leetcode;

import java.util.*;

public class containsDuplicateIII {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        int indexDiff = 3;
        int valueDiff = 0;
        System.out.println(containsNearbyAlmostDuplicate(nums, indexDiff, valueDiff));
    }

    public static boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        Set<Integer> window = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            window.add(nums[i]);
            if (i >= indexDiff) {
                window.remove(nums[i - indexDiff]);
            }
        }
        return false;
    }
}
