package Trees;

public class NextPointer {
    public static void main(String[] args){
        TreeLinkNode root = new TreeLinkNode(1);
        root.left = new TreeLinkNode(2);

        root.left.left = new TreeLinkNode(3);
        root.left.left.left = new TreeLinkNode(4);
        root.left.left.right = new TreeLinkNode(5);

        root.left.right = new TreeLinkNode(6);
        root.left.right.left = new TreeLinkNode(7);
        root.left.right.right = new TreeLinkNode(8);


        root.right = new TreeLinkNode(9);

        root.right.left = new TreeLinkNode(10);
        root.right.left.left = new TreeLinkNode(11);
        root.right.left.right = new TreeLinkNode(12);

        root.right.right = new TreeLinkNode(13);
        root.right.right.left = new TreeLinkNode(14);
        root.right.right.right = new TreeLinkNode(15);

        connect(root);

    }

    private static void connect(TreeLinkNode root) {
        if(root == null) return;
        TreeLinkNode parent = root;
        parent.next = null;
        TreeLinkNode first = null;
        if(parent.left == null) return;
        else first = parent.left;
        TreeLinkNode prev = null;
        while(first != null){
            TreeLinkNode curr = parent.left;
            if(prev != null){
                prev.next = curr;
            }
            if(parent.right != null){
                curr.next =  parent.right;
                curr = curr.next;
            }
            if(parent.next != null){
                prev  = curr;
                parent = parent.next;
            }
            else{
                prev = null;
                curr.next=null;
                parent = first;
                first = parent.left;
            }
        }
    }

}

class TreeLinkNode{
    int val;
    TreeLinkNode left, right, next;
    public TreeLinkNode(int x) {
        val = x;
        left = null;
        right = null;
        next = null;
    }
}
