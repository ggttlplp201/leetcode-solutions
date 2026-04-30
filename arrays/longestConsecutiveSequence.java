package leetcode.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class longestConsecutiveSequence {
    public static void main(String[] args) {
        int[] nums = {1, 0, 1, 2};
        System.out.println(longestConsecutive(nums));
    }

    public static int longestConsecutive(int[] nums) {
        //add everything to set
        //iterate through array
        //check if nums[i] - 1 is in set, if not, then it is the start of the sequence
        //start counting forward
        if (nums.length == 0) {
            return 0;
        }
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        //find head of sequence
        //nums = [100,4,200,1,3,2]
        int head;
        int maxSeq = 0;
        for (int num : set) {
            int seqLength = 1;
            if (!set.contains(num - 1)) {//is head
                head = num;
            } else {
                continue;
            }
            while (set.contains(head + 1)) {
                head += 1;
                seqLength++;
            }
            if (seqLength > maxSeq) {
                maxSeq = seqLength;
            }
        }
        return maxSeq;
    }
}
