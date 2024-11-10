package datastructures.binarytrees;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode() {}
    public TreeNode(int val) {
        this.val = val;
    }
    public TreeNode(int val, TreeNode left) {
        this(val);
        this.left = left;
    }
    public TreeNode(int val, TreeNode left, TreeNode right) {
        this(val, left);
        this.right = right;
    }
}
