package java_problem.binarytree;

public class SubtreeOfAnotherTree572 {
    public static void main(String[] args) {
        TreeNode tree = new TreeNode(1);
        tree.left = null;
        tree.right = new TreeNode(10);
        TreeNode subTree = new TreeNode(10);
        System.out.println("Is SubtreeOfAnotherTree572=" + isSubtree(tree,subTree));
    }

    private static boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (subRoot == null) return true;
        if (root == null) return false;

        boolean fromRoot = match(root, subRoot);
        if (fromRoot)
            return true;

        boolean left = isSubtree(root.left, subRoot);
        if (left)
            return true;

        return isSubtree(root.right, subRoot);
    }

    private static boolean match(TreeNode p, TreeNode q) {
        if (p == null || q == null) return (p == q);
        if (p.val == q.val) {
            boolean left = match(p.left, q.left);
            boolean right = match(p.right, q.right);
            return (left && right);
        }
        return false;
    }
}
