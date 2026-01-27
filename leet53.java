package leetcode;

public class leet53 {
    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(nums));
    }

    public static int maxSubArray(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int largest = nums[0];
        int curr = nums[0];
        for (int i = 1; i < nums.length; i++) {
            curr = Math.max(nums[i], curr + nums[i]);
            largest = Math.max(largest, curr);
        }
        return largest;
    }
}


//        while (iteration < nums.length) {
//            for (int i = iteration; i < nums.length; i++) {
//                sum += nums[i];
//                if (sum > largest) {
//                    largest = sum;
//                }
//            }
//            sum = 0;
//            iteration++;
//        }