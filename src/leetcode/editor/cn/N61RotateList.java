//给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。 
//
// 示例 1: 
//
// 输入: 1->2->3->4->5->NULL, k = 2
//输出: 4->5->1->2->3->NULL
//解释:
//向右旋转 1 步: 5->1->2->3->4->NULL
//向右旋转 2 步: 4->5->1->2->3->NULL
// 
//
// 示例 2: 
//
// 输入: 0->1->2->NULL, k = 4
//输出: 2->0->1->NULL
//解释:
//向右旋转 1 步: 2->0->1->NULL
//向右旋转 2 步: 1->2->0->NULL
//向右旋转 3 步: 0->1->2->NULL
//向右旋转 4 步: 2->0->1->NULL 
// Related Topics 链表 双指针


package leetcode.editor.cn;

import tencent50.helper.ListNode;
import tencent50.helper.ListNodeUtil;

public class N61RotateList {
    public static void main(String[] args) {
        Solution solution = new N61RotateList().new Solution();
        ListNode head = ListNodeUtil.buildListNode(new int[]{1, 2, 3, 4, 5});
        ListNodeUtil.printList(solution.rotateRight(head, 2));
        ListNode head2 = ListNodeUtil.buildListNode(new int[]{1, 2, 3, 4, 5});
        ListNodeUtil.printList(solution.rotateRight(head2, 5));
        ListNode head3 = ListNodeUtil.buildListNode(new int[]{1, 2, 3, 4, 5});
        ListNodeUtil.printList(solution.rotateRight(head3, 7));

        ListNode head4 = ListNodeUtil.buildListNode(new int[]{});
        ListNodeUtil.printList(solution.rotateRight(head4, 1));
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
        public ListNode rotateRight(ListNode head, int k) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode end = head;
            int len = 1;
            while (end.next != null) {
                len++;
                end = end.next;
            }
//            k = len % k; 写反了
            k = k % len;
            if (k == 0) {
                return head;
            }
            k = len - k;
            ListNode mid = head;
            while (k > 1) {
                mid = mid.next;
                k--;
            }
            end.next = head;
            head = mid.next;
            mid.next = null;
            return head;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}