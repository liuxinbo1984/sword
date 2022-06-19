package chapter04;

public class LinkedList {
    public static void main(String[] args) {

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
        StringBuilder sb = new StringBuilder();
        while (head != null) {
            sb.append(head.val).append("->");
            head = head.next;
        }
        sb.append("NULL");
        System.out.println(sb.toString());
        System.out.println();
    }

    private static class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
}
