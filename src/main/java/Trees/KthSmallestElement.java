package Trees;

import java.util.ArrayList;

public class KthSmallestElement {
    public static void main(String[] args){
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);

        ArrayList<Integer> inorder = new ArrayList<>();
        inOrderTraversal(root, inorder);
        System.out.println(inorder);

        int k=1; int ans = inorder.get(k-1);
        System.out.println(ans);

    }

    private static void inOrderTraversal(TreeNode root, ArrayList<Integer> inorder) {
        if(root == null) return;

        inOrderTraversal(root.left, inorder);
        inorder.add(root.val);
        inOrderTraversal(root.right, inorder);
    }
}
