package Blind75LeetCode;

public class MergeSortedList {
    public static void main(String[] args){
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(4);
        head1.next.next = new ListNode(5);

        ListNode head2 = new ListNode(1);
        head1.next = new ListNode(3);
        head1.next.next = new ListNode(4);

        ListNode head3 = new ListNode(2);
        head3.next = new ListNode(6);

        ListNode[] input ={head1,head2,head3};
        ListNode cummNode = head1;
        for(int i=1; i< input.length; i++){
            cummNode = mergeAndSort(cummNode,input[i]);
        }
//        ListNode head = mergeAndSort(mergeAndSort(head1,head2),head3);

        ListNode temp = cummNode;
        while(temp != null){
            System.out.print(temp.val + "  ");
            temp = temp.next;
        }
    }

    public static ListNode mergeAndSort(ListNode h1, ListNode h2){
        ListNode finalHead = h1;
        ListNode current = h1;

        while(h1 != null && h2 != null){
            ListNode temp1 = h1.next;
            ListNode temp2 = h2.next;
            if(h1.val <= h2.val){
                current = h1;
                h1 = temp1;
            }
            else{
                current.next = h2;
                h2.next = h1;
                h2 = temp2;
                current = current.next;
            }
        }
        if(h1 != null){
            current.next = h1;
        }
        if(h2 != null){
            current.next = h2;
        }

        return finalHead;
    }
}

class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
