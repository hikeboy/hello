//给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。 
//
// 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。 
//
// 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。 
//
// 示例： 
//
// 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
//输出：7 -> 0 -> 8
//原因：342 + 465 = 807
// 
// Related Topics 链表 数学


package leetcode.editor.cn;

import tencent50.helper.ListNode;

public class N2AddTwoNumbers {
    public static void main(String[] args) {
        Solution solution = new N2AddTwoNumbers().new Solution();

    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            if (l1 == null) {
                return l2;
            }
            if (l2 == null) {
                return l1;
            }
            ListNode head = new ListNode(0); //哑节点避免第一个数相加要放在循环前写一遍重复
            ListNode node = head;
            ListNode h1 = l1, h2 = l2;
            int carry = 0;
            while (h1 != null || h2 != null) {//注意不是&&
                int num1 = (h1 == null) ? 0 : h1.val; //简化掉后续2个h1和h2的单独循环
                int num2 = (h2 == null) ? 0 : h2.val;
                int sum = num1 + num2 + carry;
                ListNode tempNode = new ListNode(sum % 10);
                carry = sum / 10;
                node.next = tempNode;
                node = node.next;
//                h1 = h1.next; 注意判空
//                h2 = h2.next;
                if (h1 != null) {
                    h1 = h1.next;
                }
                if (h2 != null) {
                    h2 = h2.next;
                }
            }
            if (carry > 0) {
                node.next = new ListNode(carry);
            }
            return head.next;
        }
//leetcode submit region end(Prohibit modification and deletion)

//    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        if (l1 == null) {
//            return l2;
//        }
//        if (l2 == null) {
//            return l1;
//        }
//        ListNode head;
//        ListNode h1 = l1;
//        ListNode h2 = l2;
//        int sum = h1.val + h2.val;
//        ListNode node = new ListNode(sum % 10);
//        head = node;
//        int carry = sum / 10;
//        h1 = h1.next;
//        h2 = h2.next; // 代码过于复杂 可以采用哑节点法简化
//        while (h1 != null && h2 != null) {
//            sum = h1.val + h2.val + carry;
//            ListNode tempNode = new ListNode(sum % 10);
//            node.next = tempNode;
//            node = node.next;
//            carry = sum / 10;
//            h1 = h1.next;
//            h2 = h2.next;
//        }
//        while (h1 != null) { //可以采用！=null则值为0来简化代码
//            sum = h1.val + carry;
//            ListNode tempNode = new ListNode(sum % 10);
//            node.next = tempNode;
//            node = node.next;
//            carry = sum / 10;
//            h1 = h1.next;
//        }
//        while (h2 != null) {
//            sum = h2.val + carry;
//            ListNode tempNode = new ListNode(sum % 10);
//            node.next = tempNode;
//            node = node.next;
//            carry = sum / 10;
//            h2 = h2.next;
//        }
//
//        if (carry > 0) {// 这里忘记会无法通过5+5 期望0，1 实际为0的用例
//            ListNode tempNode = new ListNode(carry);
//            node.next = tempNode;
//        }
//        return head;
//    }
    }
}