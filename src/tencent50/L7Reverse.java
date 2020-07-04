package tencent50;

//给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
public class L7Reverse {
    public static int reverse(int x) {
        long y = 0;
        long a;
        if (x > 0) {
            a = x;
        } else {
            a = -x;
        }
        while (a > 0) {
            y = y * 10 + a % 10;
            if (y > Integer.MAX_VALUE || y < Integer.MIN_VALUE) {
                return 0;
            }
            a = a / 10;
        }
        if (x < 0) {
            y = -y;
        }
        return (int) y;
    }

    /**
     * 如果不允许使用long型？
     * <p>
     * <p>
     * java解法 超越100%用户， ~~!
     * <p>
     * public int reverse(int x) {
     * int ans = 0;
     * while (x != 0) {
     * if ((ans * 10) / 10 != ans) { 注意能够这样判断的根本原因是最大的整数2147483647第一位是2 所以(ans * 10)没有溢出则ans * 10 + x % 10;也会不溢出  如果最大的整数是7147483642 7>2 则不能这样判断
     * ans = 0;
     * break;
     * }
     * ans = ans * 10 + x % 10;
     * x = x / 10;* 	}
     * return ans;
     * }
     *
     * @param args
     */

    public static void main(String[] args) {
        System.out.println(reverse(123) == 321);
        System.out.println(reverse(-789) == -987);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(reverse(Integer.MAX_VALUE));
        System.out.println(Integer.MIN_VALUE);
        System.out.println(reverse(Integer.MIN_VALUE));
    }
}
