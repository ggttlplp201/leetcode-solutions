package leetcode;

public class containerWithMostWater {
    public static void main(String[] args) {
        //2pointer找最大值，动最小边
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int[] height2 = {1, 1};
        System.out.println(maxArea(height2));
    }

    public static int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;
        while (left < right) {
            int len = right - left;
            if (height[right] > height[left]) {
                int area = height[left] * len;
                if (area > maxArea) {
                    maxArea = area;
                }
                left++;
            } else if (height[left] > height[right]) {
                int area = height[right] * len;
                if (area > maxArea) {
                    maxArea = area;
                }
                right--;
            } else {
                int area = height[right] * len;
                if (area > maxArea) {
                    maxArea = area;
                }
                left++;
                right--;
            }
        }
        return maxArea;
    }
}
