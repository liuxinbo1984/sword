package chapter04;

// 删除倒数第k个节点
public class Meet21 {
    public static void main(String[] args) {
        ListNode head = null;
        for (int i = 0; i < 7; i++) {
            head = append(head, i);
        }
        // 0->1->2->3->4->5->6->null
        printList(head);
        removeNthFromEnd(head, 3);
        // 0->1->2->3->5->6->null
        printList(head);
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode front = head, back = dummy;
        for (int i = 0; i < n; i++) {
            front = front.next;
        }

        while (front != null) {
            front = front.next;
            back = back.next;
        }

        if (back.next != null) {
            back.next = back.next.next;
        }

        return head;
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

    public static ListNode delete(ListNode head, int value) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode node = dummy;
        while (node.next != null) {
            if (node.next.val == value) {
                node.next = node.next.next;
                break;
            }
            node = node.next;
        }
        return dummy.next;
    }

    private static void printList(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode node = dummy;
        StringBuilder sb = new StringBuilder();
        while (node.next != null) {
            sb.append(node.next.val);
            sb.append("->");
            node = node.next;
        }
        sb.append("null");
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
