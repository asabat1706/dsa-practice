package Trees;

import java.util.ArrayList;

public class ValidBST {
    public static void main(String[] args) {
        Trees.TreeNode root = new Trees.TreeNode(10);
        root.left = new Trees.TreeNode(5);
        root.left.left = new Trees.TreeNode(4);
        root.left.right = new Trees.TreeNode(6);

        root.right = new Trees.TreeNode(20);
        root.right.left = new Trees.TreeNode(22);
        int ans = 1;
        ArrayList<Integer> list = new ArrayList<>();
        list = inOrderBST(root,list);
        for(int i=0; i<list.size()-1; i++){
            if(list.get(i) > list.get(i+1)){
                ans = 0;
                break;
            }
        }
        System.out.println(ans);
    }

    private static ArrayList<Integer> inOrderBST(TreeNode root, ArrayList<Integer> list) {
        if(root == null) return null;
        inOrderBST(root.left,list);
        list.add(root.val);
        inOrderBST(root.right,list);
        return list;
    }
}
