package leetcode;

public class leet696 {
    public static void main(String[] args) {
        String s = "00011100";
        System.out.println(countBinarySubstrings(s));
    }

    public static int countBinarySubstrings(String s) {
        //count consecutive zeros and ones
        //stop when encountered the first number again
        //Eg: "00011100" --> [3 zeroes, 3 ones, 2 zeroes] --> [3,3,2] --> Ans = min(3,3) + min(3,2) = 5 Total Substrings
//        ArrayList<Integer> count = new ArrayList<>();
//        int c = 1;
//        for (int i = 0; i < s.length() - 1; i++) {
//            if (s.charAt(i) == s.charAt(i + 1)) {
//                c++;
//            } else {
//                count.add(c);
//                c = 1;
//            }
//        }
//        count.add(c);
//        int ans = 0;
//        for (int i = 0; i < count.size() - 1; i++) {
//            ans += Math.min(count.get(i), count.get(i + 1));
//        }
//        return ans;
        int res = 0, prev = 0, strk = 1;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                strk++;
            } else {
                prev = strk;
                strk = 1;
            }
            if (strk <= prev) {
                res++;
            }
        }
        return res;
    }
}
