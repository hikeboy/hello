//给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和
//。假定每组输入只存在唯一答案。 
//
// 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
//
//与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
// 
// Related Topics 数组 双指针


package leetcode.editor.cn;

import java.util.Arrays;

public class N16ThreeSumClosest {
    public static void main(String[] args) {
        Solution solution = new N16ThreeSumClosest().new Solution();
        int[] input = new int[]{6, -18, -20, -7, -15, 9, 18, 10, 1, -20, -17, -19, -3, -5, -19, 10, 6, -11, 1, -17, -15, 6, 17, -18, -3, 16, 19, -20, -3, -17, -15, -3, 12, 1, -9, 4, 1, 12, -2, 14, 4, -4, 19, -20, 6, 0, -19, 18, 14, 1, -15, -5, 14, 12, -4, 0, -10, 6, 6, -6, 20, -8, -6, 5, 0, 3, 10, 7, -2, 17, 20, 12, 19, -13, -1, 10, -1, 14, 0, 7, -3, 10, 14, 14, 11, 0, -4, -15, -8, 3, 2, -5, 9, 10, 16, -4, -3, -9, -8, -14, 10, 6, 2, -12, -7, -16, -6, 10};
        int result = solution.threeSumClosest(input, -52);
        System.out.println(result);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int threeSumClosest(int[] nums, int target) {
            if (nums.length < 3) {
                return 0;
            }
            Arrays.sort(nums);
            int result = nums[0] + nums[1] + nums[2];
            for (int i = 0; i < nums.length - 2; i++) {
//                if (nums[i] > target) {
//                    break; 千万注意当tartget是负数时，这里与三数之和=0不同！！！！
//                }
                int l = i + 1;
                int r = nums.length - 1;
                while (l < r) {
                    int sum = nums[i] + nums[l] + nums[r];
                    if (sum == target) {
                        return sum;
                    } else if (sum < target) {
                        l++;
                    } else {
                        r--;
                    }
                    if (Math.abs(sum - target) < Math.abs(result - target)) {
                        result = sum;
                    }
                }
            }
            return result;
        }

        //解答失败: 测试用例:[6,-18,-20,-7,-15,9,18,10,1,-20,-17,-19,-3,-5,-19,10,6,-11,1,-17,-15,6,17,-18,-3,16,19,-20,-3,-17,-15,-3,12,1,-9,4,1,12,-2,14,4,-4,19,-20,6,0,-19,18,14,1,-15,-5,14,12,-4,0,-10,6,6,-6,20,-8,-6,5,0,3,10,7,-2,17,20,12,19,-13,-1,10,-1,14,0,7,-3,10,14,14,11,0,-4,-15,-8,3,2,-5,9,10,16,-4,-3,-9,-8,-14,10,6,2,-12,-7,-16,-6,10] -52 测试结果:-60 期望结果:-52 stdout:
//        public int threeSumClosest(int[] nums, int target) {
//            if (nums.length < 3) {
//                return 0;
//            }
//            Arrays.sort(nums);
//            int minDiff = Integer.MAX_VALUE;
//            int result = nums[0] + nums[1] + nums[2];
//            for (int i = 0; i < nums.length - 2; i++) {
//                if (nums[i] > target) {
//                    break;
//                }
//                int l = i + 1;
//                int r = nums.length - 1;
//                while (l < r) {
//                    int sum = nums[i] + nums[l] + nums[r];
////                  int diff = Math.abs(sum - target); //解答失败: 测试用例:[0,2,1,-3] 1 测试结果:-1 期望结果:0
//                    int diff = sum - target;
//                    if (diff == 0) {
//                        return sum;
//                    } else if (diff < 0) {
//                        l++;
//                    } else {
//                        r--;
//                    }
//                    diff = Math.abs(diff);
//                    if (diff < minDiff) {
//                        minDiff = diff;
//                        result = sum;
//                    }
//                }
//            }
//            return result;
//        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}