package LinkedList;

public class q2 {
    public class ListNode {
        ListNode next = null;
        int val = 0;

        ListNode(int val) {
            this.val = val;
        }
    }
    // leetcode 2. Add Two Numbers
    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode curr = head;
        ListNode prev = null;
        while (curr != null) {
            ListNode forw = curr.next;
            curr.next = prev;
            prev = curr;
            curr = forw;
        }
        return prev;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null)
            return l1 == null ? l2 : l1;
        ListNode c1 = l1;
        ListNode c2 = l2;
        ListNode dummy = new ListNode(-1);
        ListNode dp = dummy;
        int carry = 0;
        while (c1 != null || c2 != null || carry != 0) {
            int sum = carry + (c1 == null ? 0 : c1.val) + (c2 == null ? 0 : c2.val);
            carry = sum / 10;
            int digit = sum % 10;
            ListNode node = new ListNode(digit);
            dp.next = node;
            if (c1 != null)
                c1 = c1.next;
            if (c2 != null)
                c2 = c2.next;
            dp = dp.next;
        }

        return dummy.next;
    }
}
