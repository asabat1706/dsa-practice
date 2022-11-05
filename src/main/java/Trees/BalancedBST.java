package Trees;

public class BalancedBST {
    public static void main(String[] args){
        int[] A = {20,30,40,42,45,60,65,75,80};
        TreeNode root = buildBalancedBST(A,0,A.length-1);
        System.out.println(root.val);
    }

    private static TreeNode buildBalancedBST(int[] a, int s, int e) {
        if(e < s) return null;
        if(e == s) return new TreeNode(a[s]);

        int mid = (s+e)/2;
        TreeNode node = new TreeNode(a[mid]);
        node.left = buildBalancedBST(a,s,mid-1);
        node.right = buildBalancedBST(a,mid+1,e);
        return node;
    }
}
