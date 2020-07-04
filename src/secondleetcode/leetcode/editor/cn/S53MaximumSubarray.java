//给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。 
//
// 示例: 
//
// 输入: [-2,1,-3,4,-1,2,1,-5,4],
//输出: 6
//解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
// 
//
// 进阶: 
//
// 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。 
// Related Topics 数组 分治算法 动态规划

  
package secondleetcode.leetcode.editor.cn;
public class S53MaximumSubarray{
      public static void main(String[] args) {
           Solution solution = new S53MaximumSubarray().new Solution();
          System.out.println(solution.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
      }
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
          // 1,贪心大概理解，贪心，前面的小于0，就丢了。
          // 2,动态规划，前面的元素大于0，就和当前元素相加
    public int maxSubArray(int[] nums) {
      if (nums == null || nums.length == 0) {
          return 0;
      }
      int sum = 0;
//        int max = sum; 无法通过用例 [-1]
      int max = Integer.MIN_VALUE;
      for (int i = 0; i < nums.length; i++) {
          if (sum < 0) {
              sum = nums[i];
          } else {
              sum += nums[i];
          }
          if (sum > max) {
              max = sum;
          }
      }
      return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }