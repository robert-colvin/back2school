package datastructures.binarytrees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TestTreeNode {
    // O(V+E) time (aka O(n)), O(n) space
    public static boolean bfs(TreeNode tree, int searchVal) {
        if (tree == null) return false;

        Queue<TreeNode> queue = new LinkedList<>(); // LL implements Queue interface, Java has no explicit queue
        queue.add(tree);

        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            System.out.println("Breadth first traversal got " + curr.val);
            if (curr.val == searchVal) {
                return true;
            }

            if (curr.left != null) {
                queue.add(curr.left);
            }
            if (curr.right != null) {
                queue.add(curr.right);
            }
        }

        return false;
    }

    // O(V+E) time (aka O(n)), O(n) space
    public static boolean dfs(TreeNode tree, int searchVal) {
        if (tree == null) return false;

        Stack<TreeNode> stack = new Stack<>(); // can also use LinkedList since it has same push/pop methods
        stack.push(tree);

        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            System.out.println("Depth first traversal got " + curr.val);
            if (curr.val == searchVal) {
                return true;
            }

            // right first because it's LIFO
            if (curr.right != null) {
                stack.push(curr.right);
            }
            if (curr.left != null) {
                stack.push(curr.left);
            }
        }

        return false;
    }

    // O(V+E) time (aka O(n)), O(n) space
    public static boolean dfsRecursive(TreeNode tree, int searchVal) {
        if (tree == null) return false;
        System.out.println("Recursive depth first traversal got " + tree.val);
        if (tree.val == searchVal) return true;

        return dfsRecursive(tree.left, searchVal) || dfsRecursive(tree.right, searchVal); // use OR here since we only need 1 true to be good
    }

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        int searchVal = 7;
        System.out.println("Found " + searchVal + " during BFS? " + bfs(tree, searchVal));
        System.out.println("Found " + searchVal + " during DFS? " + dfs(tree, searchVal));
        System.out.println("Found " + searchVal + " during recursive DFS? " + dfsRecursive(tree, searchVal));
    }
}
