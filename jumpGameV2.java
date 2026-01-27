package leetcode;

public class jumpGameV2 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 1, 1, 1};
        System.out.println(jump(nums));
    }

    public static int jump(int[] nums) {
        int range;
        int index = 0;
        int count = 0;
        int max = 0;
        int[] numsCopy = nums;
        while (index < nums.length - 1) {
            range = nums[index];
            count++;
            if (index + range >= nums.length - 1) {
                break;
            }

            for (int i = 1; i < range + 1; i++) { //2 0 2 0 1
                int curr = nums[index + i];
                if (curr > max) {
                    max = curr;
                    index = findIndex(numsCopy, max, index);
                } else if (curr == max) {
                    index++;
                } else {
                    index = index + range;
                }
            }
        }
        return count;
    }


    public static int findIndex(int[] numsCopy, int max, int index) {
        //2 3 1 1 4
        for (int i = index + 1; i < numsCopy.length; i++) {
            if (numsCopy[i] == max) {
                return i;
            }
        }
        return -1;
    }
}
