package LinkedList;

public class DesignLL2 {
    public static void main(String[] args) {
        int A[][] = {{0,1,-1},{1,2,-1},{2,3,1},{0,4,-1},{3,1,-1},{3,2,-1}};
        LinkedList2 ll2 =new LinkedList2();
        for(int i=0; i<A.length; i++){
               int j=0;
                   if(A[i][j]==0){
                       ll2.insert_node(1,(A[i][j+1]));
                   }
                   else if(A[i][j]==1){
                       int position=ll2.getLastPosition();
                       ll2.insert_node(position,(A[i][j+1]));
                   }
                   else if(A[i][j]==2){
                       int index = A[i][j+2];
                       int position=ll2.getLastPosition();
                       if(index==position)
                           ll2.insert_node(position,A[i][j+1]);
                       else
                           ll2.insert_node(index+1,A[i][j+1]);
                   }
                   else if(A[i][j]==3){
                       int position=A[i][j+1];
                       ll2.delete_node(position+1);
                   }
                }
        ll2.print_ll();
//        return ll2.head;
    }

}
class ListNode {
      public int val;
      public ListNode next;
      ListNode(int x) { val = x; next = null; }
  }

class LinkedList2{
    public ListNode head;
    public void insert_node(int position, int value) {
        if(position==1){
            if(head==null){
                head= new ListNode(value);
            }
            else{
                ListNode temp2 = head;
                ListNode temp = new ListNode(value);
                head =temp;
                head.next=temp2;
            }
        }
        else{
            int p =1;
            ListNode temp = head;
            while(temp!=null){
                if((p+1) == position){
                    ListNode temp1 = new ListNode(value);
                    temp1.next=temp.next;
                    temp.next=temp1;
                }
                temp=temp.next;
                p++;
            }
        }
    }

    public void delete_node(int position) {
        //delete head
        if(position==1){
            head = head.next;
        }
        else{
            int p=1;
            ListNode temp= head; ListNode prev= null;
            while(temp!=null){
                if((p+1)==position){
                    prev = temp;
                }
                else if(p==position){
                    prev.next=temp.next;
                    break;
                }
                p++;
                temp=temp.next;
            }
        }
    }

    public int getLastPosition(){
        ListNode temp = head;
        int last_index=1;
        while(temp != null){
            last_index++;
            temp=temp.next;
        }
        return last_index;
    }

    public void print_ll() {
        if(head != null){
            ListNode temp= head;
            while(temp!=null){
                System.out.print(temp.val + " ");
                temp = temp.next;
            }
            System.out.println(" ");
        }
    }
    
}