package tencent50.helper;


public class ListNodeUtil {
    public static ListNode buildListNode(int[] input) {
        if (input == null || input.length == 0) {
            return null;
        }
        ListNode result = new ListNode(0);
        ListNode node = result;
        for (int i : input) {
            node.next = new ListNode(i);
            node = node.next;
        }
        return result.next;
    }

    public static String printList(ListNode header) {
        String builder = getString(header);
        System.out.println(builder);
        return builder;
    }


    public static String getString(ListNode header) {
        ListNode node = header;
        StringBuilder builder = new StringBuilder();
        while (node != null) {
            if (node == header) {
                builder.append(node.val);
            } else {
                builder.append("->").append(node.val);
            }
            node = node.next;
        }
        return builder.toString();
    }
}
