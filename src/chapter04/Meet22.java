package chapter04;

// 链表中环的入口检测
public class Meet22 {
    public static void main(String[] args) {
        ListNode head = null;
        for (int i = 1; i < 7; i++) {
            head = append(head, i);
        }
        // 1->2->3->4->5->6->null
        //

        linkCircle(head, 3, 6);
        //        --------
        //       |        |
        // 1->2->3->4->5->6->null
        ListNode enterNode = detectCycle(head);
        System.out.println("enter node value: " + enterNode.val);
        enterNode = detectCycle2(head);
        System.out.println("no count, enter node value: " + enterNode.val);
    }

    // 找到环中节点：快慢指针
    private static ListNode getNodeInLoop(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode slow = head.next;
        ListNode fast = slow.next;
        while (slow != null && fast != null) {
            if (slow == fast) {
                return slow;
            }
            slow = slow.next;
            fast = fast.next;
            if (fast != null) {
                // 快指针再多走一步
                fast = fast.next;
            }
        }
        return null;
    }

    // 通过环节点数量
    public static ListNode detectCycle(ListNode head) {
        ListNode inLoop = getNodeInLoop(head);
        if (inLoop == null) {
            return null;
        }

        int loopCount = 1;
        for (ListNode n = inLoop; n.next != inLoop; n = n.next) {
            loopCount++;
        }

        ListNode fast = head;
        for (int i = 0; i < loopCount; i++) {
            fast = fast.next;
        }

        ListNode slow = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    // 不需要知道环节点数量
    public static ListNode detectCycle2(ListNode head) {
        ListNode inLoop = getNodeInLoop(head);
        if (inLoop == null) {
            return null;
        }

        ListNode node = head;
        while (node != inLoop) {
            node = node.next;
            inLoop = inLoop.next;
        }
        return node;
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

    public static void linkCircle(ListNode head, int start, int end) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode node = dummy;

        // TODO: start <= end <= linkedlist's size
        for (int i = 1; i <= start; i++) {
            node = node.next;
        }

        ListNode startNode = node;
        System.out.println("startNode: " + startNode.val);
        for (int i = start + 1; i <= end; i++) {
            node = node.next;
        }
        ListNode endNode = node;
        System.out.println("endNode: " + endNode.val);

        // 连接成环，没有进行校验
        endNode.next = startNode;
        System.out.println("endNode link to startNode as circle");
    }

    private static class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
}
