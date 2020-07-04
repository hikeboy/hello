//将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
//
// 
//
// 示例： 
//
// 输入：1->2->4, 1->3->4
//输出：1->1->2->3->4->4
// 
// Related Topics 链表

  
package secondleetcode.leetcode.editor.cn;

import tencent50.helper.ListNode;
import tencent50.helper.ListNodeUtil;

public class S21MergeTwoSortedLists{
      public static void main(String[] args) {
           Solution solution = new S21MergeTwoSortedLists().new Solution();
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
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {

    /**
     * 递归法
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
return null;
    }

    /**
     * 循环法
     * @param l1
     * @param l2
     * @return
     */
//    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//        if (l1 == null) {
//            return l2;
//        }
//        if (l2 == null) {
//            return l1;
//        }
//        ListNode head = new ListNode(-1);
//        ListNode node = head;
//        while (l1 != null && l2 != null) {
//            if (l1.val < l2.val) {
//                node.next = l1;
//                l1 = l1.next;
//            } else {
//                node.next = l2;
//                l2 = l2.next;
//            }
//            node = node.next;
//        }
//        if (l1 != null) {
//            node.next = l1;
//        } else if (l2 != null) {
//            node.next = l2;
//        }
//        return head.next;
//    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }