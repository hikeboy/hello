//给定一个 没有重复 数字的序列，返回其所有可能的全排列。 
//
// 示例: 
//
// 输入: [1,2,3]
//输出:
//[
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
//] 
// Related Topics 回溯算法


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class N46Permutations {
    public static void main(String[] args) {
        Solution solution = new N46Permutations().new Solution();
        System.out.println(solution.permute(new int[]{1, 2, 3}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();
            dfs(result, nums, new ArrayList<>(), new int[nums.length]);
            return result;
        }

        //        private void dfs(List<List<Integer>> result, int[] nums, List<Integer> temp, int index, int[] flag) { int index 不需要index
        private void dfs(List<List<Integer>> result, int[] nums, List<Integer> temp, int[] flag) {
            if (temp.size() == nums.length) {
                result.add(new ArrayList<>(temp));
                return;
            }

//            for (int i = index; i < nums.length; i++) { 只适合无重复
            for (int i = 0; i < nums.length; i++) {
                if (flag[i] == 1) {
                    continue;
                }
                flag[i] = 1;
                temp.add(nums[i]);
                dfs(result, nums, temp, flag);
                flag[i] = 0;
                //temp.remove(i); 错误
                temp.remove(temp.size() - 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}