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


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class N77Combinations {
    public static void main(String[] args) {
        Solution solution = new N77Combinations().new Solution();
        System.out.println(solution.combine(4, 2));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private List<List<Integer>> result = new ArrayList<>();

        public List<List<Integer>> combine(int n, int k) {
             backTrace(n, k, 1, new ArrayList<>());
             return result;
        }

        public void backTrace(int n, int k, int start, List<Integer> tempRes) {
            if (tempRes.size() == k) {
                result.add(new ArrayList<>(tempRes));
                return;
            }
            for (int i = start; i <= n; i++) {
                tempRes.add(i);
//                backTrace(n, k, start + 1, tempRes);会造成重复答案 2，2  3，3  4，4
                backTrace(n, k, i + 1, tempRes);
                tempRes.remove(tempRes.size() - 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}