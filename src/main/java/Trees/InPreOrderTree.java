package Trees;

import java.util.ArrayList;

//construct a tree from inorder and preorder traversal
public class InPreOrderTree {
    public static void main(String[] args){
        ArrayList<Integer> b = new ArrayList<>();
        b.add(4); b.add(8); b.add(2); b.add(5); b.add(1); b.add(6); b.add(3); b.add(7);

        ArrayList<Integer> a = new ArrayList<>();
        a.add(8); a.add(4); a.add(5); a.add(2); a.add(6); a.add(7); a.add(3); a.add(1);

        TreeNode tree_root = buildTree(b,a);
        System.out.println(tree_root.val);
    }

//    same thing if we do using indices, then we wont even have to create new arrays everytime.
//    For fetching the root, we can use a hashmap
    private static TreeNode buildTree(ArrayList<Integer> A, ArrayList<Integer> postorder) {
        if(A.size() ==0 && postorder.size()==0) {
            return null;
        }
        TreeNode root = new TreeNode(postorder.get(postorder.size()-1));
        if(A.size()==1 && postorder.size()==1) {
            return root;
        }
        ArrayList<Integer> in_left_subtree = new ArrayList<>();
        ArrayList<Integer> in_right_subtree = new ArrayList<>();
        ArrayList<Integer> pos_left_subtree = new ArrayList<>();
        ArrayList<Integer> pos_right_subtree = new ArrayList<>();
        boolean mid_found = false;
        for(int i = 0 ; i< A.size(); i++){
            if(A.get(i) == root.val) {
                mid_found = true;
            }
            else{
                if(!mid_found){
                    in_left_subtree.add(A.get(i));
                }
                else{
                    in_right_subtree.add(A.get(i));
                }
            }
        }
        for(int i=0; i<postorder.size(); i++){
            if(i < in_left_subtree.size()){
                pos_left_subtree.add(postorder.get(i));
            }
            else if(postorder.get(i) != root.val){
                pos_right_subtree.add(postorder.get(i));
            }
        }
        root.left = buildTree(in_left_subtree,pos_left_subtree);
        root.right = buildTree(in_right_subtree,pos_right_subtree);
        return root;
    }
}
