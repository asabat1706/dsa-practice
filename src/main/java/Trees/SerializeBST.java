package Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class SerializeBST {
    static ArrayList<Integer> serializedList = new ArrayList<>();
    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right.right = new TreeNode(6);

        serializeTree(root);
        System.out.println(serializedList);
    }

    private static void serializeTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode parent = queue.poll();
            serializedList.add(parent.val);
            if(parent.val != -1){
                if(parent.left==null){
                    queue.add(new TreeNode(-1));
                }
                else{
                    queue.add(parent.left);
                }
                if(parent.right==null){
                    queue.add(new TreeNode(-1));
                }
                else{
                    queue.add(parent.right);
                }
            }
        }
    }
}
