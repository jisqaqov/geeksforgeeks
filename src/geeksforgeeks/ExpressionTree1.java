package geeksforgeeks;

/**
 * @author Jandos Iskakov
 * problem: https://practice.geeksforgeeks.org/problems/expression-tree/1
 * time complexity: O(n)
 * space complexity: O(1)
 * algorithm: Tree
 */
public class ExpressionTree1 {

    public static void main(String[] args) {

    }

    private static class Node {
        String data;
        Node left,right;

        Node(String data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public int evalTree(Node root) {
        if (root == null) {
            throw new IllegalArgumentException("root is null");
        }

        if (root.left == null && root.right == null) {
            return Integer.parseInt(root.data);
        }

        int leftVal = root.left != null? evalTree(root.left): 0;
        int rightVal = root.right != null? evalTree(root.right): 0;

        int val = 0;

        String oper = root.data;
        switch (oper) {
            case "+":
                val = leftVal + rightVal;
                break;
            case "-":
                val = leftVal - rightVal;
                break;
            case "*":
                val = leftVal * rightVal;
                break;
            case "/":
                val = leftVal / rightVal;
                break;
        }

        return val;
    }

}

