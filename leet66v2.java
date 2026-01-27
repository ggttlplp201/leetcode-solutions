package leetcode;

import java.util.Arrays;

public class leet66v2 {
    public static void main(String[] args) {
        int[] digits = {2, 9, 9};
        System.out.println(Arrays.toString(plusOne(digits)));
    }

    public static int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;      // carry resolved here
                return digits;
            }
            digits[i] = 0;        // digit was 9, keep carrying
        }

        // if we got here, it was all 9s (e.g., 9, 99, 999...)
        int[] res = new int[digits.length + 1];
        res[0] = 1;
        return res;
    }

}
