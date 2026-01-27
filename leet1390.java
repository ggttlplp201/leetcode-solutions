package leetcode;

public class leet1390 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        System.out.println(sumFourDivisors(nums));

    }

    public static int sumFourDivisors(int[] nums) {

        //every number has at least 2 divisors (1 and itself)
        int sum = 0;
        int temp = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j * j <= nums[i]; j++) {
                if (nums[i] % j == 0) {
                    if (j != nums[i] / j) {
                        temp += j;
                        temp += nums[i] / j;
                        count += 2;
                    } else {
                        temp += j;
                        count++;
                    }
                }
                if (count > 4) {
                    break;
                }
            }
            if (count == 4) {
                sum += temp;
            }
            temp = 0;
            count = 0;
        }
        return sum;
    }
}
