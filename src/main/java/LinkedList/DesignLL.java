package LinkedList;

import java.util.LinkedList;
import java.util.List;

public class DesignLL {
//   LL_New list = new LL_New();
    public static void insert_node(int position, int value) {
        //insert at head
        if(position==1){
            if(LL_New.head==null){
                LL_New.head= new Node(value);
            }
            else{
                Node temp2 = LL_New.head;
                Node temp = new Node(value);
                LL_New.head =temp;
                LL_New.head.next=temp2;
            }
        }
        else{
            int p =1;
            Node temp = LL_New.head;
            while(temp!=null){
                if((p+1) == position){
                    Node temp1 = new Node(value);
                    temp1.next=temp.next;
                    temp.next=temp1;
                }
                temp=temp.next;
                p++;
            }
        }
    }
    public static void delete_node(int position) {
        //delete head
        if(position==1){
            LL_New.head = LL_New.head.next;
        }
        else{
            int p=1;
            Node temp=LL_New.head; Node prev= null;
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
    public static void print_ll() {
        if(LL_New.head != null){
            Node temp=LL_New.head;
            while(temp!=null){
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
            System.out.println(" ");
        }
    }
  public static void main(String[] args){
        insert_node(1,2);
        insert_node(1,5);
        insert_node(2,6);
        insert_node(4,4);
      print_ll();
//        delete_node(1);
        delete_node(2);
        delete_node(3);
       insert_node(4,4);
      print_ll();
  }
    static class LL_New{
        public static Node head;
        public LL_New(){
            this.head=null;
        }
    }
    static class Node{
        public int data;
        public Node next;
        public Node(int data){
            this.data=data;
        }
    }
}


