package Queues;

import java.util.LinkedList;

public class ImplimentQueueUsingLL {
    static LinkedList<Integer> ll = new LinkedList();

    public static void main(String[] args){
        enqueue(2);
        enqueue(4);
        enqueue(8);
        int front_ele = dequeue();
        System.out.println(isQueueEmpty());
        int front = ll.get(0);
        System.out.println(front);
        System.out.println(ll);
    }

    private static boolean isQueueEmpty() {
        return ll.isEmpty();
    }

    private static int dequeue() {
        return ll.remove(0);
    }

    private static void enqueue(int element) {
            ll.add(element);
    }
}
