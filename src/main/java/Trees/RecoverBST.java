package Trees;

import java.util.ArrayList;

public class RecoverBST {
    public static void main(String[] args) {
        Trees.TreeNode root = new Trees.TreeNode(42);
        root.left = new Trees.TreeNode(30);
        root.left.left = new Trees.TreeNode(40);
        root.left.right = new Trees.TreeNode(20);

        root.right = new Trees.TreeNode(60);
        root.right.left = new Trees.TreeNode(45);
        root.right.right = new Trees.TreeNode(70);
        root.right.right.left = new Trees.TreeNode(65);
        root.right.right.right = new Trees.TreeNode(80);

        ArrayList<Integer> inorder_list = new ArrayList<>();
        ArrayList<Integer> invalid_num = new ArrayList<>();
        inorder_list = inorder(root, inorder_list);
        int count_dips = 0;
        for (int i = 1; i < inorder_list.size(); i++) {
            if ((inorder_list.get(i - 1) > inorder_list.get(i)))
                count_dips++;
        }
        int dips = count_dips; int num1=0, num2=0;
        while(dips > 0){
        for(int i=1; i<inorder_list.size(); i++){
                if(inorder_list.get(i-1) > inorder_list.get(i))
                {
                    if(count_dips == 1){
                        invalid_num.add(inorder_list.get(i-1));
                        invalid_num.add(inorder_list.get(i));
                        dips--;
                    }
                    else{
                        if(dips == 2){
                            num2 = inorder_list.get(i-1);
                        }
                        if(dips == 1){
                            num1 = inorder_list.get(i);
                        }
                        dips--;
                    }
                }
            }
        }
        invalid_num.add(num1); invalid_num.add(num2);
        System.out.println(inorder_list);
        System.out.println(invalid_num);
    }

    private static ArrayList<Integer> inorder(TreeNode root, ArrayList<Integer> inorder_list) {
        if(root == null){
            return inorder_list;
        }
        inorder_list = inorder(root.left,inorder_list);
        inorder_list.add(root.val);
        inorder_list = inorder(root.right,inorder_list);
        return inorder_list;
    }
}
