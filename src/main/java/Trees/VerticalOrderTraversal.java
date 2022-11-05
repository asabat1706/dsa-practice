package Trees;

import java.util.ArrayList;
import java.util.HashMap;

public class VerticalOrderTraversal {
    static int min_level = Integer.MAX_VALUE;
    static int max_level = Integer.MIN_VALUE;
    public static void main(String[] args) {
        Trees.TreeNode root = new Trees.TreeNode(9);
        root.left = new Trees.TreeNode(6);
        root.right = new Trees.TreeNode(4);
        root.left.left = new Trees.TreeNode(2);
        root.left.left.left = new Trees.TreeNode(7);
        root.left.left.left.right = new Trees.TreeNode(14);
        root.left.left.right = new Trees.TreeNode(5);
        root.left.right = new Trees.TreeNode(3);
        root.left.right.left = new Trees.TreeNode(11);
        root.right.left = new Trees.TreeNode(8);
        root.right.right = new Trees.TreeNode(1);
        root.right.right.left = new Trees.TreeNode(12);
        HashMap<Integer, ArrayList<TreeNode>> hm = new HashMap<>();
        verticalView(root, hm, 0);
        for(int i = min_level; i<= max_level; i++){
            ArrayList<TreeNode> l = hm.get(i);
            for(TreeNode t : l){
                System.out.print(t.val + "   ");
            }
            System.out.println();
        }
    }

    private static void verticalView(TreeNode root, HashMap<Integer, ArrayList<TreeNode>> hm, int level) {
        if(root == null) return;
        min_level = Math.min(min_level,level);
        max_level = Math.max(max_level,level);
        if(!hm.containsKey(level)){
            hm.put(level, new ArrayList<>());
        }
        ArrayList<TreeNode> list = hm.get(level);
        list.add(root);
        verticalView(root.left,hm,level-1);
        verticalView(root.right,hm,level+1);
    }
}
