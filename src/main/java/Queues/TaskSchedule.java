package Queues;

import java.util.LinkedList;
import java.util.Queue;

public class TaskSchedule {
    public static void main(String[] args){
        int[] A = {2, 3, 1, 5, 4};
        int[] B = {1, 3, 5, 4, 2};
        int total_clocks=0;
        Queue<Integer> q = new LinkedList();
        for(int i=0; i<A.length; i++){
            q.add(A[i]);
        }
        int index=0;
        while(!q.isEmpty()){
            int ele = q.peek();
            if(ele == B[index]){
                index++;
                q.remove();
            }
            else{
                q.remove();
                q.add(ele);
            }
            total_clocks++;
        }
        System.out.println(total_clocks);
    }
}
