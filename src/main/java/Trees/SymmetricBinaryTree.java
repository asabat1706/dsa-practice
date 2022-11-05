package Trees;

public class SymmetricBinaryTree {
    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);

//        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(3);

//        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

        int isSymmetric = findIfSymmetric(root.left,root.right);
        System.out.println(isSymmetric);
    }

    private static int findIfSymmetric(TreeNode left, TreeNode right) {
        if(left == null && right == null){
            return 1;
        }
        if(left == null || right == null){
            return 0;
        }
        if(left.val != right.val){
            return 0;
        }
        int left_sub = findIfSymmetric(left.left,right.right);
        int right_sub = 0;
        if(left_sub == 1){
            right_sub = findIfSymmetric(left.right,right.left);
            return right_sub;
        }
        else{
            return 0;
        }

    }
}
