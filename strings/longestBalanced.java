package leetcode.strings;

public class longestBalanced {
    public static void main() {

    }

    class Solution {
        public int longestBalanced(String s) {
            int n = s.length();
            int ans = 1;

            for (int i = 0; i < n; i++) {
                int[] freq = new int[26];

                for (int j = i; j < n; j++) {
                    int index = s.charAt(j) - 'a';
                    freq[index]++;

                    int smallest = Integer.MAX_VALUE;
                    int largest = 0;
                    int distinct = 0;

                    for (int c : freq) {
                        if (c > 0) {
                            distinct++;
                            smallest = Math.min(smallest, c);
                            largest = Math.max(largest, c);
                        }
                    }

                    int length = j - i + 1;

                    if (distinct > 0 && smallest == largest) {
                        ans = Math.max(ans, length);
                    }
                }
            }

            return ans;
        }
    }
}
