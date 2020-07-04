//一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。 
//
// 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。 
//
// 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？ 
//
// 
//
// 网格中的障碍物和空位置分别用 1 和 0 来表示。 
//
// 说明：m 和 n 的值均不超过 100。 
//
// 示例 1: 
//
// 输入:
//[
//  [0,0,0],
//  [0,1,0],
//  [0,0,0]
//]
//输出: 2
//解释:
//3x3 网格的正中间有一个障碍物。
//从左上角到右下角一共有 2 条不同的路径：
//1. 向右 -> 向右 -> 向下 -> 向下
//2. 向下 -> 向下 -> 向右 -> 向右
// 
// Related Topics 数组 动态规划


package secondleetcode.leetcode.editor.cn;

public class S63UniquePathsIi {
    public static void main(String[] args) {
        Solution solution = new S63UniquePathsIi().new Solution();
        int[][] input = new int[][] {
                                      {0,0,0},
                                      {0,1,0},
                                      {0,0,0},
                                    };
//        int[][] input = new int[][] {
//                {0,0},
//                {1,1},
//                {0,0},
//        };
        System.out.println(solution.uniquePathsWithObstacles(input));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //优化空间
        public int uniquePathsWithObstacles(int[][] obstacleGrid) {
            int m = obstacleGrid.length;
            int n = obstacleGrid[0].length;
            if (obstacleGrid[0][0] == 1) {
                return 0;
            }
            int[] flag = new int[n];
            flag[0] = 1;
            /**
             * 下面的各种判断还是太繁琐，与62不同，62不想new 二维数组节省空间，
             * 本提可以直接用obstacleGrid 当flag 二维数组，不用白不要。
             */
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (obstacleGrid[i][j] == 1) {
                        flag[j] = 0;
                    } else if (i == 0 && j > 0){
                        flag[j] = flag[j -1];
                    } else if (i > 0 && j > 0) {
                        flag[j] = flag[j] + flag[j -1];
                    }
//                            flag[j] = 0;
//                    if (i == 0 && j ==0) {
//                        flag[j] = 1;
//                    } else if (i == 0) {
//                        if (obstacleGrid[i][j] == 1) {
//                            flag[j] = 0;
//                        } else {
//                            flag[j] = flag[j -1];
//                        }
//                    } else if (j == 0) {
//                        if (obstacleGrid[i][j] == 1) {
//                            flag[j] = 0;
//                        } else {
//                            flag[j] = 1;
//                        }
//                    } else {
//                        if (obstacleGrid[i][j] == 1) {
//                            flag[j] = 0;
//                        } else {
//                            flag[j] = flag[j] + flag[j -1];
//                        }
//                    }
                }
            }
            return flag[n - 1];
        }
//        public int uniquePathsWithObstacles(int[][] obstacleGrid) {
//            if (obstacleGrid[0][0] == 1) {
//                return 0;
//            }
//
//            int[][] flag = new int[obstacleGrid.length][obstacleGrid[0].length];
//            for (int i = 0; i < obstacleGrid.length; i++) {
//                for (int j = 0; j < obstacleGrid[0].length; j++) {
//                    if (obstacleGrid[i][j] == 1) {
//                        flag[i][j] = 0;
//                    } else if (i == 0 && j == 0){
//                        flag[i][j] = 1;
//                    }
//                    else if (i == 0) {
//                        flag[i][j] = flag[i][j - 1];
//                    } else if (j == 0 ) {
//                        flag[i][j] = flag[i - 1][j];
//                    } else {
//                        flag[i][j] = flag[i - 1][j] + flag[i][j - 1];
//                    }
//                }
//            }
//            return flag[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
//        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}