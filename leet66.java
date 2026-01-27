package leetcode;

import java.util.Arrays;

public class leet66 {
    public static void main(String[] args) {
        int[] digits = {2, 4, 9, 3, 9};
        System.out.println(Arrays.toString(plusOne(digits)));
    }

    public static int[] plusOne(int[] digits) {
        //find last digit
        //if last digit is 9, make it 0 and increment previous by 1, if previous digit doesn't exist, create one
        //move on to second last digit
        //repeat process until digit is not 9
        //399
        //9 99 199
        if (digits.length == 1 && digits[0] == 9) {
            return new int[]{1, 0};
        }
        boolean originalNine = true;
        boolean a = true;
        boolean added = false;
        for (int i = digits.length - 1; i >= 0; i--) {
            int currDigit = digits[i];
            if (currDigit == 9) {
                a = false;
                digits[i] = 0;
                digits[i - 1]++;
                if (digits[i - 1] == 9) {
                    originalNine = false;
                }
                if (!originalNine) {
                    break;
                }
            } else if (currDigit == 10) {
                if (i == 0) {
                    int[] res = new int[digits.length + 1];
                    res[0] = 1;
                    return res;
                } else {
                    digits[i] = 0;
                    digits[i - 1]++;
                    if (digits[i - 1] == 9) {
                        originalNine = false;
                    }
                    if (!originalNine) {
                        break;
                    }
                }
            }
            if (a) {
                digits[digits.length - 1]++;
                return digits;
            }
        }
        return digits;
    }
}
