package tencent50;

import tencent50.helper.ListNode;
import tencent50.helper.ListNodeUtil;

public class L2AddTwoNumber {

//    public static ListNode addTwoNumber1(ListNode l1, ListNode l2) {
//        if (l1 == null) {
//            return l2;
//        }
//        if (l2 == null) {
//            return l1;
//        }
//        ListNode node1 = l1;
//        ListNode node2 = l2;
//        ListNode result = new ListNode(0);
//        ListNode node = result;
//        int carry = 0;
//        while (node1 != null && node2 != null) {
//            int sum = node1.val + node2.val + carry;
//            node.next = new ListNode(sum % 10);
//            node = node.next;
//            carry = sum / 10;
//            node1 = node1.next;
//            node2 = node2.next;
//        }
//
//        if (node1 != null) {
//            node.next = node1;
//            while (node1 != null) {
//                int sum = node1.val + carry;
//                if (sum < 10) {
//                    node1.val = sum;
//                    break;
//                }
//                carry = sum / 10;
//                node1.val = sum % 10;
//                node1 = node1.next;
//            }
//        }
//
//        if (node2 != null) {
//            node.next = node2;
//            while (node2 != null) {
//                int sum = node2.val + carry;
//                if (sum < 10) {
//                    node2.val = sum;
//                    break;
//                }
//                carry = sum / 10;
//                node2.val = sum % 10;
//                node2 = node2.next;
//            }
//        }
//
//        /**
//         * 错误1，最后结果大于2数长度
//             错误2, 如果走入了 if (node2 != null)分分支，这里会覆盖掉 node.next = node2的结果
//         */
//        if (carry > 0) {
//            node.next = new ListNode(carry);
//        }
//
//        return result.next;
//    }

    public static ListNode addTwoNumber(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode node1 = l1;
        ListNode node2 = l2;
        ListNode result = new ListNode(0);
        ListNode node = result;
        int carry = 0;
        while (node1 != null && node2 != null) {
            int sum = node1.val + node2.val + carry;
            node.next = new ListNode(sum % 10);
            node = node.next;
            carry = sum / 10;
            node1 = node1.next;
            node2 = node2.next;
        }


        while (node1 != null) {
            int sum = node1.val + carry;
            node.next = new ListNode(sum % 10);
            node = node.next;
            carry = sum / 10;
            node1 = node1.next;
        }

        while (node2 != null) {
            int sum = node2.val + carry;
            node.next = new ListNode(sum % 10);
            node = node.next;
            carry = sum / 10;
            node2 = node2.next;
        }

        if (carry > 0) {
            node.next = new ListNode(carry);
        }

        return result.next;
    }

    public static void main(String[] args) {
        System.out.println(testAddTwoNumber(null, new int[]{5, 6, 4}, "5->6->4"));
        System.out.println(testAddTwoNumber(new int[]{2, 4, 3}, new int[]{5, 6, 4}, "7->0->8"));
        System.out.println(testAddTwoNumber(new int[]{6, 4, 3}, new int[]{5, 6, 4}, "1->1->8"));
        System.out.println(testAddTwoNumber(new int[]{6, 4, 3}, new int[]{5, 6, 7}, "1->1->1->1"));
        System.out.println(testAddTwoNumber(new int[]{6, 4, 3}, new int[]{5, 6, 7, 9, 9}, "1->1->1->0->0->1"));

    }

    public static boolean testAddTwoNumber(int[] input1, int[] input2, String resultStr){
        ListNode node1 = ListNodeUtil.buildListNode(input1);
        ListNode node2 = ListNodeUtil.buildListNode(input2);
        ListNode result = addTwoNumber(node1, node2);
        ListNodeUtil.printList(result);
        System.out.print(":");
        return ListNodeUtil.getString(result).equals(resultStr);
    }
}
