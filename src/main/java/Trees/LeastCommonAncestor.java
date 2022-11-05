package Trees;

public class LeastCommonAncestor {
    static int lca;
    public static void main(String[] args) {
//        Trees.TreeNode root = new Trees.TreeNode(40);
//        root.left = new Trees.TreeNode(30);
//        root.left.left = new Trees.TreeNode(3);
//        root.left.right = new Trees.TreeNode(20);
//
//        root.right = new Trees.TreeNode(60);
//        root.right.left = new Trees.TreeNode(45);
//        root.right.right = new Trees.TreeNode(70);
//        root.right.right.left = new Trees.TreeNode(65);
//        root.right.right.right = new Trees.TreeNode(80);
          Trees.TreeNode root = new Trees.TreeNode(1);

        int temp = postOrder(root,1,1);
        System.out.println(lca);
    }

    private static int postOrder(TreeNode root, int u, int v) {
        if(root == null) return 0;
        if(root.val == u && root.val == v){
            lca = root.val;
            return 0;
        }
        int left = postOrder(root.left,u,v);
        int right = postOrder(root.right,u,v);

        if(left == 1 && right == 1){
            lca = root.val;
            return 0;
        }
        else if(left == 1 || right == 1){
            if((root.val == u) || (root.val == v)){
                lca = root.val;
                return 0;
            }
            else return 1;
        }
        else if(root.val == u || root.val == v) {
            return 1;
        }
        return 0;
    }
}
