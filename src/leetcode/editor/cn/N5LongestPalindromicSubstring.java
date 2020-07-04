//给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。 
//
// 示例 1： 
//
// 输入: "babad"
//输出: "bab"
//注意: "aba" 也是一个有效答案。
// 
//
// 示例 2： 
//
// 输入: "cbbd"
//输出: "bb"
// 
// Related Topics 字符串 动态规划


package leetcode.editor.cn;

public class N5LongestPalindromicSubstring {
    public static void main(String[] args) {
        Solution solution = new N5LongestPalindromicSubstring().new Solution();
//        System.out.println(solution.findPalindrome("poiabcbatyu", 5, 5));
//        System.out.println(solution.findPalindrome("aaa", 1, 1));
        System.out.println(solution.longestPalindrome("poiabcbatyu"));
        System.out.println(solution.longestPalindrome("aaaa"));
        System.out.println(solution.longestPalindrome("a"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //动态规划法不如中心点扩展法
        public String longestPalindrome(String s) {
//            if (s == null || s.length() == 1) {//无法通过"" 用例
            if (s == null || s.length() <= 1) {
                return s; //否则无法通过"" 用例
            }

            int len = s.length();
            boolean[][] flag = new boolean[len][len];
            int left = 0;
            int right = 0;
//            for (int i = 0; i < len - 1; i++) { flag[i + 1][j - 1]决定了必须从后往前，在使用i之前i+1必须先确定
            for (int i = len - 2; i >= 0; i--) {
                flag[i][i] = true;
                for (int j = i + 1; j < len; j++) {
                    flag[i][j] = (s.charAt(i) == s.charAt(j)) && ((j - i <= 2) || flag[i + 1][j - 1]);
                    if (flag[i][j] && (j - i > right - left)) {
                        left = i;
                        right = j;
                    }
                }
            }
            return s.substring(left, right + 1); //
//           无法通过“a” 用例 String maxLen = "";
//            for (int i = 0; i < len - 1; i++) {
//                flag[i][i] = true;
//                for (int j = i + 1; j < len; j++) {
//                    flag[i][j] = (s.charAt(i) == s.charAt(j)) && ((j - i <= 2) || flag[i + 1][j - 1]);
//                    if (flag[i][j] && (j - i > maxLen.length())) {
//                        maxLen = s.substring(i, j + 1);
//                    }
//                }
//            }
//            return maxLen;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)


//    public String longestPalindrome(String s) {
//        String maxLen = "";
////            for (int i = 0; i < s.length() - 1 这会导致单个字母用例不通过; i++)
//        for (int i = 0; i < s.length(); i++) {
//            String ps = findPalindrome(s, i, i + 1);
//            if (ps.length() > maxLen.length()) {
//                maxLen = ps;
//            }
//            ps = findPalindrome(s, i, i);
//            if (ps.length() > maxLen.length()) {
//                maxLen = ps;
//            }
//        }
//        return maxLen;
//    }
//
//    public String findPalindrome(String s, int left, int right) {
//        int i = left;
//        int j = right;
////            //会越界while (s.charAt(i) == s.charAt(j) && i >= 0 && j < s.length()) {
//        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
//            i--;
//            j++;
//        }
//        return s.substring(i + 1, j);
//    }
}