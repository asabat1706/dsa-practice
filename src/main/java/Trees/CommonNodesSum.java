package Trees;

public class CommonNodesSum {

    public static void main(String[] args){
        TreeNode root1 = new TreeNode(5);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(10);

        root1.left.right = new TreeNode(3);

        root1.right.right = new TreeNode(15);
        root1.right.left = new TreeNode(9);

        TreeNode root2 = new TreeNode(7);
        root2.left = new TreeNode(1);
        root2.right = new TreeNode(10);

        root2.left.right = new TreeNode(2);

        root2.right.right = new TreeNode(15);

        root2.right.right.left = new TreeNode(11);

        int sum = findCommonNodesSum(root1,root2);
        System.out.println(sum);
    }

    private static int findCommonNodesSum(TreeNode root1, TreeNode root2) {
        int sum=0;
        int mod = 1000000007;
        TreeNode inorderTree1 = morrisInorder(root1);
        TreeNode inorderTree2 = morrisInorder(root2);

        TreeNode pt1=inorderTree1; TreeNode pt2=inorderTree2;

        while (pt1 != null && pt2 != null){
            if(pt1.val == pt2.val){
                sum = (sum%mod)+ (pt1.val%mod);
                pt1 = pt1.right;
                pt2 = pt2.right;
            }
            else if(pt1.val< pt2.val){
                pt1  = pt1.right;
            }
            else{
                pt2 = pt2.right;
            }
        }
        return sum;
    }

    private static TreeNode morrisInorder(TreeNode root) {
        TreeNode inorderRoot=new TreeNode(-1);
        TreeNode inorder_temp = inorderRoot;
        TreeNode temp = root;
        while(temp != null){
            if(temp.left != null){
                TreeNode inOrderPred = findInOrderPred(temp);
                if(inOrderPred.right == null){
                    inOrderPred.right = temp;
                    temp = temp.left;
                }
                else{
                    inOrderPred.right = null;
                    inorder_temp.right = new TreeNode(temp.val);
                    inorder_temp = inorder_temp.right;
                    temp=temp.right;
                }
            }
            else{
                inorder_temp.right = new TreeNode(temp.val);
                inorder_temp = inorder_temp.right;
                temp = temp.right;
            }
        }

        inorderRoot = inorderRoot.right;
        return inorderRoot;
    }

    private static TreeNode findInOrderPred(TreeNode node) {
        TreeNode temp = node.left;
        while(temp.right != null && temp.right != node){
            temp = temp.right;
        }
        return temp;
    }
}
