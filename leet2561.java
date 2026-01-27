package leetcode;

public class leet2561 {
    public static void main(String[] args) {
        int[] basket1 = {2, 3, 4, 1};
        int[] basket2 = {3, 2, 5, 1};
        System.out.println(minCost(basket1, basket2));
    }

    public static long minCost(int[] basket1, int[] basket2) {
        //if basket1 sum + basket2 sum = odd, then return -1
        //else if even, find the average -> target of each basket
        //find the difference between basket sum and target
        //e.g. -> [4,1,2,2], [1,4,1,2], target = 9, difference in basket1 = -1, in basket2 = 1
        //nested for-loop, loop toSwap -> original basket sum + cost @ index - cost@ swapIndex
        int len = basket1.length;
        long cost = 0;
        int sum1 = 0;
        int sum2 = 0;
        for (int i = 0; i < len; i++) {
            sum1 += basket1[i];
            sum2 += basket2[i];
        }
        if ((sum1 + sum2) % 2 != 0) {
            return -1;
        } else {
            int target = (sum1 + sum2) / 2;
            int diff1 = target - sum1; //-1
            int diff2 = target - sum2; //1
            for (int i = 0; i < len; i++) { // basket2
                for (int j = 0; j < len; j++) { //basket1
                    if (basket2[i] - basket1[j] == diff1) {
                        cost = Math.min(basket1[i], basket2[j]);
                        return cost;
                    }
                }
            }
            return cost;
        }
        //try to make 2 basket have identical elements?
    }
}
