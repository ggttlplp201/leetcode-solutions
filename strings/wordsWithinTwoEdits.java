package leetcode.strings;

import java.lang.reflect.Array;
import java.util.*;

public class wordsWithinTwoEdits {
    public static void main(String[] args) {
        String[] queries = {"word", "note", "ants", "wood"};
        String[] dictionary = {"wood", "joke", "moat"};
        System.out.println(twoEditWords(queries, dictionary));
    }

    public static List<String> twoEditWords(String[] queries, String[] dictionary) {
        ArrayList<String> res = new ArrayList<>();
        for (int i = 0; i < queries.length; i++) {
            String curr = queries[i];
            for (int j = 0; j < dictionary.length; j++) {
                String currDict = dictionary[j];
//                if (currDict.equals(curr)) {
//                    res.add(currDict);
//                    continue;
//                }
                int diffBy = 0;
                int k = 0;
                int l = 0;
                while (k < curr.length() && l < currDict.length()) {
                    if (curr.charAt(k) != currDict.charAt(l)) {
                        diffBy++;
                        if (diffBy > 2) {
                            break;
                        }
                    }
                    k++;
                    l++;
                }
                if (diffBy <= 2) {
                    if (!res.contains(curr)) {
                        res.add(curr);
                    }
                }
            }
        }
        return res;
    }
}
