//假设按照升序排序的数组在预先未知的某个点上进行了旋转。 
//
// ( 例如，数组 [0,0,1,2,2,5,6] 可能变为 [2,5,6,0,0,1,2] )。 
//
// 编写一个函数来判断给定的目标值是否存在于数组中。若存在返回 true，否则返回 false。 
//
// 示例 1: 
//
// 输入: nums = [2,5,6,0,0,1,2], target = 0
//输出: true
// 
//
// 示例 2: 
//
// 输入: nums = [2,5,6,0,0,1,2], target = 3
//输出: false 
//
// 进阶: 
//
// 
// 这是 搜索旋转排序数组 的延伸题目，本题中的 nums 可能包含重复元素。 
// 这会影响到程序的时间复杂度吗？会有怎样的影响，为什么？ 
// 
// Related Topics 数组 二分查找

  
package secondleetcode.leetcode.editor.cn;
public class S81SearchInRotatedSortedArrayIi{
      public static void main(String[] args) {
           Solution solution = new S81SearchInRotatedSortedArrayIi().new Solution();
           int[] ints = new int[] {2,5,6,0,0,1,2};
          System.out.println(solution.search(ints, 0 ));
          System.out.println(solution.search(ints, 3 ));
          ints = new int[]{1,3,1,1,1};
          System.out.println(solution.search(ints, 3 ));
      }
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
            /**
             * 解答失败: 测试用例:[1] 1 测试结果:false 期望结果:true stdout:
             * 解答失败: 测试用例:[1,1,3,1] 3 测试结果:false 期望结果:true
             * 解答失败: 测试用例:[1,3,1,1,1] 3 测试结果:false 期望结果:true
             * @param nums
             * @param target
             * @return
             */
    public boolean search(int[] nums, int target) {
        if (nums == null) {
            return false;
        }
        int left = 0, right = nums.length - 1;
        //        while (left < right) {测试用例:[1] 1 测试结果:false 期望结果:true
        while (left <= right) {
            int mid = (left + right)/ 2;
            if (nums[mid] == target) {
                return true;
            }

            if (nums[mid] == nums[left]) {
                left++;// 去重
                continue;//不能漏掉
            }

//            if (nums[mid] > nums[left]) { 测试用例:[1,1,3,1] 3 测试结果:false 期望结果:true
            if (nums[mid] > nums[left]) {
                 if (nums[left] == target) {
                     return true;
                 }
                 if (nums[left] < target && target < nums[mid]) {
                     right = mid -1;
                 } else {
                     left = mid + 1;
                 }
            } else {
                if (nums[right] == target) {
                    return true;
                }
                if (nums[right] > target && target > nums[mid]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }