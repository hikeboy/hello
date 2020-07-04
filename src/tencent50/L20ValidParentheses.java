//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。 
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 
//
// 注意空字符串可被认为是有效字符串。 
//
// 示例 1: 
//
// 输入: "()"
//输出: true
// 
//
// 示例 2: 
//
// 输入: "()[]{}"
//输出: true
// 
//
// 示例 3: 
//
// 输入: "(]"
//输出: false
// 
//
// 示例 4: 
//
// 输入: "([)]"
//输出: false
// 
//
// 示例 5: 
//
// 输入: "{[]}"
//输出: true 
// Related Topics 栈 字符串


package tencent50;

import java.util.Stack;

public class L20ValidParentheses {
    public static void main(String[] args) {
        Solution solution = new L20ValidParentheses().new Solution();
        System.out.println(solution.isValid("{[]}"));
        System.out.println(solution.isValid("([)]"));
        System.out.println(solution.isValid("){"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public boolean isValid(String s) {
            if (s == null || s.length() < 2) {
                return false;
            }
            Stack<Character> stack = new Stack();
            for (int i = 0; i < s.length(); i++) {
                if (isLeft(s.charAt(i))) {
                    stack.push(s.charAt(i));
                } else {
                    if (stack.empty()) { //不判空无法通过用例"){"
                        return false;
                    }
                    Character cr = stack.peek();
                    if (isMath(cr, s.charAt(i))) {
                        stack.pop();
                    } else {
                        return false;
                    }
                }
            }
            return stack.empty();
        }

        private boolean isLeft(Character cr) {
            return '(' == cr || '[' == cr || '{' == cr;
        }

        private boolean isRight(Character cr) {
            return ')' == cr || ']' == cr || '}' == cr;
        }

        private boolean isMath(Character a, Character b) {
            switch (a) {
                case '(':
                    return b == ')';
                case '[':
                    return b == ']';
                case '{':
                    return b == '}';
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}