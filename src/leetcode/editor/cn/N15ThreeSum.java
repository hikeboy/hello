//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复
//的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 示例： 
//
// 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
//
//满足要求的三元组集合为：
//[
//  [-1, 0, 1],
//  [-1, -1, 2]
//]
// 
// Related Topics 数组 双指针


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class N15ThreeSum {
    public static void main(String[] args) {
        Solution solution = new N15ThreeSum().new Solution();
      //  System.out.println(solution.threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
        System.out.println(solution.threeSum(new int[]{0, 0, 0}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();
            if (nums == null || nums.length < 3) {
                return result;
            }
            Arrays.sort(nums);
//            for (int i = 0; i < nums.length - 3; i++) { 无法通过0, 0, 0
            for (int i = 0; i < nums.length - 2; i++) {
                int target = 0 - nums[i];
                int left = i + 1;
                int right = nums.length - 1;
//                if ((nums[i] == nums[i + 1]) {
//                    continue; 无法通过用例-1, 0, 1, 2, -1, -4
//                }
                if ((i > 0) && (nums[i] == nums[i - 1])) {
                    continue;
                }
                while (left < right) {
                    if (nums[left] + nums[right] < target) {
                        left++;
                    } else if (nums[left] + nums[right] > target) {
                        right--;
                    } else {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[left]);
                        list.add(nums[right]);
                        result.add(list);
                        left++;
                        right--;
                        while (left < right && nums[left] == nums[left - 1]) {
                            left++;
                        }
                        while (left < right && nums[right] == nums[right + 1]) {
                            right--;
                        }
                    }
                }
            }
            return result;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}