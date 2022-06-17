package LinkedList;

public class q8 {
    public class ListNode {
        ListNode next = null;
        int val = 0;

        ListNode(int val) {
            this.val = val;
        }
    }

    public int len(ListNode head) {
        if (head == null)
            return 0;

        int len = 0;
        ListNode curr = head;
        while (curr != null) {
            len++;
            curr = curr.next;
        }
        return len;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null)
            return headA == null ? headB : headA;
        int l1 = len(headA);
        int l2 = len(headB);
        int k = Math.abs(l1 - l2);
        ListNode fast = (l1 >= l2 ? headA : headB);
        ListNode slow = (l1 < l2 ? headA : headB);
        while (k-- > 0) {
            fast = fast.next;
        }
        while (fast != null) {
            if (fast == slow) {
                return fast;
            }
            fast = fast.next;
            slow = slow.next;
        }
        return null;
    }
}
