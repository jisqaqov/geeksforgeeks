package geeksforgeeks;

/**
 * @author Jandos Iskakov
 * problem: Remove loop in Linked List
 * link to problem: https://practice.geeksforgeeks.org/problems/remove-loop-in-linked-list/1
 * algorithm: Two Pointer, Linked List
 * time complexity: O(N)
 * space complexity: O(1)
 */
public class RemoveLoopInLinkedList {

    public void removeTheLoop(Node head) {
        Node p = head;
        Node q = head;

        Node t = null;

        while (p != null && q != null) {
            p = p.next;
            q = q.next != null ? q.next.next : null;

            if (p == q) {
                t = p;
                break;
            }
        }

        if (t == null) {
            return;
        }

        p = head;
        q = t;

        Node tail = q;

        while (p != q) {
            tail = q;
            p = p.next;
            q = q.next;
        }

        tail.next = null;
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
