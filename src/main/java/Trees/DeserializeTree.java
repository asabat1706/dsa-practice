package Trees;

import sun.awt.image.ImageWatched;

import java.util.LinkedList;
import java.util.Queue;

public class DeserializeTree {
    public static void main(String[] args){
        int[] A = { 1, 2, 4, -1, 3, -1, 5, 7, -1, -1, 6, -1, 8, -1, -1, -1, -1};
        int index=0;
        TreeNode root_node = new TreeNode(A[index]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root_node);
        index++;
        while(!queue.isEmpty()){
            TreeNode root = queue.peek();
            if(root == null){
                queue.remove();
                continue;
            }
            TreeNode left = null;
            if(A[index] != -1)
                left = new TreeNode(A[index]);
            index++;
            TreeNode right = null;
            if(A[index] != -1)
                right = new TreeNode(A[index]);
            index++;
            queue.add(left);
            queue.add(right);
            root.left = left;
            root.right = right;
            queue.remove();
        }
        System.out.println(root_node);
    }


}
