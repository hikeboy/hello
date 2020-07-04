//编写一个函数来查找字符串数组中的最长公共前缀。 
//
// 如果不存在公共前缀，返回空字符串 ""。 
//
// 示例 1: 
//
// 输入: ["flower","flow","flight"]
//输出: "fl"
// 
//
// 示例 2: 
//
// 输入: ["dog","racecar","car"]
//输出: ""
//解释: 输入不存在公共前缀。
// 
//
// 说明: 
//
// 所有输入只包含小写字母 a-z 。 
// Related Topics 字符串


package leetcode.editor.cn;

public class N14LongestCommonPrefix {
    public static void main(String[] args) {
        Solution solution = new N14LongestCommonPrefix().new Solution();
        String[] str = new String[]{"flower", "flow", "flight"};
        System.out.println(solution.longestCommonPrefix(str));
        str = new String[]{"flower", "a", "flight"};
        System.out.println(solution.longestCommonPrefix(str));
        str = new String[]{""};
        System.out.println(solution.longestCommonPrefix(str));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestCommonPrefix(String[] strs) {
            if (strs == null || strs.length == 0) {
                return "";
            }
            int i = 0;
            while (true) {//无法通过{""} 用例
                int j = 0;
                for (; j < strs.length - 1; j++) {
                    if (strs[j].equals("") || strs[j + 1].equals("")) {
                        return "";
                    }
                    if (strs[j].length() < i + 1) {
                        return strs[j];
                    }
                    if (strs[j + 1].charAt(i) != strs[j].charAt(i)) {
                        return strs[j].substring(0, i);
                    }
                }
                i++;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}