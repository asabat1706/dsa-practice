package Trees;

public class BSTNodesInRange {
    public static void main(String[] args){
        TreeNode root = new TreeNode(32);
        root.left = new TreeNode(25);
        root.right = new TreeNode(46);

        root.left.left = new TreeNode(17);
        root.left.right = new TreeNode(27);

        root.left.left.left = new TreeNode(9);

        root.right.left = new TreeNode(40);
        root.right.right = new TreeNode(49);

        int min = 11;
        int max = 26;

        int node_count = findNodesInRange(root,min,max);
        System.out.println(node_count);
    }

    private static int findNodesInRange(TreeNode root, int min, int max) {
        if(root == null){
            return 0;
        }
        int count=0;
        if(root.val>=max){
            count += findNodesInRange(root.left,min,max);
            if(root.val >= min && root.val < max){
                count++;
            }
        }
        else if(root.val <= min){
            count += findNodesInRange(root.right,min,max);
            if(root.val >= min && root.val < max){
                count++;
            }
        }
        else{
            count++;
            count += findNodesInRange(root.left,min,max);
            count += findNodesInRange(root.right,min,max);
        }
        return count;
    }
}
