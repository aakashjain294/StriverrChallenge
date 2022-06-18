package LinkedList;

public class q15 {
    public class Node {
        int data = 0;
        Node next = null;
        Node bottom = null;

        Node(int data) {
            this.data = data;
        }
    }

    // Flattening a Linked List

    public Node middle(Node head) {
        if (head == null || head.bottom == null)
            return head;
        Node fast = head;
        Node slow = head;
        while (fast.bottom != null && fast.bottom.bottom != null) {
            fast = fast.bottom.bottom;
            slow = slow.bottom;
        }
        return slow;
    }

    public Node mergeTwoLists(Node l1, Node l2) {
        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }
        Node dummy = new Node(-1);
        Node dp = dummy;
        Node c1 = l1;
        Node c2 = l2;
        while (c1 != null && c2 != null) {
            if (c1.data < c2.data) {
                dp.bottom = c1;
                c1 = c1.bottom;
            } else {
                dp.bottom = c2;
                c2 = c2.bottom;
            }
            dp = dp.bottom;
        }
        dp.bottom = c1 != null ? c1 : c2;
        return dummy.bottom;
    }

    public Node mergeSort(Node head) {
        if (head == null || head.bottom == null) {
            return head;
        }
        Node midNode = middle(head);
        Node nhead = midNode.bottom;
        midNode.bottom = null;
        Node left = mergeSort(head);
        Node right = mergeSort(nhead);

        return mergeTwoLists(left, right);
    }

    Node convert(Node root) {
        Node temp = root;
        Node dummy = new Node(-1);
        Node dp = dummy;
        while (temp != null) {
            Node curr = temp;
            while (curr != null) {
                Node node = new Node(curr.data);
                dp.bottom = node;
                dp = dp.bottom;
                curr = curr.bottom;
            }
            temp = temp.next;
        }
        return dummy.bottom;
    }

    Node flatten(Node root) {
        if (root == null)
            return null;
        Node head = convert(root);
        return mergeSort(head);
    }
}
