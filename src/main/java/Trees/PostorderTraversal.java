package Trees;

import java.util.ArrayList;
import java.util.Stack;

public class PostorderTraversal {
    public static void main(String[] args){

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right.right = new TreeNode(6);

        ArrayList<Integer> postOrder = new ArrayList<>();
        Stack<TreeNode> traversal_stack = new Stack<>();
        Stack<Integer> visited_stack = new Stack<>();

        if(root != null){
            traversal_stack.push(root);
        }

        while(!traversal_stack.empty()){
            TreeNode parent = traversal_stack.pop();
            TreeNode right_child = parent.right;
            TreeNode left_child = parent.left;
            if(visited_stack.empty() || visited_stack.peek()!=parent.val){
                if(left_child== null && right_child== null){
                    postOrder.add(parent.val);
                }else{
                    traversal_stack.push(parent);
                    visited_stack.push(parent.val);
                    if(right_child != null){
                        traversal_stack.push(parent.right);
                    }
                    if(left_child != null){
                        traversal_stack.push(parent.left);
                    }
                }
            }
            else{
                visited_stack.pop();
                postOrder.add(parent.val);
            }
        }
        System.out.println(postOrder);
    }
}

