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


package secondleetcode.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class S46Permutations {
    public static void main(String[] args) {
        Solution solution = new S46Permutations().new Solution();
        System.out.println(solution.permute(new int[]{1,2,3}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private List<List<Integer>> result;

        public List<List<Integer>> permute(int[] nums) {
            result = new ArrayList<>();
            if (nums == null || nums.length == 0) {
                return result;
            }
            int[] flag = new int[nums.length];
            dfs(nums, flag, new ArrayList<>());
            return result;
        }

        public void dfs(int[] nums, int[] flag,List<Integer> temp) {
            if (temp.size() == nums.length) {
                result.add(new ArrayList<>(temp));
                return;
            }
            for (int i = 0; i < nums.length; i++) {
                if (flag[i] == 0) {
                    temp.add(nums[i]);
                    flag[i] = 1;
                    dfs(nums, flag, temp);
                    temp.remove(temp.size() - 1);
                    flag[i] = 0;
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}