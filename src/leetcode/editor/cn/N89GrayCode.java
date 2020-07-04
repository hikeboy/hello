//格雷编码是一个二进制数字系统，在该系统中，两个连续的数值仅有一个位数的差异。 
//
// 给定一个代表编码总位数的非负整数 n，打印其格雷编码序列。即使有多个不同答案，你也只需要返回其中一种。 
//
// 格雷编码序列必须以 0 开头。 
//
// 
//
// 示例 1: 
//
// 输入: 2
//输出: [0,1,3,2]
//解释:
//00 - 0
//01 - 1
//11 - 3
//10 - 2
//
//对于给定的 n，其格雷编码序列并不唯一。
//例如，[0,2,3,1] 也是一个有效的格雷编码序列。
//
//00 - 0
//10 - 2
//11 - 3
//01 - 1 
//
// 示例 2: 
//
// 输入: 0
//输出: [0]
//解释: 我们定义格雷编码序列必须以 0 开头。
//     给定编码总位数为 n 的格雷编码序列，其长度为 2n。当 n = 0 时，长度为 20 = 1。
//     因此，当 n = 0 时，其格雷编码序列为 [0]。
// 
// Related Topics 回溯算法


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class N89GrayCode {
    public static void main(String[] args) {
        Solution solution = new N89GrayCode().new Solution();
        System.out.println(solution.grayCode(2));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 方法2 异或法
        public List<Integer> grayCode(int n) {
            List<Integer> result = new ArrayList<>();
            int num = 1 << n;
            for (int i = 0; i < num; i++) {
                int a = i>> 1;
                int b = a ^ i;
                result.add(b);
            }
            return result;
        }
//        public List<Integer> grayCode(int n) {
//            List<Integer> result = new ArrayList() {{
//                add(0);
//            }};
//            int head = 1;
//            for (int i = 1; i <= n; i++) {
//                for (int j = result.size() - 1; j >= 0; j--) {
//                    result.add(head + result.get(j));
//                }
//                head = head << 1;
//            }
//            return result;
//        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}