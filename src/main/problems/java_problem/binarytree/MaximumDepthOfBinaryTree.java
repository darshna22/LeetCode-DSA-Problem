package java_problem.binarytree;

public class MaximumDepthOfBinaryTree {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = null;
        treeNode.right = new TreeNode(10);
        System.out.println(maxDepth(treeNode));
    }

    public static int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }

}
