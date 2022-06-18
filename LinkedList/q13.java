package LinkedList;

public class q13 {
    public class ListNode {
        ListNode next = null;
        int val = 0;

        ListNode(int val) {
            this.val = val;
        }
    }
    public int len(ListNode head){
        if(head == null)
            return 0;
        
        int len = 0;
        ListNode curr = head;
        while(curr != null){
            len++;
            curr = curr.next;
        }
        return len;
    }
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null || k == 0){
            return head;
        }
        int len = len(head);
        k %= len;
        int n = len - k;
        ListNode dum1 = new ListNode(-1);
        ListNode d1 = dum1;
        ListNode dum2 = new ListNode(-1);
        ListNode d2 = dum2;
        ListNode curr = head;
        while(n-- >= 1){
            ListNode forw = curr.next;
            d1.next = curr;
            d1 = d1.next;
            curr.next = null;
            curr = forw;
        }
        while(curr != null){
            ListNode forw = curr.next;
            d2.next = curr;
            d2 = d2.next;
            curr.next = null;
            curr = forw; 
        }
        d2.next = dum1.next;
        dum1.next = null;
        return dum2.next;
    }
}
