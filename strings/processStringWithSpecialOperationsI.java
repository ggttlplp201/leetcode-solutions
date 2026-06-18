package leetcode.strings;

import java.util.*;

public class processStringWithSpecialOperationsI {
    public static void main(String[] args) {

    }

    public String processStr(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (Character.isLetter(curr) && Character.isLowerCase(curr)) {
                sb.append(curr);
            } else if (curr == '*') {
                if (!sb.isEmpty()) {
                    sb.deleteCharAt(sb.length() - 1);
                }
            } else if (curr == '#') {
                sb.append(sb);
            } else if (curr == '%') {
                sb.reverse();
            }
        }
        return sb.toString();
    }
}
