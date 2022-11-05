package Trees;

public class SumBinaryTree {
    static boolean ans=true;
    public static void main(String[] args){
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(5);

//        root.left.left = new TreeNode(4);
//        root.left.right = new TreeNode(6);
//
//        root.right.right = new TreeNode(4);

        int total_sum = isSumTree(root);
        System.out.println(ans);
    }

    private static int isSumTree(TreeNode root) {
        if(root==null){
            return 0;
        }
        if(root.left==null && root.right==null){
            return root.val;
        }
        int left_sum = isSumTree(root.left);
        int right_sum = isSumTree(root.right);

        if(left_sum+right_sum != root.val){
            ans = false;
        }
        return left_sum+right_sum+root.val;
    }
}
