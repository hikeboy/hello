//假设你正在爬楼梯。需要 n 阶你才能到达楼顶。 
//
// 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？ 
//
// 注意：给定 n 是一个正整数。 
//
// 示例 1： 
//
// 输入： 2
//输出： 2
//解释： 有两种方法可以爬到楼顶。
//1.  1 阶 + 1 阶
//2.  2 阶 
//
// 示例 2： 
//
// 输入： 3
//输出： 3
//解释： 有三种方法可以爬到楼顶。
//1.  1 阶 + 1 阶 + 1 阶
//2.  1 阶 + 2 阶
//3.  2 阶 + 1 阶
// 
// Related Topics 动态规划


package leetcode.editor.cn;

public class N70ClimbingStairs {
    public static void main(String[] args) {
        Solution solution = new N70ClimbingStairs().new Solution();
        System.out.println(solution.climbStairs(2));
        System.out.println(solution.climbStairs(3));
        System.out.println(solution.climbStairs(4));
        System.out.println(solution.climbStairs(5));
        System.out.println(solution.climbStairs(6));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int climbStairs(int n) {
            int N_1 = 1, N_2 = 2, N=1;
            for (int i = 1; i <= n; i++) {
                if (i == 1) {
                    N = N_1;
                } else if (i == 2) {
                    N = N_2;
                } else {
                    N = N_1 + N_2;
                    N_1 = N_2;
                    N_2 = N;
                }
            }
            return N;
//            if (n == 1) {
//                return 1;
//            } else if (n == 2) {
//                return 2;
//            }
//            return climbStairs(n - 1) + climbStairs(n - 2);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}