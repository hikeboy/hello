//给定一个可包含重复数字的序列，返回所有不重复的全排列。 
//
// 示例: 
//
// 输入: [1,1,2]
//输出:
//[
//  [1,1,2],
//  [1,2,1],
//  [2,1,1]
//] 
// Related Topics 回溯算法


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class N47PermutationsIi {
    public static void main(String[] args) {
        Solution solution = new N47PermutationsIi().new Solution();
        System.out.println(solution.permuteUnique(new int[]{3, 3, 0, 3}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> permuteUnique(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();
            Arrays.sort(nums); //忘记无法通过3,3,0,3
            dfs(nums, result, new ArrayList<>(), new int[nums.length]);
            return result;
        }

        private void dfs(int[] nums, List<List<Integer>> result, List<Integer> temp, int[] flags) {
            if (nums.length == temp.size()) {
                result.add(new ArrayList<>(temp));
                return;
            }
            for (int i = 0; i < nums.length; i++) {
                if (flags[i] == 1) {
                    continue;
                }
                if (i > 0 && nums[i] == nums[i - 1] && flags[i - 1] == 0) { // aciton!! no && flags[i - 1] == 1
                    continue;
                }
                temp.add(nums[i]);
                flags[i] = 1;
                dfs(nums, result, temp, flags);
                temp.remove(temp.size() - 1);
                flags[i] = 0;
                while ((i + 1 < nums.length) && nums[i+1] == nums[i]) {
                    i++;
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}