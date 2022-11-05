package Trees;

public class PathSum {
    public static void main(String[] args){
        TreeNode root = new TreeNode(1000);
        root.left = new TreeNode(200);


        int sum = 1000;

        int ans = hasPathSum(root, sum);
        System.out.println(ans);
    }

    private static int hasPathSum(TreeNode root, int sum) {
        if(root==null){
            return 0;
        }
        sum = sum - root.val;
        if(root.left==null && root.right==null){
            if(sum == 0){
                return 1;
            }
            return 0;
        }
        else {
            int left = hasPathSum(root.left, sum);
            int right = hasPathSum(root.right, sum);

            if (left == 1 || right == 1) {
                return 1;
            }
            return 0;
        }
    }
}
