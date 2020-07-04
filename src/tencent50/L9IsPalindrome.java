package tencent50;

public class L9IsPalindrome {


    /**
     * 思路一： 求得正数多少位len  然后挨个比较首尾两数
     *
     * @param x
     * @return
     */
    public static boolean isPalindrome1(int x) {
        if (x < 0) {
            return false;
        }
        if (x < 10) {
            return true;
        }
        int len = 1;//不能从10开始
        int a = x;
        while (a >= 10) { //不是>10 否则无法通过用例   更不是>1
            len *= 10;
            a = a / 10;
        }
        int grow = 10;
        int left, rgiht;
        int temp = x;
        while (grow <= len) {  // 无等于号无法通过用例x = 10
            rgiht = x % 10;
            // left = x / len;  // 无法通过用例 76067
            left = temp / len;
            if (rgiht != left) {
                return false;
            }
            x = x / 10;
            temp = temp % len;  //7606 时 right=6  left 不应该是7
            grow *= 10;
            len /= 10;
        }
        return true;
    }

    /**
     * 思路1更优雅的一个实现
     *
     * @param x
     * @return
     */
    public static boolean isPalindrome3(int x){
        //negative number
        if(x < 0)
                return false;

        int len = 1;
         while(x / len >= 10)
                 len *= 10;

         while(x > 0)    {

                 //get the head and tail number
                 int left = x / len;
                 int right = x % 10;

                 if(left != right)
                         return false;
                 else    {
                         //remove the head and tail number
                         x = (x % len) / 10;
                         len /= 100;
                     }
             }

         return true;
    }

    /**
     *  思路2： 求x翻转后的值 与x 比较是否相等即可
     * @param x
     * @return
     */
    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        if (x < 10) {
            return true;
        }
        int a = x;
        int y = 0;
        while (a > 0) {
            y = y*10 + a %10;
            a /= 10;
        }

        return y == x;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome3(121) == true);
        System.out.println(isPalindrome3(0) == true);
        System.out.println(isPalindrome3(1) == true);
        System.out.println(isPalindrome3(-121) == false);
        System.out.println(isPalindrome3(10) == false);
        System.out.println(isPalindrome3(313) == true);
        System.out.println(isPalindrome3(76067) == true);
        System.out.println(isPalindrome3(761167) == true);
    }
}
