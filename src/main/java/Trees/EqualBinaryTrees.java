package Trees;

public class EqualBinaryTrees {
    public static void main(String[] args){
        TreeNode root1 = new TreeNode(1);
         root1.left = new TreeNode(2);
         root1.right = new TreeNode(3);

        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(3);

        int ans = isEqualBT(root1,root2);
    }

    private static int isEqualBT(TreeNode root1, TreeNode root2) {
        if(root1==null && root2== null){
            return 1;
        }
        if(root1==null || root2== null){
            return 0;
        }
        if(root1.val != root2.val){
            return 0;
        }
        int left_equal = isEqualBT(root1.left,root2.left);
        int right_equal=0;
        if(left_equal==1) {
            right_equal = isEqualBT(root1.right, root2.right);
            return right_equal;
        }
        else{
            return 0;
        }
    }
}
