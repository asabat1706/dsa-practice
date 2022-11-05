package Trees;

public class PrintPathToNode {
    public static void main(String[] args){
        Trees.TreeNode root = new Trees.TreeNode(3);
        root.left = new Trees.TreeNode(9);
        root.right = new Trees.TreeNode(20);
        root.left.left = new Trees.TreeNode(25);
        root.left.right = new Trees.TreeNode(27);
        root.right.left = new Trees.TreeNode(15);
        root.right.right = new Trees.TreeNode(7);
        root.right.left.right = new Trees.TreeNode(6);
        printPath(root,6);
    }

    private static boolean printPath(Trees.TreeNode root, int value) {
        if(root == null) return false;
        if(root.val == value){
            return true;
        }
        if(printPath(root.left,value)){
            System.out.println(root.left.val);
            return true;
        }
        if(printPath(root.right,value)){
            System.out.println(root.right.val);
            return true;
        }
        return false;
    }

}
//class TreeNode {
//    int val;
//    TreeNode left;
//    TreeNode right;
//    TreeNode(int x) {
//        val = x;
//        left=null;
//        right=null;
//    }
//}
