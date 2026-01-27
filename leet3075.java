package leetcode;

import java.util.Arrays;
import java.util.Collections;

public class leet3075 {
    public static void main(String[] args) {
        int[] happiness = {12, 1, 42};
        int k = 3;
        System.out.println(maximumHappinessSum(happiness, k));
    }

    public static long maximumHappinessSum(int[] happiness, int k) {
        //greedy to select biggest
        Arrays.sort(happiness);
        //1, 12 ,42
        long total = 0;
        int toReduce = 0;
        for (int i = 0; i < k; i++) {
            if (happiness[happiness.length - 1 - toReduce] - toReduce < 0) {
                total += 0;
            } else {
                total += happiness[happiness.length - 1 - toReduce] - toReduce;
                toReduce++;
            }
        }
        return total;
    }
}

