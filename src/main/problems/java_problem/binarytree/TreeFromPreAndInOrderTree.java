package java_problem.binarytree;

import java.util.Arrays;


class TreeFromPreAndInOrderTree {

    public static void main(String args[]) {
        int[] preorder = {3, 9, 20, 15, 7}, inorder = {9, 3, 15, 20, 7};
        buildTree(preorder, inorder);
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) return null;

        TreeNode root = new TreeNode(preorder[0]);
        int mid = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (preorder[0] == inorder[i]) mid = i;
        }

        root.left =
                buildTree(
                        Arrays.copyOfRange(preorder, 1, mid + 1),
                        Arrays.copyOfRange(inorder, 0, mid)
                );
        root.right =
                buildTree(
                        Arrays.copyOfRange(preorder, mid + 1, preorder.length),
                        Arrays.copyOfRange(inorder, mid + 1, inorder.length)
                );

        return root;
    }
}


























