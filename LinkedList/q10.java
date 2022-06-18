package LinkedList;

public class q10 {
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

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k < 1) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        ListNode dp = dummy;
        ListNode curr = head;
        while (curr != null) {
            int temp = k;
            ListNode forw = curr, nhead = null;
            while (temp > 1 && forw != null) {
                forw = forw.next;
                temp--;
            }
            if (forw != null) {
                nhead = forw.next;
                forw.next = null;
            } else {
                break;
            }
            dp.next = reverse(curr);
            curr = nhead;
            while (dp.next != null)
                dp = dp.next;
        }
        if (curr == head) {
            return reverse(curr);
        }
        if (curr != null) {
            dp.next = curr;
        }
        return dummy.next;
    }
}
