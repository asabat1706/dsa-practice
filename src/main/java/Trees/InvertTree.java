package Trees;

public class InvertTree {
    public static void main(String[] args){
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);

        root.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        root = invertTree(root);

    }

    private static TreeNode invertTree(TreeNode root) {
        if(root == null) return null;

        TreeNode lst = invertTree(root.left);
        TreeNode rst = invertTree(root.right);

        TreeNode temp = rst;
        root.right = lst;
        root.left = temp;

        return root;
    }
}
