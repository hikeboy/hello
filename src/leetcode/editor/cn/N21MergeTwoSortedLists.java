//将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
//
// 示例： 
//
// 输入：1->2->4, 1->3->4
//输出：1->1->2->3->4->4
// 
// Related Topics 链表


package leetcode.editor.cn;

import tencent50.helper.ListNode;
import tencent50.helper.ListNodeUtil;

public class N21MergeTwoSortedLists {
    public static void main(String[] args) {
        Solution solution = new N21MergeTwoSortedLists().new Solution();
        ListNode node1 = ListNodeUtil.buildListNode(new int[]{1,2,4});
        ListNode node2 = ListNodeUtil.buildListNode(new int[]{1,3,4});
        ListNodeUtil.printList(node1);
        ListNodeUtil.printList(node2);
        ListNodeUtil.printList(solution.mergeTwoLists(node1, node2));
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
        //递归法
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            if(l1 == null) {
                return l2;
            }
            if(l2 == null) {
                return l1;
            }

            if(l1.val < l2.val) {
                l1.next = mergeTwoLists(l1.next, l2);
                return l1;
            } else {
                l2.next = mergeTwoLists(l1, l2.next);
                return l2;
            }
        }
        //循环法
//        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//            if (l1 == null) {
//                return l2;
//            }
//            if (l2 == null) {
//                return l1;
//            }
//            ListNode header = new ListNode(0);
//            ListNode node = header;
//            while (l1 != null && l2 != null) {
//                if (l1.val < l2.val) {
//                    node.next = l1;
//                    l1 = l1.next;
//                } else {
//                    node.next = l2;
//                    l2 = l2.next;
//                }
//                node = node.next;
//            }
//            if (l1 != null) {
//                node.next = l1;
//            } else if (l2 != null) {
//                node.next = l2;
//            }
//            return header.next;
//        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}