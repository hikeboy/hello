//给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。 
//
// 示例: 
//
// 输入: n = 4, k = 2
//输出:
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//] 
// Related Topics 回溯算法


package secondleetcode.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class S77Combinations {
    public static void main(String[] args) {
        Solution solution = new S77Combinations().new Solution();
        System.out.println(solution.combine(4, 2));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private List<List<Integer>> result = new ArrayList<>();

        public List<List<Integer>> combine(int n, int k) {
            backTrace(n, k, 1, new ArrayList<>());
            return result;
        }

        private void backTrace(int n, int k, int start, List<Integer> temp) {
            if (temp.size() == k) {
                result.add(new ArrayList<>(temp));
                return;
            }
//            if (start > n - k + 1) {
//                return;
//            }
//            for (int i = start; i <= n; i++) { 可以减枝 k - temp.size() < n - i
            for (int i = start; i <= (n - k) + temp.size() + 1; i++) {
                temp.add(i);
                backTrace(n, k, i + 1, temp);
                temp.remove(temp.size() - 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}