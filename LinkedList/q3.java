package LinkedList;

public class q3 {
    // 445. Add Two Numbers II
    public class ListNode {
        ListNode next = null;
        int val = 0;

        ListNode(int val) {
            this.val = val;
        }
    }

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
        ListNode head = reverse(l1);
        ListNode nhead = reverse(l2);
        ListNode c1 = head;
        ListNode c2 = nhead;
        ListNode dummy = new ListNode(-1);
        ListNode dp = dummy;
        int carry = 0;
        while (c1 != null || c2 != null || carry != 0) {
            int sum = carry + (c1 == null ? 0 : c1.val) + (c2 == null ? 0 : c2.val);
            carry = sum / 10;
            ListNode node = new ListNode(sum % 10);
            dp.next = node;
            if (c1 != null)
                c1 = c1.next;
            if (c2 != null)
                c2 = c2.next;
            dp = dp.next;
        }
        l1 = reverse(l1);
        l2 = reverse(l2);
        ListNode ans = dummy.next;
        dummy.next = null;
        return reverse(ans);
    }
}
