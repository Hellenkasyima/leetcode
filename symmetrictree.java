// Tree node class
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isMirror(root.left, root.right);
    }

    // recursive helper: checks whether t1 and t2 are mirror images
    private boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;
        if (t1.val != t2.val) return false;
        return isMirror(t1.left, t2.right) && isMirror(t1.right, t2.left);
    }

    // small test
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left  = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left  = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left  = new TreeNode(4);
        root.right.right = new TreeNode(3);

        Solution sol = new Solution();
        System.out.println(sol.isSymmetric(root)); // prints true
    }
}
