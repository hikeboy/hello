//给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, 
//ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。 
//
// 说明：你不能倾斜容器，且 n 的值至少为 2。 
//
// 
//
// 
//
// 图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。 
//
// 
//
// 示例： 
//
// 输入：[1,8,6,2,5,4,8,3,7]
//输出：49 
// Related Topics 数组 双指针


package leetcode.editor.cn;

public class N11ContainerWithMostWater {
    public static void main(String[] args) {
        Solution solution = new N11ContainerWithMostWater().new Solution();
        System.out.println(solution.maxArea(new int[]{2, 3, 4, 5, 18, 17, 6}));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxArea(int[] height) {
            int left = 0;
            int right = height.length - 1;
            int maxArea = 0;
            int area;
            while (left < right) {
//     容易笔误  area = (right - left) * Math.min(left, right);
                area = (right - left) * Math.min(height[left], height[right]);
                if (area > maxArea) {
                    maxArea = area;
                }
//                if (left < right) { 笔误
                if (height[left] < height[right]) {
                    left++;
                } else {
                    right--;
                }
            }
            System.out.println(left);
            System.out.println(right);
            return maxArea;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}