package LinkedList;

public class q7 {
    public class ListNode {
        ListNode next = null;
        int val = 0;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null || list2 == null)
            return list1 == null ? list2 : list1;
        ListNode dummy = new ListNode(-1);
        ListNode dp = dummy;
        ListNode c1 = list1, c2 = list2;
        while (c1 != null && c2 != null) {
            if (c1.val < c2.val) {
                dp.next = c1;
                c1 = c1.next;
            } else {
                dp.next = c2;
                c2 = c2.next;
            }
            dp = dp.next;
        }
        if (c1 != null) {
            dp.next = c1;
        }
        if (c2 != null) {
            dp.next = c2;
        }
        return dummy.next;
    }
}
