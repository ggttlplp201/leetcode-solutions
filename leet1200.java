package leetcode;

import java.util.*;


public class leet1200 {
    public static void main(String[] args) {
        int[] arr = {40, 11, 26, 27, -20};
        System.out.println(minimumAbsDifference(arr));
    }

    public static List<List<Integer>> minimumAbsDifference(int[] arr) {
        //sort and find min difference
        //mark index whose diff is min diff
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(arr);
        int minDiff = Integer.MAX_VALUE;
        for (int i = 1; i < arr.length; i++) {
            int diff = Math.abs(arr[i] - arr[i - 1]);
            if (diff < minDiff) {
                minDiff = diff;
            }
            if (diff == minDiff) {
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(arr[i - 1]);
                temp.add(arr[i]);
                ans.add(temp);
            }
        }
        for (int i = 0; i < ans.size(); i++) {
            if (Math.abs(ans.get(i).get(1) - ans.get(i).get(0)) != minDiff) {
                ans.remove(i);
                i--;
            }
        }
        return ans;
    }
}
