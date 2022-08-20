package chapter04;

// 链表中的数字相加
public class Meet25 {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3};
        ListNode head1 = null;
        for (int i = 0; i < arr.length; i++) {
            head1 = append(head1, arr[i]);
        }
        printList(head1);

        arr = new int[]{3, 1};
        ListNode head2 = null;
        for (int i = 0; i < arr.length; i++) {
            head2 = append(head2, arr[i]);
        }
        printList(head2);

        ListNode twoNumbersHead = addTwoNumbers(head1, head2);
        printList(twoNumbersHead);
    }

    public static ListNode addTwoNumbers(ListNode head1, ListNode head2) {
        head1 = reversedList(head1);
        head2 = reversedList(head2);
        printList(head1);
        printList(head2);

        ListNode reversedHead = addReversedList(head1, head2);
        return reversedList(reversedHead);
    }

    public static ListNode addReversedList(ListNode head1, ListNode head2) {
        ListNode dummy = new ListNode(0);
        ListNode sumNode = dummy;

        int carry = 0;
        while (head1 != null || head2 != null) {
            int sum = (head1 == null ? 0 : head1.val) + (head2 == null ? 0 : head2.val) + carry;
            carry = sum >= 10 ? 1 : 0;
            sum = sum >= 10 ? sum - 10 : sum;
            ListNode newNode = new ListNode(sum);
            sumNode.next = newNode;
            sumNode = newNode;

            head1 = head1 == null ? null : head1.next;
            head2 = head2 == null ? null : head2.next;
        }

        if (carry > 0) {
            sumNode.next = new ListNode(carry);
        }

        return dummy.next;
    }

    // 反转链表
    public static ListNode reversedList(ListNode head) {
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
            sb.append(head.val);
            sb.append("->");
            head = head.next;
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
