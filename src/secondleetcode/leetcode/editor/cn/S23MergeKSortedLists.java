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

  
package secondleetcode.leetcode.editor.cn;

import tencent50.helper.ListNode;
import tencent50.helper.ListNodeUtil;

import java.util.Comparator;
import java.util.PriorityQueue;

public class S23MergeKSortedLists{
      public static void main(String[] args) {
           Solution solution = new S23MergeKSortedLists().new Solution();
          ListNode[] listNode = new ListNode[]{ListNodeUtil.buildListNode(new int[]{1, 3, 5, 7}), ListNodeUtil.buildListNode(new int[]{2, 4, 6})};
          ListNodeUtil.printList(solution.mergeKLists(listNode));
          listNode = new ListNode[]{ListNodeUtil.buildListNode(new int[]{2}), ListNodeUtil.buildListNode(new int[]{2})};
          ListNodeUtil.printList(solution.mergeKLists(listNode));
          listNode = new ListNode[]{ListNodeUtil.buildListNode(new int[]{1, 3, 5, 7}), ListNodeUtil.buildListNode(new int[]{2, 4, 6}), ListNodeUtil.buildListNode(new int[]{2, 10})};
          ListNodeUtil.printList(solution.mergeKLists(listNode));

          listNode = new ListNode[]{ListNodeUtil.buildListNode(new int[]{}), ListNodeUtil.buildListNode(new int[]{})};
          ListNodeUtil.printList(solution.mergeKLists(listNode));
          listNode = new ListNode[]{};
          ListNodeUtil.printList(solution.mergeKLists(listNode));

      }
        //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {

    /**
     * 优先级队列法
     *
     */
//    public ListNode mergeKLists(ListNode[] lists) {
//        if (lists == null || lists.length == 0) {
//            return null;
//        }
//        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, new Comparator<ListNode>() {
//            @Override
//            public int compare(ListNode o1, ListNode o2) {
//                if (o1.val < o2.val) {
//                    return -1;
//                } else if (o1.val == o2.val) {
//                    return 0;
//                } else {
//                    return 1;
//                }
//            }
//        });
//        ListNode dummy = new ListNode(0);
//        ListNode p = dummy;
//        for (ListNode node: lists) {
//            if (node != null) {
//                queue.add(node);
//            }
//        }
//        while (!queue.isEmpty()) {
//            p.next = queue.poll();
//            p = p.next;
//            if (p.next != null) {
//                queue.add(p.next);
//            }
//        }
//        return dummy.next;
//    }

    /**
     * 分治算法
     * 解答成功: 执行耗时:3 ms,击败了83.29% 的Java用户 内存消耗:42.4 MB,击败了38.23% 的Java用户
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;//否则无法通过 [] 用例
        }
          return merge(lists, 0, lists.length -1);
    }

    public ListNode merge(ListNode[] lists, int left, int right) {
        if (left == right) {
            return lists[left];
        }
        int mid = (left + right) / 2;
        ListNode l1 = merge(lists, left, mid);
        ListNode l2 = merge(lists, mid+ 1, right);
        return mergeTwoLists(l1, l2);
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)

  }