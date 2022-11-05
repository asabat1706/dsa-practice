package Trees;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraverse {
    public static ArrayList<ArrayList<Integer>> levelOrder(TreeNode A){
        ArrayList<ArrayList<Integer>> finalList = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(A); q.add(new TreeNode(-1));
        ArrayList<Integer> l_children = new ArrayList<>();
        while(!q.isEmpty()){
            TreeNode root = q.peek();
            if(root.val == -1){
                if(!l_children.isEmpty()){
                    finalList.add(l_children);
                }
                l_children = new ArrayList<>();
                q.remove();
                if(!q.isEmpty()){
                    q.add(new TreeNode(-1));
                }
            }
            else{
                l_children.add(root.val);
                if(root.left != null) {
                    q.add(root.left);
                }
                if(root.right != null) {
                    q.add(root.right);
                }
                q.remove();
            }
        }
        return finalList;
    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.left.left = new TreeNode(25);
        root.left.right = new TreeNode(27);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        ArrayList<ArrayList<Integer>> list = levelOrder(root);
        System.out.println(list);
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
    val = x;
    left=null;
    right=null;
   }
 }
