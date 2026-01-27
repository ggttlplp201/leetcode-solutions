package leetcode;

import java.util.Stack;

public class validParenthesis {
    public static void main(String[] args) {
        String s = "[][]()()";
        System.out.println(isValid(s));
    }

    public static boolean isValid(String s) {
        Stack<Character> p = new Stack<>();

        //stack: (([[
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                p.push(s.charAt(i));
            } else {
                if (p.isEmpty()) {
                    return false;
                }
                char temp = p.peek();
                if (s.charAt(i) == ')') {
                    if (temp != '(') {
                        return false;
                    } else {
                        p.pop();
                    }
                } else if (s.charAt(i) == '}') {
                    if (temp != '{') {
                        return false;
                    } else {
                        p.pop();
                    }
                } else if (s.charAt(i) == ']') {
                    if (temp != '[') {
                        return false;
                    } else {
                        p.pop();
                    }
                }

            }
        }
        return p.isEmpty();
    }
}