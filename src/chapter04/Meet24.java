package chapter04;

// 反转链表
public class Meet24 {
    public static void main(String[] args) {
        int[] arr = new int[]{7, 8, 4, 5, 6};
        ListNode head = null;
        for (int i = 0; i < arr.length; i++) {
            head = append(head, arr[i]);
        }
        printList(head);

        ListNode reverseList = reverseList(head);

        printList(reverseList);
    }

    // 反转链表
    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    public static ListNode append(ListNode head, int value) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode newNode = new ListNode(value);
        ListNode node = dummy;
        while (node.next != null) {
            node = node.next;
        }
        node.next = newNode;
        return dummy.next;
    }

    private static void printList(ListNode head) {
        StringBuilder sb = new StringBuilder();
        while (head != null) {
            sb.append(head.val).append("->");
            head = head.next;
        }
        sb.append("NULL");
        sb.append("\n");
        System.out.println(sb.toString());
    }

    private static class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
}
