package LinkedList;

public class q11 {
    public class ListNode {
        ListNode next = null;
        int val = 0;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode forw = curr.next;
            curr.next = prev;
            prev = curr;
            curr = forw;
        }
        return prev;
    }

    public ListNode mid(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public boolean isPalindrome(ListNode head) {
        if (head.next == null)
            return true;
        ListNode midNode = mid(head);
        ListNode nhead = midNode.next;
        midNode.next = null;
        nhead = reverse(nhead);
        ListNode c1 = head;
        ListNode c2 = nhead;
        while (c2 != null) {
            if (c1.val != c2.val)
                return false;
            c1 = c1.next;
            c2 = c2.next;
        }
        return true;
    }
}
