//给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。 
//
// 说明：解集不能包含重复的子集。 
//
// 示例: 
//
// 输入: nums = [1,2,3]
//输出:
//[
//  [3],
//  [1],
//  [2],
//  [1,2,3],
//  [1,3],
//  [2,3],
//  [1,2],
//  []
//] 
// Related Topics 位运算 数组 回溯算法


package secondleetcode.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class S78Subsets {
    public static void main(String[] args) {
        Solution solution = new S78Subsets().new Solution();
        System.out.println(solution.subsets(new int[]{1, 2, 3}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private List<List<Integer>> result = new ArrayList<>();

        public List<List<Integer>> subsets(int[] nums) {
            for (int i = 0; i <= nums.length; i++) {
                backTrace(nums, i, 0, new ArrayList<>());
            }
            return result;
        }

        private void backTrace(int[] nums, int len, int start, List<Integer> temp) {
            if (temp.size() == len) {
                result.add(new ArrayList<>(temp));
                return;
            }
            for (int i = start; i < nums.length; i++) {
                temp.add(nums[i]);
                backTrace(nums, len, i + 1, temp);
                temp.remove(temp.size() - 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}