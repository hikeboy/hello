package tencent50;

//最长回文子串
public class L5LongestPalindrome {

    /**
     * @param s
     * @return
     */
    public static String longestPalindrome(String s) {
        if (s == null && s.length() <= 1) {
            return s;
        }
        String longest = "";
        for (int i = 0; i < s.length() - 1; i++) {
            String str = findPalindrome(s, i, i);
            if (str.length() > longest.length()) {
                longest = str;
            }
            str = findPalindrome(s, i, i + 1);
            if (str.length() > longest.length()) {
                longest = str;
            }
        }
        return longest;
    }

    public static String findPalindrome(String s, int left, int right) {
        int l = left;
        int r = right;
        while (l >= 0 && r <= s.length() - 1 && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return s.substring(l + 1, r);
    }

    //动态规划法
    public static String longestPalindrome2(String s) {
        if (s == null || s.length() == 1) {
            return s;
        }
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int left = 0;
        int right = 0;
        for (int i = n - 2; i >= 0; i--) {
            dp[i][i] = true;
            for (int j = i + 1; j < n; j++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i + 1][j - 1]);
                if (dp[i][j] && right - left < j - i) {
                    left = i;
                    right = j;
                }
            }
        }
        return s.substring(left, right + 1);
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome2("babad").equals("aba"));
        System.out.println(longestPalindrome2("cbbd").equals("bb"));
        System.out.println(longestPalindrome2("cbabcddcba"));
        System.out.println(longestPalindrome2("cbabcddcba"));
        System.out.println(longestPalindrome2("cbabcdcba").equals("abcdcba"));
        System.out.println(longestPalindrome2("cbabcddcba").equals("abcddcba"));

    }
}
