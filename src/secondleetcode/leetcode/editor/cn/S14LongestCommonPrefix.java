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

  
package secondleetcode.leetcode.editor.cn;
public class S14LongestCommonPrefix{
      public static void main(String[] args) {
           Solution solution = new S14LongestCommonPrefix().new Solution();
           String[] strings = new String[]{"flower","flow","flight"};
           String[] strings1 = new String[]{"dog","racecar","car"};
           System.out.println(solution.longestCommonPrefix(strings));
          System.out.println(solution.longestCommonPrefix(strings1));
      }
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }

        int index = 0;
        while (true) {
//            char ch = strs[0].charAt(index);strs[0]会越界
            for (int i = 0; i < strs.length; i++) {
                if (strs[i].length() <= index) {
                    return strs[i];
                }
                char ch = strs[0].charAt(index);
                if (strs[i].charAt(index) != ch) {
                    return strs[i].substring(0, index);
                }
            }
            index++;
        }

    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }