package leetcode.arrays;

import java.util.Arrays;

public class findPrefixCommonArray {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(findThePrefixCommonArray(new int[]{2, 3, 1}, new int[]{3, 1, 2})));
    }

    public static int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int[] C = new int[n];
        int[] freq = new int[n + 1];

        for (int i = 0; i < n; i++) {
            freq[A[i]]++;
            freq[B[i]]++;
            int temp = 0;
            for (int j = 0; j < freq.length; j++) {
                if (freq[j] == 2) {
                    temp++;
                }
            }
            C[i] += temp;
        }
        return C;
    }
}
