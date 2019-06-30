package geeksforgeeks;

public class CheckIfLinkedListIsPalindrome {

  private Node head = null;

  public boolean isPalindrome(Node head) {
    if (head == null) {
      return true;
    }

    this.head = head;

    Node node = head;
    int n = 0;
    while (node != null) {
      n++;
      node = node.next;
    }

    return isPalindrome(head, 1, n);
  }

  public boolean isPalindrome(Node node, int i, int n) {
    if (i < n) {
      if (!isPalindrome(node.next, i + 1, n)) {
        return false;
      }
    }

    if (i <= n / 2) {
      return true;
    }

    if (node.data != head.data) {
      return false;
    }

    head = head.next;

    return true;
  }

  /*This is a function problem.You only need to complete the function given below*/
  /* Structure of class Node is*/
  class Node {

    int data;
    Node next;

    Node(int d) {
      data = d;
      next = null;
    }
  }

}
