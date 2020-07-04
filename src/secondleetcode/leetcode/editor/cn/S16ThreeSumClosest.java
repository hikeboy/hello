//给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和
//。假定每组输入只存在唯一答案。 
//
// 
//
// 示例： 
//
// 输入：nums = [-1,2,1,-4], target = 1
//输出：2
//解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
// 
//
// 
//
// 提示： 
//
// 
// 3 <= nums.length <= 10^3 
// -10^3 <= nums[i] <= 10^3 
// -10^4 <= target <= 10^4 
// 
// Related Topics 数组 双指针


package secondleetcode.leetcode.editor.cn;

import java.util.Arrays;

public class S16ThreeSumClosest {
    public static void main(String[] args) {
        Solution solution = new S16ThreeSumClosest().new Solution();
        int[] input = new int[]{6, -18, -20, -7, -15, 9, 18, 10, 1, -20, -17, -19, -3, -5, -19, 10, 6, -11, 1, -17, -15, 6, 17, -18, -3, 16, 19, -20, -3, -17, -15, -3, 12, 1, -9, 4, 1, 12, -2, 14, 4, -4, 19, -20, 6, 0, -19, 18, 14, 1, -15, -5, 14, 12, -4, 0, -10, 6, 6, -6, 20, -8, -6, 5, 0, 3, 10, 7, -2, 17, 20, 12, 19, -13, -1, 10, -1, 14, 0, 7, -3, 10, 14, 14, 11, 0, -4, -15, -8, 3, 2, -5, 9, 10, 16, -4, -3, -9, -8, -14, 10, 6, 2, -12, -7, -16, -6, 10};
        int result = solution.threeSumClosest(input, -52);
        System.out.println(result);

        input = new int[] {-1,2,1,-4};
        System.out.println(solution.threeSumClosest(input, 1));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int threeSumClosest(int[] nums, int target) {
            if (nums == null || nums.length < 3) {
                return 0;
            }
            Arrays.sort(nums);
//            int result = Integer.MAX_VALUE; 错误
            int result = nums[0] + nums[1] + nums[2];
            for (int i = 0; i < nums.length -2; i++) {
                int left = i+1;
                int right = nums.length -1;
                while (left < right) {
                    int sum = nums[i] + nums[right] + nums[left];
                    if (sum == target) {
                        return sum;
                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }

                    if (Math.abs(sum - target) < Math.abs(result - target)) {
                        result = sum;
                    }
                }
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}