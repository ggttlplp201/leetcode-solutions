package leetcode;

import java.util.Arrays;
import java.util.Collections;

public class leet3074 {
    public static void main(String[] args) {
        int[] apple = {5, 5, 5};
        int[] capacity = {2, 4, 2, 7};
        System.out.println(minimumBoxes(apple, capacity));
        //capacity: [1,2,3,4,5]
        //appleSum: 6
    }


    public static int minimumBoxes(int[] apple, int[] capacity) {
        //sort capacity array descending order
        //get sum of apples
        //start subtracting, if 0, move on to next element and count++
        int count = 1;
        int appleSum = 0;
        Arrays.sort(capacity);
        for (int i = 0; i < apple.length; i++) {
            appleSum += apple[i];
        }
        for (int i = capacity.length - 1; i >= 0; i--) {
            appleSum -= capacity[i];
            if (appleSum > 0) {
                count++;
            } else {
                break;
            }
        }
        return count;
    }
}
