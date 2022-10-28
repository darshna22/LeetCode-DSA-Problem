package java_problem.binarytree;

public class BalancedBinaryTree110 {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = null;
        treeNode.right = new TreeNode(10);
        System.out.println("Is BalancedBinaryTree="+isBalanced(treeNode));
    }

    private static boolean isBalanced(TreeNode root) {
        if(root==null) return true;
        return !(diffOfBinaryTree(root)>1);
    }

    private static int diffOfBinaryTree(TreeNode root) {
        if(root==null) return 0;
        int leftH=height(root.left);
        int rightH=height(root.right);
        int rootDiff=Math.abs(leftH-rightH);

        int diffLeftSub=diffOfBinaryTree(root.left);
        int diffRightSub=diffOfBinaryTree(root.right);
        int maxSubDiff=Math.max(diffLeftSub,diffRightSub);

        return Math.max(maxSubDiff,rootDiff);
    }

    private static int height(TreeNode root) {
        if(root==null) return 0;
        int left=height(root.left);
        int right=height(root.right);
        return Math.max(left,right)+1;
    }
}

