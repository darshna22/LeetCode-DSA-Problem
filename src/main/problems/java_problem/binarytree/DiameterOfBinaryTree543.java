package java_problem.binarytree;

public class DiameterOfBinaryTree543 {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = null;
        treeNode.right = new TreeNode(10);
        System.out.println("diameter of binary tree="+diameterOfBinaryTree(treeNode));
    }

    private static int diameterOfBinaryTree(TreeNode root) {
        if(root==null) return 0;
        int leftH=height(root.left);
        int rightH=height(root.right);
        int rootH=leftH+rightH;
        int diaLeft=diameterOfBinaryTree(root.left);
        int diaRight=diameterOfBinaryTree(root.right);
        int maxDia=Math.max(diaLeft,diaRight);

        return Math.max(rootH,maxDia);
    }

    private static int height(TreeNode root) {
        if(root==null) return 0;
        int left=height(root.left);
        int right=height(root.right);
        return Math.max(left,right)+1;
    }
}
