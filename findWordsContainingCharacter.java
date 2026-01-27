package leetcode;

import java.util.*;

public class findWordsContainingCharacter {
    public static void main(String[] args) {
        String[] words = {"leet", "code"};
        System.out.println(findWordsContaining(words, 'e'));

    }

    public static List<Integer> findWordsContaining(String[] words, char x) {
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            if (words[i].indexOf(x) != -1) {
                res.add(i);
            }
        }
        return res;
    }
}
