//给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。 
//
// 示例 1: 
//
// 输入: num1 = "2", num2 = "3"
//输出: "6" 
//
// 示例 2: 
//
// 输入: num1 = "123", num2 = "456"
//输出: "56088" 
//
// 说明： 
//
// 
// num1 和 num2 的长度小于110。 
// num1 和 num2 只包含数字 0-9。 
// num1 和 num2 均不以零开头，除非是数字 0 本身。 
// 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。 
// 
// Related Topics 数学 字符串


package leetcode.editor.cn;

public class N43MultiplyStrings {
    public static void main(String[] args) {
        Solution solution = new N43MultiplyStrings().new Solution();
        System.out.println(solution.multiply("123", "456"));
        System.out.println(solution.multiply("0", "456"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String multiply(String num1, String num2) {
            if (num1 == null || "".equals(num1)) {
                return num2;
            }
            if (num2 == null || "".equals(num2)) {
                return num1;
            }
            if ("0".equals(num1) || "0".equals(num2)) {
                return "0";
            }
            int len1 = num1.length();
            int len2 = num2.length();
//            if (len1 > len2) {
////                return multiply(num2, num1);
////            } 不需要
            int[] arrays = new int[len1 + len2];
            int a, b;
            for (int i = len1 - 1; i >= 0; i--) {
                a = num1.charAt(i) - '0';
                for (int j = len2 - 1; j >= 0; j--) {
                    b = num2.charAt(j) - '0';
                    int multi = a * b + arrays[i + j + 1];
//                    arrays[i + j ] = multi % 10; 错误
                    arrays[i + j + 1] = multi % 10;
                    arrays[i + j] = arrays[i + j] + multi / 10;
                }
            }
            StringBuilder builder = new StringBuilder();
            int i = 1;
            if (arrays[0] > 0) {
                i = 0;
            }
            for (; i < arrays.length; i++) {
                builder.append(arrays[i]);
            }
            return builder.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}