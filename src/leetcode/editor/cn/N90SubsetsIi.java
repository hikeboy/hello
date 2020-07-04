//给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。 
//
// 说明：解集不能包含重复的子集。 
//
// 示例: 
//
// 输入: [1,2,2]
//输出:
//[
//  [2],
//  [1],
//  [1,2,2],
//  [2,2],
//  [1,2],
//  []
//] 
// Related Topics 数组 回溯算法


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class N90SubsetsIi {
    public static void main(String[] args) {
        Solution solution = new N90SubsetsIi().new Solution();
        //System.out.println(solution.subsetsWithDup(new int[]{1,2,2}));
        System.out.println(solution.subsetsWithDup2(new int[]{5, 5, 5, 5, 5}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private List<List<Integer>> reuslt = new ArrayList<>();

        public List<List<Integer>> subsetsWithDup(int[] nums) {
            Arrays.sort(nums);
//            for (int i = 0; i <= nums.length; i++) {
            backTrace(nums, new ArrayList<>(), 0);
//            }
            return reuslt;
        }


        private void backTrace(int[] nums, List<Integer> temp, int start) {
//            if (temp.size() == k) {
            reuslt.add(new ArrayList<>(temp));
//                return;
//            }
            for (int i = start; i < nums.length; i++) {
                temp.add(nums[i]);
                backTrace(nums, temp, i + 1);
//                if (i > start && nums[i] == nums[i - 1]) { 错误，这种应该放在递归前去重
                temp.remove(temp.size() - 1);
//                if (i+1 < nums.length && nums[i+1] == nums[i]) { 错误，只去了2个重复 如果有3个以上重复
                while (i + 1 < nums.length && nums[i + 1] == nums[i]) {
//                    continue; 错误 在递归前去重才用continue
                    i++;
                }
//                temp.remove(temp.size() - 1); 错误 应该放在去重代码前面
            }
        }

        //二进制位法
        public List<List<Integer>> subsetsWithDup2(int[] nums) {
            Arrays.sort(nums);
            List<List<Integer>> lists = new ArrayList<>();
            int subsetNum = 1 << nums.length;
            for (int i = 0; i < subsetNum; i++) {
                List<Integer> list = new ArrayList<>();
                boolean illegal = false;
                for (int j = 0; j < nums.length; j++) {
                    if ((i >> j & 1) == 1) {
                        if (j > 0 && nums[j] == nums[j - 1] && (i >> (j - 1) & 1) == 0) {
                            illegal = true;
                            break;
                        } else {
                            list.add(nums[j]);
                        }
                    }
                }
                if (!illegal) {
                    lists.add(list);
                }
            }
            return lists;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}