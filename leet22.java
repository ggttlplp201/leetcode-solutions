package leetcode;

import java.util.*;

public class leet22 {
    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }

    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        List<String> curr = new ArrayList<>();
        backtrack(res, curr, n, 0, 0);
        return res;
    }

    public static void backtrack(List<String> res, List<String> curr, int n, int openCount, int closeCount) {
        if (openCount == closeCount && openCount == n) {
            res.add(String.join("", curr));
            return;
        }
        if (openCount < n) {
            curr.add("(");
            backtrack(res, curr, n, openCount + 1, closeCount);
            curr.removeLast();
        }
        if (closeCount < openCount) {
            curr.add(")");
            backtrack(res, curr, n, openCount, closeCount + 1);
            curr.removeLast();
        }
    }
}
