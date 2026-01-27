//package leetcode;
//
//import java.util.*;
//
//public class shiftLetter {
//    public static void main(String[] args) {
//        System.out.println(shiftingLetters("bad", new int[]{10, 20, 30}));
//    }
//
//    public static String shiftingLetters(String s, int[] shifts) {
//        String res = "";
//        char[] temp = new char[s.length()];
//        for (int i = 0; i < temp.length; i++) {
//            temp[i] = s.charAt(i);
//        }
//        int cnt = 1;
//        for (int i = 0; i < shifts.length; i++) {
//            for (int j = 0; j < cnt; j++) {
//                int toShift = shifts[i]; //3
//                if (toShift + temp[j] > 122) {
//                    int toAdd = 122 - temp[j];
//                    temp[j] = (char) (97 + toAdd);
//                } else {
//                    temp[j] += (char) toShift;
//                }
//                res = String.valueOf(temp);
//            }
//            cnt++;
//        }
//        return res;
//        int[] num = new int[shifts.length];
//        for (int i = shifts.length; i > 0; i--) {
//            nums[i] =
//        }
//    }
//}
