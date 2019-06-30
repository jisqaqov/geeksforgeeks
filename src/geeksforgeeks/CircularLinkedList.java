package geeksforgeeks;

/**
 * @author Jandos Iskakov
 * problem: Circular Linked List
 * algorithm: Linked List
 * time complexity: O(N)
 * space complexity: O(1)
 */
public class CircularLinkedList {

    public static void main(String[] args) {
        CircularLinkedList solution = new CircularLinkedList();
        solution.test();
    }

    public void test() {
        Node tc1head = new Node(3);
        Node tc1node2 = new Node(2);
        Node tc1node0 = new Node(0);
        Node tc1nodeM4 = new Node(-4);

        tc1head.next = tc1node2;
        tc1node2.next = tc1node0;
        tc1node0.next = tc1nodeM4;
        tc1nodeM4.next = tc1head;

        System.out.println(isCircular(tc1head));

        tc1nodeM4.next = tc1node2;
        System.out.println(isCircularWithCycle(tc1head));
    }

    boolean isCircular(Node head) {
        if (head == null) {
            return true;
        }

        Node node = head;

        while (node != null) {
            node = node.next;

            if (node == head) {
                return true;
            }
        }

        return false;
    }

    boolean isCircularWithCycle(Node head) {
        Node p = head;
        Node q = head;

        Node t = null;

        while (p != null && q != null) {
            p = p.next;
            q = q.next != null? q.next.next: null;

            if (p == q) {
                t = p;
                break;
            }
        }

        if (t == null) {
            return false;
        }

        p = head;
        q = t;

        while (p != q) {
            p = p.next;
            q = q.next;
        }

        return p == head;
    }

    /* Structure of LinkedList*/
    class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

}
