package Queues;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class MinMaxSum {
    public static void main(String[] args){
        int[] arr = {2, 5, -1, 7, -3, -1, -2};
        int window = 4;
        int mod = 1000000007;
        Deque<Long> min_queue = new LinkedList<>();
        Deque<Long> max_queue = new LinkedList<>();
        long ans = 0L;
        for(int i=0; i<window; i++){
            while((!max_queue.isEmpty()) && (max_queue.peekLast() < (long)arr[i])){
                max_queue.removeLast();
            }
            max_queue.addLast((long)arr[i]);
        }
        for(int i=0; i<window; i++){
            while((!min_queue.isEmpty()) && (min_queue.peekLast() > (long)arr[i])){
                min_queue.removeLast();
            }
            min_queue.addLast((long)arr[i]);
        }
        if(!min_queue.isEmpty() && !max_queue.isEmpty()){
            long pre_ans = ((min_queue.peekFirst()%mod) + (max_queue.peekFirst()%mod))%mod;
            ans = (ans%mod + pre_ans%mod)%mod;
        }
       int s = 1; int e = window;
       while(e <= arr.length-1){
           if(!max_queue.isEmpty() && max_queue.peekFirst() == (long)arr[s-1]){
               max_queue.removeFirst();
           }
           while((!max_queue.isEmpty()) && (max_queue.peekLast() < (long)arr[e])){
               max_queue.removeLast();
           }
           max_queue.addLast((long)arr[e]);

           if(!min_queue.isEmpty() && min_queue.peekFirst() == (long)arr[s-1]){
               min_queue.removeFirst();
           }
           while((!min_queue.isEmpty()) && (min_queue.peekLast() > (long)arr[e])){
               min_queue.removeLast();
           }
           min_queue.addLast((long)arr[e]);

           if(!min_queue.isEmpty() && !max_queue.isEmpty()){
               long pre_ans = ((min_queue.peekFirst()%mod) + (max_queue.peekFirst()%mod))%mod;
               ans = (ans%mod + pre_ans%mod)%mod;
           }
           e++; s++;
       }
        System.out.println(ans%mod);
    }
}
