package leetcode.simulation;

public class twoFurthestHouses {
    public static void main(String[] args) {
        int[] colors = {1, 8, 3, 8, 3};
        System.out.println(maxDistance(colors));
    }

    public static int maxDistance(int[] colors) {
        int dist1 = 0;
        int left = 0;
        int right = colors.length - 1;
        for (int i = right; i >= 0; i--) {
            if (colors[i] != colors[left]) {
                dist1 = i;
                break;
            }
        }
        int dist2 = 0;
        for (int i = 0; i < colors.length; i++) {
            if (colors[i] != colors[right]) {
                dist2 = right - i;
                break;
            }
        }
        return Math.max(dist1, dist2);
    }
}
