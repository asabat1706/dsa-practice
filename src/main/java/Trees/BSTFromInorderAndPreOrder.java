package Trees;

import java.util.HashMap;

public class BSTFromInorderAndPreOrder {
    static HashMap<Integer, Integer> findRootIndex = new HashMap<>();
    public static void main(String[] args){
        int[] preorder = {1, 6, 2, 3};
        int[] inorder = {6, 1, 3, 2};

        for(int i=0; i<inorder.length; i++){
            findRootIndex.put(inorder[i],i);
        }

        TreeNode root = buildBST(preorder,inorder,0,preorder.length-1,0,inorder.length-1);

        System.out.println(root);
    }

    private static TreeNode buildBST(int[] preorder, int[] inorder, int start_pre, int end_pre, int start_in, int end_in) {
        if(start_pre > end_pre || start_in > end_in){
            return null;
        }
        if(start_in == end_in){
            return new TreeNode(inorder[start_in]);
        }
        int root_index = findRootIndex.get(preorder[start_pre]);

        int left_subtree_size = root_index-start_in;

        TreeNode root = new TreeNode(preorder[start_pre]);
        root.left = buildBST(preorder,inorder,start_pre+1,start_pre+left_subtree_size,start_in,root_index-1);
        root.right = buildBST(preorder,inorder,start_pre+left_subtree_size+1,end_pre,root_index+1,end_in);

        return root;
    }


}
