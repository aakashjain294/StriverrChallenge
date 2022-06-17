package LinkedList;

public class q4 {
    // 19. Remove Nth Node From End of List
    public class ListNode {
        ListNode next = null;
        int val = 0;

        ListNode(int val) {
            this.val = val;
        }
    }

    public int len(ListNode head) {
        if (head == null) {
            return 0;
        }
        ListNode curr = head;
        int len = 0;
        while (curr != null) {
            len++;
            curr = curr.next;
        }
        return len;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || head.next == null)
            return null;
        int k = len(head) - n;
        ListNode dummy = new ListNode(-1);
        ListNode dp = dummy;
        ListNode curr = head;
        while (curr != null) {
            if (k-- != 0) {
                dp.next = curr;
                dp = dp.next;
                curr = curr.next;
            } else {
                break;
            }
        }
        dp.next = curr.next;
        dp = dp.next;
        curr.next = null;
        return dummy.next;
    }
}
