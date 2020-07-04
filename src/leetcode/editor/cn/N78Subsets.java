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


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class N78Subsets {
    public static void main(String[] args) {
        Solution solution = new N78Subsets().new Solution();
        System.out.println(solution.subsets(new int[]{1, 2, 3}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private List<List<Integer>> result;

        //方法一 二进制位
//        public List<List<Integer>> subsets(int[] nums) {
//            List<List<Integer>> res = new ArrayList<>();
//            for (int i = 0; i < (1 << nums.length); i++) {
//                List<Integer> subRes = new ArrayList<>();
//                for (int j = 0; j < nums.length; j++) {
//                    if (((i >> j) & 1) == 1) {
//                        subRes.add(nums[j]);
//                    }
//                }
//                res.add(subRes);
//            }
//            return res;
//        }

        //方法二 回溯法
//        public List<List<Integer>> subsets(int[] nums) {
//            result = new ArrayList<>();
//            if (nums.length == 0) {
//                return result;
//            }
//            dfs(0, new ArrayList<>(), nums);
//            return result;
//        }
//
//        private void dfs(int start, List<Integer> temp, int[] nums) {
//            result.add(new ArrayList<>(temp));
//            for (int i = start; i < nums.length; i++) {
//                temp.add(nums[i]);
////                dfs(start + 1, temp, nums); 是i+1不是start+1，会出现 111  222 333重复数结果
//                dfs(i + 1, temp, nums);
//                temp.remove(temp.size() - 1);
//            }
//        }
        //方法三 回溯 + 剪枝
        public List<List<Integer>> subsets(int[] nums) {
            result = new ArrayList<>();
            result.add(new ArrayList<>());
            if (nums.length == 0) {
                return result;
            }

            for (int i = 1; i <= nums.length; i++) {
                backTrack(nums, i, 0, new Integer[i], 0);
            }
            return result;
        }

        private void backTrack(int[] nums, int k, int start, Integer[] temp, int curIndex) {
            if (curIndex == k) {
//                List<Integer> tempRes = Arrays.asList(temp);会得出错误结论
//                result.add(tempRes);
//                return;
                List<Integer> tempRes = new ArrayList<>();
                for(int i : temp)
                    tempRes.add(i);
                result.add(tempRes);
                return;
            }
            for (int i = start; i < nums.length - k + curIndex + 1; i++) {
                temp[curIndex] = nums[i];
                backTrack(nums, k, i + 1, temp,curIndex + 1);
            }
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}