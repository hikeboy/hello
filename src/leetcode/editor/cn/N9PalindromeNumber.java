//判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。 
//
// 示例 1: 
//
// 输入: 121
//输出: true
// 
//
// 示例 2: 
//
// 输入: -121
//输出: false
//解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
// 
//
// 示例 3: 
//
// 输入: 10
//输出: false
//解释: 从右向左读, 为 01 。因此它不是一个回文数。
// 
//
// 进阶: 
//
// 你能不将整数转为字符串来解决这个问题吗？ 
// Related Topics 数学


package leetcode.editor.cn;

public class N9PalindromeNumber {
    public static void main(String[] args) {
        Solution solution = new N9PalindromeNumber().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        //击败50% 而已
        public boolean isPalindrome(int x) {
            if (x < 0) {
                return false;
            }
            if (0 <= x && x < 10) {
                return true;
            }
            int a = 0;
            int b = x;
            while (b > 0) {
                a = a * 10 + b % 10;
                b = b / 10;
            }
            return a == x;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    /**
     * 改进：
     * 1，只需要翻转一半，和另外一半比较即可
     * 2，如何判断已经翻转了一半？ 新的一半比还未翻转的大说明已经过半
     */

    public boolean isPalindrome(int x) {
        //思考：这里大家可以思考一下，为什么末尾为 0 就可以直接返回 false
        if (x < 0 || (x % 10 == 0 && x != 0)) return false;
        int revertedNumber = 0;
        while (x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }
        return x == revertedNumber || x == revertedNumber / 10; // 可能总长度为奇数位。
    }
}