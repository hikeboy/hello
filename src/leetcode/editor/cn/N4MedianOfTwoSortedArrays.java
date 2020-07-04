//给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。 
//
// 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。 
//
// 你可以假设 nums1 和 nums2 不会同时为空。 
//
// 示例 1: 
//
// nums1 = [1, 3]
//nums2 = [2]
//
//则中位数是 2.0
// 
//
// 示例 2: 
//
// nums1 = [1, 2]
//nums2 = [3, 4]
//
//则中位数是 (2 + 3)/2 = 2.5
// 
// Related Topics 数组 二分查找 分治算法


package leetcode.editor.cn;

public class N4MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        Solution solution = new N4MedianOfTwoSortedArrays().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int len1 = nums1.length;
            int len2 = nums2.length;
            if (len1 > len2) {
                return findMedianSortedArrays(nums2, nums1);
            }

            int left = 0;
            int right = len2;
            int i, j;
            while (left < right) {
                i = (left + right) / 2;
                j = (len1 + len2) / 2 - i;
                if (nums2[i - 1] > nums1[j]) {
                    right = i;
                } else if (nums2[i] < nums1[j - 1]) {
                    left = i;
                } else {

                }
            }
return 0.0;
        }
//        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
//            int n = nums1.length;
//            int m = nums2.length;
//            int left = (n + m + 1) / 2;
//            int right = (n + m + 1) / 2;
//            return (getKth(nums1, 0, n - 1, nums2, 0, m - 1, left) + getKth(nums1, 0, n - 1, nums2, 0, m - 1, right)) * 0.5;
//
//        }
//
//        private int getKth(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int k) {
//            int len1 = end1 - start1 + 1;
//            int len2 = end2 - start2 + 1;
//            if (len1 > len2) {
//                return getKth(nums2, start2, end2, nums1, start1, end1, k);
//            }
//            if (len1 == 0) {
//                return nums2[start2 + k - 1];
//            }
//            if (k == 1) {
//                return Math.min(nums1[start1], nums2[start2]);
//            }
//
//            int i = start1 + Math.min(k / 2, len1) - 1;
//            int j = start2 + Math.min(k / 2, len2) - 1;
//
//            if (nums1[i] > nums2[j]) {
//                return getKth(nums1, start1, end1, nums2, j + 1, end2, k - (j - start2 + 1));
//            } else {
//                return getKth(nums1, i + 1, end1, nums2, start2, end2, k - (i - start1 + 1));
//            }
//        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}