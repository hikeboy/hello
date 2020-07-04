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

  
package secondleetcode.leetcode.editor.cn;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class S15ThreeSum{
      public static void main(String[] args) {
           Solution solution = new S15ThreeSum().new Solution();
           System.out.println(solution.threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
          System.out.println(solution.threeSum(new int[]{0, 0, 0}));
          System.out.println(solution.threeSum(new int[]{-2,0,0,2,2}));
      }
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
            /**
             * 解答失败: 测试用例:[-2,0,0,2,2] 测试结果:[[-2,0,2],[-2,0,2]] 期望结果:[[-2,0,2]] stdout:
             * @param nums
             * @return
             */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            if (nums[i] > 0) {
                    break; //剪枝
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[left] + nums[right] + nums[i];
                if (sum == 0) {
                    List<Integer> res = new ArrayList<>();
                    res.add(nums[i]);
                    res.add(nums[left]);
                    res.add(nums[right]);
                    result.add(res);
                    left++;
                    while (left < right && nums[left] == nums[left-1]) {
                        left ++;
                        //  否则无法通过 解答失败: 测试用例:[-2,0,0,2,2] 测试结果:[[-2,0,2],[-2,0,2]] 期望结果:[[-2,0,2]] stdout:
                    }
                    right--;
                    while (left < right && nums[right] == nums[right+1]) {
                        right --;
                    }
                } else if (sum > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }