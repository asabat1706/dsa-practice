package Trees;

import sun.reflect.generics.tree.Tree;

public class TreeFlattening {
    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);

        root.right = new TreeNode(5);
        root.right.right = new TreeNode(6);

        ListNode head = flatenTree(root);
        TreeNode flat_root = convertLLtoTree(head);
        System.out.println(head);
    }

    private static TreeNode convertLLtoTree(ListNode head) {
        TreeNode root = new TreeNode(head.val);
        TreeNode curr = root;
        ListNode temp = head;
        while(temp.next != null){
            temp = temp.next;
            curr.right = new TreeNode(temp.val);
            curr = curr.right;
        }
        return root;
    }

    private static ListNode flatenTree(TreeNode root) {
        if(root == null)
        {
            return null;
        }
        ListNode head = new ListNode(root.val);
        ListNode left_head  = flatenTree(root.left);
        ListNode right_head = flatenTree(root.right);
        if(left_head !=null){
            head.next = left_head;
        }
        ListNode temp = left_head;
        while((temp !=null) && (temp.next != null)){
            temp = temp.next;
        }
        if((temp != null) && (right_head != null)) {
            temp.next = right_head;
        }else if((head != null) && (right_head != null)){
            head.next = right_head;
        }
        return head;
    }

}
class ListNode{
     int val;
     ListNode next;
     public ListNode(int val){
         this.val = val;
         next = null;
     }
}
