package leetcode;

import com.sun.security.jgss.GSSUtil;

import java.util.ArrayList;
import java.util.Arrays;

public class leet961 {
    public static void main(String[] args) {
        int[] nums = {9, 5, 3, 3};
        System.out.println(repeatedNTimes(nums));

    }

    public static int repeatedNTimes(int[] nums) {
        //sort
        //1,2,3,4,5,5,5,5
        //check if current number nums[n] is the same, if not, move on to the next number
        Arrays.sort(nums);
        int n = nums.length / 2;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == nums[i + n - 1]) {
                return nums[i];
            }
        }
        return 1;
    }
}
