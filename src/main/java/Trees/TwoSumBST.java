package Trees;

import java.util.ArrayList;

public class TwoSumBST {
    static ArrayList<Integer> inorderList = new ArrayList<>();
    public static void main(String[] args){
        TreeNode root = new TreeNode(32);
        root.left = new TreeNode(25);
        root.right = new TreeNode(46);

        root.left.left = new TreeNode(17);
        root.left.right = new TreeNode(27);

        root.left.left.left = new TreeNode(9);

        root.right.left = new TreeNode(40);
        root.right.right = new TreeNode(49);

        int req_sum = 52;
        inorderTraversal(root);
        System.out.println(inorderList);
        int i=0,j=inorderList.size()-1;
        int ans = 0;
        while(i<j){
            int num1 = inorderList.get(i);
            int num2 = inorderList.get(j);
            if(num1+num2 < req_sum){
                i++;
            }
            else if(num1+num2 > req_sum){
                j--;
            }
            else{
                ans = 1;
                break;
            }
        }
        System.out.println(ans);
    }

    private static void inorderTraversal(TreeNode root) {
        if(root==null){
            return;
        }
        inorderTraversal(root.left);
        inorderList.add(root.val);
        inorderTraversal(root.right);
    }
}
