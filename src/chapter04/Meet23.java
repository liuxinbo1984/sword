package chapter04;

// 两个链表的第一个重合节点
// 1-->2-->3
//          \
//          4-->5-->6
//          /
//     7-->8

public class Meet23 {
    public static void main(String[] args) {
        ListNode headA = null;
        for (int i = 1; i < 7; i++) {
            headA = append(headA, i);
        }
        printList(headA);

        ListNode headB = null;
        int[] arrB = new int[]{7, 8, 4, 5, 6};
        for (int i = 0; i < arrB.length; i++) {
            headB = append(headB, arrB[i]);
        }
        printList(headB);

        ListNode intersectionNode = getIntersectionNode(headA, headB);
        if (intersectionNode != null) {
            System.out.println("intersection node is: " + intersectionNode.val);
        } else {
            System.out.println("no intersection");
        }
    }

    // 双栈法
    // 使用【对齐法】
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int count1 = countList(headA);
        int count2 = countList(headB);

        int delta = Math.abs(count1 - count2);
        ListNode longer = count1 > count2 ? headA : headB;
        ListNode shorter = count1 > count2 ? headB : headA;

        ListNode node1 = longer;
        for (int i = 0; i < delta; i++) {
            node1 = longer.next;
        }

        ListNode node2 = shorter;
        // 没有实现两链表重叠，所以比较值近似
        while (node1.val != node2.val) {
            node2 = node2.next;
            node1 = node1.next;
        }

        return node1;
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

    private static int countList(ListNode head) {
        int count = 0;
        while (head != null) {
            count++;
            head = head.next;
        }
        return count;
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
