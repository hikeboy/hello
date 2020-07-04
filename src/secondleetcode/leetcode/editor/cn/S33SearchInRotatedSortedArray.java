//假设按照升序排序的数组在预先未知的某个点上进行了旋转。 
//
// ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。 
//
// 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。 
//
// 你可以假设数组中不存在重复的元素。 
//
// 你的算法时间复杂度必须是 O(log n) 级别。 
//
// 示例 1: 
//
// 输入: nums = [4,5,6,7,0,1,2], target = 0
//输出: 4
// 
//
// 示例 2: 
//
// 输入: nums = [4,5,6,7,0,1,2], target = 3
//输出: -1 
// Related Topics 数组 二分查找

  
package secondleetcode.leetcode.editor.cn;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

public class S33SearchInRotatedSortedArray{
      public static void main(String[] args) {
           Solution solution = new S33SearchInRotatedSortedArray().new Solution();
           int[] nums = new int[]{4,5,6,7,0,1,2};
          System.out.println(solution.search(nums, 0));
          System.out.println(solution.search(nums, 5));
          nums = new int[]{3,1};
          System.out.println(solution.search(nums, 1));
          System.out.println(solution.search(nums, 3));
      }
        //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 解答失败: 测试用例:[3,1] 1 测试结果:-1 期望结果:1 stdout:
     */
    class Solution {
    public int search(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                //    if (nums[mid] > nums[start]) { 解答失败: 测试用例:[3,1] 1 测试结果:-1 期望结果:1
                if (nums[mid] >= nums[start]) {
                    if (nums[start] == target) {
                        return start;
                    } else if (nums[start] < target) {
                        end = mid - 1;
                    } else {
                        start = mid + 1;
                    }
                } else {
                    end = mid -1;
                }
            } else if (nums[mid] < target) {
                //,2,3,4,5,6,7,0,1
                if (nums[mid] <= nums[end]) {
                      if (nums[end] == target) {
                          return end;
                      } else if (nums[end] > target) {
                          start = mid + 1;
                      } else {
                          end = mid - 1;
                      }
                } else {
                    start = mid + 1;
                }
            }
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
//6,7,0,1,2,4,5,
  }