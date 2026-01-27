package leetcode;

public class jumpGameII {
    public static void main(String[] args) {
        int[] nums = {2, 0, 2, 0, 1};
        int[] nums2 = {2, 5, 0, 0};
        System.out.println(jump(nums));
    }

    public static boolean jump(int[] nums) {
        int i = 0;
        int range;
        int maxJump;
        int nextIndex = 0;

        if (nums.length == 1) {
            return true;
        }

        while (i < nums.length - 1) {
            range = nums[i];
            maxJump = 0;
            // If current index can reach or exceed the end
            if (i + range >= nums.length - 1) {
                return true;
            }
            // Find the best next index within reachable range
            for (int j = 1; j <= range; j++) {
                int reach = i + j + nums[i + j]; // total reach from index i+j
                if (reach > maxJump) {
                    maxJump = reach;
                    nextIndex = i + j;
                }
            }
            if (nextIndex == i) {
                return false;
            }
            i = nextIndex;
        }
        return true;

    }
}
