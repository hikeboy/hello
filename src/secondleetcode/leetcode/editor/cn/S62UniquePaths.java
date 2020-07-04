//一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。 
//
// 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。 
//
// 问总共有多少条不同的路径？ 
//
// 
//
// 例如，上图是一个7 x 3 的网格。有多少可能的路径？ 
//
// 
//
// 示例 1: 
//
// 输入: m = 3, n = 2
//输出: 3
//解释:
//从左上角开始，总共有 3 条路径可以到达右下角。
//1. 向右 -> 向右 -> 向下
//2. 向右 -> 向下 -> 向右
//3. 向下 -> 向右 -> 向右
// 
//
// 示例 2: 
//
// 输入: m = 7, n = 3
//输出: 28 
//
// 
//
// 提示： 
//
// 
// 1 <= m, n <= 100 
// 题目数据保证答案小于等于 2 * 10 ^ 9 
// 
// Related Topics 数组 动态规划


package secondleetcode.leetcode.editor.cn;

public class S62UniquePaths {
    public static void main(String[] args) {
        Solution solution = new S62UniquePaths().new Solution();
        System.out.println(solution.uniquePaths(7, 3));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int uniquePaths(int m, int n) {
//            int[][] flag = new int[m][n];
            int[] flag = new int[n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if ( i == 0 || j == 0) {
                        flag[j] = 1;
                    } else {
                        flag[j] = flag[j] + flag[j - 1];
                    }
                }
            }
            return flag[n - 1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}