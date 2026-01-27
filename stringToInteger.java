package leetcode;

import java.util.*;

public class stringToInteger {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.next();
        System.out.println(myAtoi(str));
    }

    public static int myAtoi(String s) {
        StringBuilder sb = new StringBuilder();
        boolean neg = false;
        boolean hasRun = false;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(0) == '-' && !hasRun) {
                neg = true;
                hasRun = true;
                continue;
            }
            if (!Character.isDigit(s.charAt(i))) {
                break;
            }
            if (Character.isDigit(s.charAt(i))) {
                sb.append(s.charAt(i));
            }
        }
        if (sb.isEmpty()) {
            sb.append(0);
        }
        int temp = Integer.parseInt(String.valueOf(sb));
        if (neg) {
            temp = -temp;
        }

        return temp;
    }
}
