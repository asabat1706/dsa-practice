package Blind75LeetCode;

public class ValidSubtree {
    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        root.left = null;
        root.right = new TreeNode(1);
        root.right.left = null;
        root.right.right = new TreeNode(1);
        root.right.right.left = null;
        root.right.right.right = new TreeNode(1);
        root.right.right.right.left = null;
        root.right.right.right.right = new TreeNode(1);
        root.right.right.right.right.left = new TreeNode(2);

        TreeNode subRoot = new TreeNode(1);
        subRoot.left = null;
        subRoot.right = new TreeNode(1);
        subRoot.right.left = null;
        subRoot.right.right = new TreeNode(1);
        subRoot.right.right.left = new TreeNode(2);

        boolean ans = isSubtree(root, subRoot);
        System.out.println(ans);
    }
    public static boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(!validSubtree(root,subRoot)){
            return (isSubtree(root.left,subRoot) || isSubtree(root.right,subRoot));
        }
        return true;
    }

    public static boolean validSubtree(TreeNode root, TreeNode subRoot){
        if(root == null && subRoot == null){
            return true;
        }
        if(root == null || subRoot == null){
            return false;
        }
        if(root.val != subRoot.val){
            return false;
        }
        boolean left = validSubtree(root.left,subRoot.left);
        if(left){
            return validSubtree(root.right,subRoot.right);
        }else{
            return false;
        }
    }
}

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
}
