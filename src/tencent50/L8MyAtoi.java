package tencent50;

public class L8MyAtoi {

    public static int myAtoi(String str) {
       if (str == null) {
           return 0;
       }
       str = str.trim();
        // 一定要放在trim之后 否则无法通过" " 测试用例
       if (str.isEmpty()) {
           return 0;
       }
       boolean isNagetive = false;
       int i = 0;
       if (!Character.isDigit(str.charAt(0))) {
           // if ("-".equals(str.charAt(0))) 永远为fasle
           //正确:
           if ('-' == (str.charAt(0))) {
               isNagetive = true;
           } else if (!('+' == str.charAt(0))) {
               return 0;
           }
           i = 1;
       }

       long result = 0;
       for (; i < str.length(); i++) {
           if (!Character.isDigit(str.charAt(i))) {
               break;
           }
           result = result * 10 + str.charAt(i) - '0'; //  Character.digit() Integer.parseInt() 要高效

           if (result > Integer.MAX_VALUE) {
              break;
           }
       }

       if (isNagetive) {
           result = -result;
       }
       // 如果不用long型可以这样
        // if (base > Integer.MAX_VALUE / 10 || (base == Integer.MAX_VALUE / 10 && str.charAt(i) - '0' > 7)) {
        //            return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        //        }
        //————————————————
        //版权声明：本文为CSDN博主「java_liuguoyao」的原创文章，遵循 CC 4.0 BY-SA 版权协议，转载请附上原文出处链接及本声明。
        //原文链接：https://blog.csdn.net/java_liuguoyao/article/details/86633740
       if (result > Integer.MAX_VALUE) {
           return Integer.MAX_VALUE;
       }

       if (result < Integer.MIN_VALUE ) {
           return Integer.MIN_VALUE;
       }
       return (int) result;
    }

    public static void main(String[] args) {
        System.out.println(myAtoi("100") == 100);
        System.out.println(myAtoi("+100") == 100);
        System.out.println(myAtoi("-100") == -100);
        System.out.println(myAtoi(" - 100") == 0);
        System.out.println(myAtoi(" -100") == -100);
        System.out.println(myAtoi("4139 with words") == 4139);
        System.out.println(myAtoi("words and 4139") == 0);
        System.out.println(myAtoi("-91283472332") == -2147483648);
        System.out.println(myAtoi("91283472332") == 2147483647);
        System.out.println(myAtoi(   " ") == 0);

    }
}
