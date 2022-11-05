package Trees;

public class LargestBST {
     static int max_size = 0;
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
        TreeInfo isBST = checkBST(root);
        System.out.println(max_size + "   "+ isBST.isBST);
    }

    private static TreeInfo checkBST(TreeNode root) {
        if(root == null){
            TreeInfo ti = new TreeInfo(Integer.MAX_VALUE,Integer.MIN_VALUE,true,0);
            return ti;
        }
        TreeInfo left = checkBST(root.left);
        TreeInfo right = checkBST(root.right);
        int size = left.count + right.count + 1;
        if(left.isBST && right.isBST && (left.max <= root.val) && (right.min > root.val)){
            max_size = Math.max(max_size,size);
            return new TreeInfo(Math.min(root.val, left.min),Math.max(root.val, right.max),true,size);
        }
        else {
            return new TreeInfo(Integer.MAX_VALUE, Integer.MIN_VALUE, false,0);
        }
    }

    static class TreeInfo {
        int min;
        int max;
        boolean isBST;
        int count;
        public TreeInfo(int min, int max, boolean isBST, int count){
            this.min = min;
            this.max = max;
            this.isBST = isBST;
            this.count = count;
        }
    }
}
