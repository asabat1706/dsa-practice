package Blind75LeetCode;

public class MaximumPathSum {
    static int max_path_sum;
    public static void main(String[] args){
        TreeNode root = new TreeNode(-2);
        root.left = new TreeNode(-1);
        root.right = new TreeNode(2);

//        root.right.left = new TreeNode(15);
//        root.right.right = new TreeNode(7);
        findMaxPath(root);
        System.out.println(max_path_sum);
    }

    public static int findMaxPath(TreeNode root){
        if(root == null){
            return 0;
        }
        int left_sum = findMaxPath(root.left);
        int right_sum = findMaxPath(root.right);
        int subtree_sum = root.val + left_sum + right_sum;
        int right_tree_sum = root.val + right_sum;
        int left_tree_sum = root.val + left_sum;
        int current_max = Math.max(Math.max(left_tree_sum,right_tree_sum),subtree_sum);
        max_path_sum = Math.max(current_max,max_path_sum);
        return Math.max(right_tree_sum,left_tree_sum);
    }

}
