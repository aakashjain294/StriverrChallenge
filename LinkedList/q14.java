package LinkedList;

public class q14 {
    public class Node {
        Node next = null;
        int val = 0;
        Node random = null;
        Node(int val) {
            this.val = val;
        }
    }

    public void copyList(Node head) {
        Node curr = head;
        while (curr != null) {
            Node forw = curr.next;
            Node node = new Node(curr.val);
            curr.next = node;
            node.next = forw;
            curr = forw;
        }
    }

    public void copyRandomPointer(Node head) {
        Node curr = head;
        while (curr != null) {
            Node random = curr.random;
            if (random != null) {
                curr.next.random = random.next;
            }
            curr = curr.next.next;
        }
    }

    public Node extractList(Node head) {
        Node curr = head;
        Node dummy = new Node(-1);
        Node dp = dummy;
        while (curr != null) {
            dp.next = curr.next;
            curr.next = curr.next.next;

            dp = dp.next;
            curr = curr.next;
        }
        return dummy.next;
    }

    public Node copyRandomList(Node head) {
        copyList(head);
        copyRandomPointer(head);
        return extractList(head);
    }
}
