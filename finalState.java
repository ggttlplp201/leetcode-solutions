package leetcode;

import java.util.*;

public class finalState {

    public static void main(String[] args) {
        int[] nums = {2, 1, 3, 5, 6};
        System.out.println(Arrays.toString(getFinalState(nums, 5, 2)));
    }

    public static int[] getFinalState(int[] nums, int k, int multiplier) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(
                Comparator.comparingInt((Pair p) -> p.value)
                        .thenComparingInt(p -> p.index)
        );
        for (int i = 0; i < nums.length; i++) {
            pq.add(new Pair(i, nums[i]));
        }
        for (int i = 0; i < k; i++) {
            Pair p = pq.poll();
            int newValue = p.value * multiplier;
            pq.add(new Pair(p.index, newValue));
        }
        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            nums[p.index] = p.value;
        }
        return nums;
    }

    static class Pair {
        int index;
        int value;

        Pair(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }
}
