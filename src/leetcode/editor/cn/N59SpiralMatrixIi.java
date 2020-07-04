//给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。 
//
// 示例: 
//
// 输入: 3
//输出:
//[
// [ 1, 2, 3 ],
// [ 8, 9, 4 ],
// [ 7, 6, 5 ]
//] 
// Related Topics 数组


package leetcode.editor.cn;

public class N59SpiralMatrixIi {
    public static void main(String[] args) {
        Solution solution = new N59SpiralMatrixIi().new Solution();
        int[][] result = solution.generateMatrix(3);
        System.out.println(result);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] generateMatrix(int n) {
            int[][] result = new int[n][n];
            int l = 0, r = n - 1, t = 0, d = n - 1;
            int num = 1;
            while (num <= n * n) {
                for (int i = l; i <= r; i++) {
                    result[t][i] = num++;
                }
                if (++t > d) break;
                for (int i = t; i <= d; i++) {
                    result[i][r] = num++;
                }
                if (--r < l) break;
                for (int i = r; i >= l; i--) {
                    result[d][i] = num++;
                }
                if (--d < t) break;

                for (int i = d; i >= t; i--) {
                    result[i][l] = num++;
                }
                if (++l > r) break;
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}