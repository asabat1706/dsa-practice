package LinkedList;

import java.util.HashMap;

public class LRUCache {
    int capacity;
    HashMap<Integer,Integer> pair = new HashMap<>();
    LinkNode lru_node;
    LinkNode mru_node;

    public LRUCache(int cap){
        capacity = cap;
        lru_node = null;
    }

    public void set(int key, int val) {
        if(lru_node== null && mru_node== null){
            lru_node = new LinkNode(key);
            mru_node = lru_node;
            capacity--;
            pair.put(key,val);
        }
        else {
            if(pair.containsKey(key)){
               if(lru_node.key_data == key){
                   LinkNode new_node  = new LinkNode(key);
                   mru_node.next = new_node;
                   mru_node = mru_node.next;
                   lru_node = lru_node.next;
                   pair.put(key,val);
               }
               else if(mru_node.key_data == key){
                   pair.put(key,val);
               }
               else {
                   LinkNode position_node = search(key,lru_node);
                   LinkNode new_node  = new LinkNode(key);
                   mru_node.next = new_node;
                   mru_node = mru_node.next;
                   position_node.next = position_node.next.next;
                   pair.put(key,val);
               }
            }
            else{
                LinkNode new_node  = new LinkNode(key);
                mru_node.next = new_node;
                mru_node = mru_node.next;
                if(capacity == 0){
                    pair.remove(lru_node.key_data);
                    lru_node = lru_node.next;
                }
                else{
                    capacity--;
                }
                pair.put(key,val);
            }
        }
    }

    public LinkNode search(int key, LinkNode lru){
        LinkNode temp = lru;
        while(temp.next != null){
            if(temp.next.key_data == key){
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }
    public int get(int key){
        if(lru_node == null && mru_node == null) {
            return -1;
        }
        else if(pair.containsKey(key)){
            if(lru_node.key_data == key){
                mru_node.next = new LinkNode(key);
                mru_node = mru_node.next;
                lru_node = lru_node.next;
                return pair.get(key);
            }
            else if(mru_node.key_data == key){
                return pair.get(key);
            }
            else {
                LinkNode position_node = search(key, lru_node);
                mru_node.next = new LinkNode(key);
                mru_node = mru_node.next;
                position_node.next = position_node.next.next;
                return pair.get(key);
            }
        }
        else{
            return -1;
        }
    }

    public static void main(String[] args){
//        LRUCache lru = new LRUCache(2);
//        int value = lru.get(2);
//        System.out.println(value);
//        lru.set(2,6);
//        value = lru.get(1);
//        System.out.println(value);
//        lru.set(1,5);
//        lru.set(1,2);
//        value = lru.get(1);
//        System.out.println(value);
//        value = lru.get(2);
//        System.out.println(value);

//        32 4 S 5 13 S 9 6 S 4 1 G 4 S 6 1 S 8 11 G 13 G 1 S 12 12 G 10 S 15 13 S 2 13
//        S 7 5 S 10 3 G 6 G 10 S 15 14 S 5 12 G 5 G 7 G 15 G 5 G 6 G 10 S 7 13 G 14 S 8 9
//        G 4 S 6 11 G 9 S 6 12 G 3
//          LRUCache lru = new LRUCache(4);
//          lru.set(5,13);
//          lru.set(9,6);
//          lru.set(4,1);
//          int val = lru.get(4);
//          System.out.println(val);
//          lru.set(6,1);
//          lru.set(8,11);
//          val = lru.get(13);
//          System.out.println(val);
//          val = lru.get(1);
//          System.out.println(val);
//          lru.set(12,12);
//          val = lru.get(10);
//          System.out.println(val);
//          lru.set(15,13);
//          lru.set(2,13);
//          lru.set(7,5);
//          lru.set(10,3);
//          val = lru.get(6);
//          System.out.println(val);
//          val = lru.get(10);
//          System.out.println(val);
//          lru.set(15,14);
//          lru.set(5,12);



//        6 1 S 2 1 S 2 2 G 2 S 1 1 S 4 1 G 2
          LRUCache lru = new LRUCache(1);
          lru.set(2,1);
          lru.set(2,2);
          int val = lru.get(2);
          System.out.println(val);
          lru.set(1,1);
          lru.set(4,1);
          val = lru.get(2);
          System.out.println(val);
    }

}

class LinkNode{
    int key_data;
    LinkNode next;

    public LinkNode(int key_data){
        this.key_data = key_data;
    }
}



