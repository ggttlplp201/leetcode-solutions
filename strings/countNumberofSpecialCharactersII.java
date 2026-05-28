package leetcode.strings;

public class countNumberofSpecialCharactersII {
    public static void main(String[] args) {
        System.out.println(numberOfSpecialChars("eEb"));
    }

    public static int numberOfSpecialChars(String word) {
        //store first occurance of upper case and last occurance of lower case and compare
        //if index of upper case > lower case, then count++

        int[] upper = new int[26];
        int[] lower = new int[26];
        char[] w = word.toCharArray();

        for (int i = 0; i < w.length; i++) {
            if (Character.isUpperCase(w[i]) && upper[w[i] - 'A'] == 0) {
                upper[w[i] - 'A'] = i + 1;
            } else if (Character.isLowerCase(w[i]) && lower[w[i] - 'a'] <= i) {
                lower[w[i] - 'a'] = i + 1;
            }
        }
        int count = 0;
        for (int i = 0; i < upper.length; i++) {
            if (upper[i] != 0 && lower[i] != 0) {
                if (lower[i] < upper[i]) {
                    count++;
                }
            }
        }
        return count;
    }
}
