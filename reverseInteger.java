package leetcode;

public class reverseInteger {
    public static void main(String[] args) {
        int x = -2147483648;
        System.out.println(reverse(x));

    }

    public static int reverse(int x) {
        StringBuilder sb = new StringBuilder();
        String num = String.valueOf(x);
        boolean isNeg = false;
        for (int i = num.length() - 1; i >= 0; i--) {
            if (num.charAt(i) == '-') {
                isNeg = true;
                continue;
            }
            sb.append(num.charAt(i));
        }

        String temp = String.valueOf(Integer.MAX_VALUE);
        //2147483647
        //8463847412
        char[] arr = temp.toCharArray();
        boolean tooBig = false;

        if (sb.length() >= 10) {
            for (int i = 0; i < arr.length; i++) {
                if (sb.charAt(i) > arr[i]) {
                    tooBig = true;
                    break;
                }
                if (sb.charAt(i) < arr[i]) {
                    break;
                }
            }
        }
        if (tooBig) {
            return 0;
        }
        int res = Integer.parseInt(String.valueOf(sb));
        if (isNeg) {
            return -res;
        }
        return res;
    }
}
