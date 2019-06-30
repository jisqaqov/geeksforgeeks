package geeksforgeeks;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Jandos Iskakov
 * problem: Clone a Binary Tree
 * link to problem: https://practice.geeksforgeeks.org/problems/clone-a-binary-tree/1
 * algorithm: Tree
 * time complexity: O(N)
 * space complexity: O(N)
 */
public class CloneTree {

    public static Tree cloneTree(Tree tree){
        Map<Tree, Tree> memo = new HashMap<>();
        return cloneTree(tree, memo);
    }

    public static Tree cloneTree(Tree tree, Map<Tree, Tree> memo){
        if (tree == null) {
            return null;
        }

        if (memo.containsKey(tree)) {
            return memo.get(tree);
        }

        Tree clone = new Tree(tree.data);
        memo.put(tree, clone);

        clone.left = cloneTree(tree.left, memo);
        clone.right = cloneTree(tree.left, memo);
        clone.random = cloneTree(tree.random, memo);

        return clone;
    }

    static class Tree {
        int data;
        Tree left,right,random;
        Tree(int d){
            data=d;
            left=null;
            right=null;
            random=null;
        }
    }

}
