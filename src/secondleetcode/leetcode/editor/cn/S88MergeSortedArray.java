//给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。 
//
// 
//
// 说明: 
//
// 
// 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。 
// 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。 
// 
//
// 
//
// 示例: 
//
// 输入:
//nums1 = [1,2,3,0,0,0], m = 3
//nums2 = [2,5,6],       n = 3
//
//输出: [1,2,2,3,5,6] 
// Related Topics 数组 双指针

  
package secondleetcode.leetcode.editor.cn;
public class S88MergeSortedArray{
      public static void main(String[] args) {
           Solution solution = new S88MergeSortedArray().new Solution();
                  int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
        int[] nums2 = new int[]{2, 5, 6};
        solution.merge(nums1, 3, nums2, 3);
//        int[] nums1 = new int[]{0};
//        int[] nums2 = new int[]{1};
//                 solution.merge(nums1, 0, nums2, 1);
//        int[] nums1 = new int[]{1,0};
//        int[] nums2 = new int[]{2};
//        solution.merge(nums1, 1, nums2, 1);
//          int[] nums1 = new int[]{2, 0};
//          int[] nums2 = new int[]{1};
//          solution.merge(nums1, 1, nums2, 1);
          for (int i : nums1) {
              System.out.print(i);
              System.out.print(",");
          }
      }
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
          int index = m + n - 1;
          int i = m -1;
          int j = n -1;
          while (i >= 0 && j >= 0) {
              if (nums1[i] > nums2[j]) {
                  nums1[index--] = nums1[i--];
              } else {
                  nums1[index--] = nums2[j--];
              }
          }
          while (i >= 0) {
              nums1[index--] = nums1[i--];
          }
          while (j >= 0) {
              nums1[index--] = nums2[j--];
          }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }