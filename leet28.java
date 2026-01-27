package leetcode;

public class leet28 {
    public static void main(String[] args) {
        String haystack = "abc";
        String needle = "c";
        System.out.println(strStr(haystack, needle));
    }

    public static int strStr(String haystack, String needle) {
        if (haystack.equals(needle)) {
            return 0;
        }
        int len = needle.length();
        for (int i = 0; i < haystack.length() - len + 1; i++) {
            String curr = haystack.substring(i, i + len);
            if (curr.equals(needle)) {
                return i;
            }
        }
        return -1;
    }
}
