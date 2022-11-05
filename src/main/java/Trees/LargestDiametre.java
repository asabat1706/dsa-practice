package Trees;

public class LargestDiametre {
    public static void main(String[] args) {
        Trees.TreeNode root = new Trees.TreeNode(40);
        root.left = new Trees.TreeNode(30);
        root.left.left = new Trees.TreeNode(3);
        root.left.right = new Trees.TreeNode(20);

        root.right = new Trees.TreeNode(60);
        root.right.left = new Trees.TreeNode(45);
        root.right.right = new Trees.TreeNode(70);
        root.right.right.left = new Trees.TreeNode(65);
        root.right.right.right = new Trees.TreeNode(80);

        TreeInfo1 maxInfo = postOrder(root);
        System.out.println(maxInfo.max_dia);
    }

    private static TreeInfo1 postOrder(TreeNode root) {
        if(root == null){
            return new TreeInfo1(-1,-1);
        }

        TreeInfo1 left = postOrder(root.left);
        TreeInfo1 right = postOrder(root.right);

        int root_dia = left.max_hgt + right.max_hgt + 2;
        int max_root_hgt = Math.max(left.max_hgt, right.max_hgt) + 1;

        return new TreeInfo1(max_root_hgt,Math.max(Math.max(root_dia, left.max_dia), right.max_dia));
    }
}

class TreeInfo1{
    int max_hgt;
    int max_dia;
    public TreeInfo1(int max_hgt, int max_dia){
        this.max_hgt = max_hgt;
        this.max_dia = max_dia;
    }
}
