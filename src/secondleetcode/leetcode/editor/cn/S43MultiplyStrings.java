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

  
package secondleetcode.leetcode.editor.cn;
public class S43MultiplyStrings{
      public static void main(String[] args) {
           Solution solution = new S43MultiplyStrings().new Solution();
          System.out.println(solution.multiply("9", "9"));
      }
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
            /**
             * 解答失败: 测试用例:"9133" "0" 测试结果:"0000" 期望结果:"0" stdout:
           * @param num1
             * @param num2
             * @return
             */
    public String multiply(String num1, String num2) {
          if (num1 == null) {
              return num2;
          }
          if (num2 == null) {
              return num1;
          }
          int len1 = num1.length();
          int len2 = num2.length();
          int[] result = new int [len1 + len2];
          for (int i = len2 -1 ; i>=0; i--) {
              for (int j = len1 -1; j>=0; j--) {
                  int index = i + j + 1;
                  int prod = (num1.charAt(j) - '0') *  (num2.charAt(i) - '0');
                  int sum = result[index] + prod;
                  result[index] = sum % 10;
                  result[index - 1] += (sum / 10);
              }
          }
          StringBuilder builder = new StringBuilder();
        int start = 0;
//          if (result[0] > 0) {
//              builder.append(result[0]);
//          }
//          while (result[start] == 0 && start < result.length) {
        while (start < result.length && result[start] == 0 ) {
              start++;
          }
          for (int i= start; i< result.length; i++) {
              builder.append(result[i]);
          }
          if (builder.length() == 0) {
              return "0";
          }
          return builder.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }