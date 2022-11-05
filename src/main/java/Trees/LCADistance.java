package Trees;

public class LCADistance {
    static boolean foundBoth=false;
    public static void main(String[] args){
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);

        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(4);

        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(11);

        int dist = findLCADist(root,1,11);
        System.out.println(dist);
    }

    private static int findLCADist(TreeNode root, int node1, int node2) {
        if(root==null){
            return 0;
        }
        if(node1 == node2){
            return 0;
        }
        int len_left=0, len_right=0;
        if(node1 < root.val && node2 < root.val){
            len_left = findLCADist(root.left,node1,node2);
        }
        else if(node1 > root.val && node2 > root.val){
            len_right = findLCADist(root.left,node1,node2);
        }
        else
        {
            len_left = findLCADist(root.left,node1,node2);
            len_right = findLCADist(root.right,node1,node2);
        }

        if(len_left > 0 && len_right > 0){
            foundBoth=true;
            return len_left+len_right;
        }
        if(len_left > 0 || len_right > 0){
            if(root.val == node1 || root.val == node2){
                foundBoth=true;
                return Math.max(len_left,len_right);
            }
            else{
                if(foundBoth){
                    return Math.max(len_left,len_right);
                }
                return Math.max(len_left+1,len_right+1);
            }
        }
        if(root.val == node1 || root.val == node2){
            return 1;
        }
        return 0;
    }
}
