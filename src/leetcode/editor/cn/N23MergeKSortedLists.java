//合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。 
//
// 示例: 
//
// 输入:
//[
//  1->4->5,
//  1->3->4,
//  2->6
//]
//输出: 1->1->2->3->4->4->5->6 
// Related Topics 堆 链表 分治算法


package leetcode.editor.cn;

import tencent50.helper.ListNode;
import tencent50.helper.ListNodeUtil;

public class N23MergeKSortedLists {
    public static void main(String[] args) {
        Solution solution = new N23MergeKSortedLists().new Solution();
        ListNode[] listNode = new ListNode[]{ListNodeUtil.buildListNode(new int[]{1, 3, 5, 7}), ListNodeUtil.buildListNode(new int[]{2, 4, 6})};
        ListNodeUtil.printList(solution.mergeKLists(listNode));
        listNode = new ListNode[]{ListNodeUtil.buildListNode(new int[]{2}), ListNodeUtil.buildListNode(new int[]{2})};
        ListNodeUtil.printList(solution.mergeKLists(listNode));
        listNode = new ListNode[]{ListNodeUtil.buildListNode(new int[]{1, 3, 5, 7}), ListNodeUtil.buildListNode(new int[]{2, 4, 6}), ListNodeUtil.buildListNode(new int[]{2, 10})};
        ListNodeUtil.printList(solution.mergeKLists(listNode));

        listNode = new ListNode[]{ListNodeUtil.buildListNode(new int[]{}), ListNodeUtil.buildListNode(new int[]{})};
        ListNodeUtil.printList(solution.mergeKLists(listNode));
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
        //时间复杂度K*N  优化法：1，优先级队列，2递归22合并
        public ListNode mergeKLists(ListNode[] lists) {
            ListNode header = new ListNode(-1);
            ListNode preNode = header;
            ListNode[] nodes = new ListNode[lists.length];
            for (int i = 0; i < lists.length; i++) {
                nodes[i] = lists[i];
            }
            int count = lists.length;
            while (count > 0) {
                int minVal = Integer.MAX_VALUE;
                int minIndex = 0;
                for (int i = 0; i < lists.length; i++) {
                    if (nodes[i] != null && nodes[i].val < minVal) {
                        minIndex = i;
                        minVal = nodes[i].val;
                    }
                }
                if (count == 1) {
                    preNode.next = nodes[minIndex];
                    break;
                }
                preNode.next = nodes[minIndex];
                //nodes[minIndex] = nodes[minIndex].next; //无法通过用例 [[],[]]
                if (nodes[minIndex] != null) {
                    preNode = preNode.next;
                    nodes[minIndex] = nodes[minIndex].next;
                }
                if (nodes[minIndex] == null) {
                    count--;
                }
            }
            return header.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}