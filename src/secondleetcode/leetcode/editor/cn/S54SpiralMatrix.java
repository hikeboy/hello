//给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。 
//
// 示例 1: 
//
// 输入:
//[
// [ 1, 2, 3 ],
// [ 4, 5, 6 ],
// [ 7, 8, 9 ]
//]
//输出: [1,2,3,6,9,8,7,4,5]
// 
//
// 示例 2: 
//
// 输入:
//[
//  [1, 2, 3, 4],
//  [5, 6, 7, 8],
//  [9,10,11,12]
//]
//输出: [1,2,3,4,8,12,11,10,9,5,6,7]
// 
// Related Topics 数组


package secondleetcode.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class S54SpiralMatrix {
    public static void main(String[] args) {
        Solution solution = new S54SpiralMatrix().new Solution();
//        System.out.println(solution.spiralOrder(new int[][]{
//                {1, 2, 3, 4},
//                {5, 6, 7, 8},
//                {9, 10, 11, 12}}));
//        System.out.println(solution.spiralOrder(new int[][]{
//                {2,5,8},
//                {4,0,-1}}));
        System.out.println(solution.spiralOrder(new int[][]{
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16} }));
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 解答失败: 测试用例:[[2,5,8],[4,0,-1]] 测试结果:[2,5,8,-1,0,4,0] 期望结果:[2,5,8,-1,0,4] stdout:
     */

    /**
     * 解答失败: 测试用例:[[1,2,3,4],[5,6,7,8],[9,10,11,12],[13,14,15,16]] 测试结果:[1,2,3,4,8,12,16,15,14,13] 期望结果:[1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10] stdout:
     */
    class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            List<Integer> result = new ArrayList<>();
            if (matrix == null || matrix.length == 0) {
                return result;
            }
            int m = matrix.length;
            int n = matrix[0].length;
            int count = 0;
            int left = 0;
            int right = n - 1;
            int top = 0;
            int bottom = m -1;
            while (count < m * n) {
                for (int i = left; i <= right; i++) {
//                    count++;
                    result.add(matrix[top][i]);
                }
                if (++top > bottom) break;
                for (int i = top; i <= bottom; i++) {
//                    count++; // 如果不加可能到
                    result.add(matrix[i][right]);
                }
                if (--right < left) break;
                for (int i = right; i >= left; i--) {
//                    count++;
                    result.add(matrix[bottom][i]);
                }
                if (--bottom < top) break;
                for (int i = bottom; i >= top; i--) {
//                    count++;
                    result.add(matrix[i][left]);
                }
                if (++left > right)break;
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}