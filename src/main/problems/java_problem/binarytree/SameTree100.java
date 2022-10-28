package java_problem.binarytree;

public class SameTree100 {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);

        TreeNode treeNode1 = new TreeNode(1);
        treeNode1.left = new TreeNode(2);
        treeNode1.right = new TreeNode(3);
        System.out.println("Is BalancedBinaryTree=" + isSameTree(treeNode, treeNode1));
    }

    private static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null || q == null) return (p == q);
        boolean leftOfPQ = isSameTree(p.left, q.left);
        boolean rightOfPQ = isSameTree(p.right, q.right);

        //check here value of root should be same along with its left and right child
        return ((p.val==q.val) && (leftOfPQ && rightOfPQ));
    }

}

