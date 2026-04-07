package leetcode;

public class leet162 {
    public static void main(String[] args) {
        System.out.println(findPeakElement(new int[]{1, 2}));
    }

    public static int findPeakElement(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        if (nums.length == 1) {
            return 0;
        }
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (mid == 0) {
                if (nums[mid] > nums[mid + 1]) {
                    return mid;
                }
                low = mid + 1;
            } else if (mid == nums.length - 1) {
                if (nums[mid] > nums[mid - 1]) {
                    return mid;
                }
                high = mid - 1;
            } else {
                if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
                    return mid;
                }
                if (nums[mid + 1] > nums[mid - 1]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
}