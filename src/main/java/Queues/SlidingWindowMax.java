package Queues;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class SlidingWindowMax {
    public static void main(String[] args){
//        int[] A = {1, 3, -1, -3, 5, 3, 6, 7};
//        int[] A = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        int[] A = {648, 614, 490, 138, 657, 544, 745, 582, 738, 229, 775, 665, 876, 448, 4, 81,
        807, 578, 712, 951, 867, 328, 308, 440, 542, 178, 637, 446, 882, 760, 354, 523, 935,
        277, 158, 698, 536, 165, 892, 327, 574, 516, 36, 705, 900, 482, 558, 937, 207, 368};
//        int[] A = {10,9,8,7};
        int B = 9;
        int[] ans = new int[A.length-B+1];
        Deque<Integer> dq = new LinkedList<>();
        int e=B-1 ;int s=0;
        for(int i=0; i<B; i++){
            while(!dq.isEmpty() && (dq.peekLast()<A[i]))
            {
                dq.removeLast();
            }
            dq.addLast(A[i]);
        }
        ans[s] = dq.peekFirst();
        if((dq.size()==B))
        {
            dq.removeFirst();
        }
        s++;e++;
//        951 882 882 882 882 935 935 935 935 935 935 935 935 935 892 892 892 900 900 900 937 937 937
        while(e < A.length){
            if((dq.size()==B) || ((!dq.isEmpty()) &&(dq.peekFirst()==A[s-1])))
            {
                dq.removeFirst();
            }
            while(!dq.isEmpty() && (dq.peekLast()<A[e]))
                {
                   dq.removeLast();
                }
            dq.addLast(A[e]);
            ans[s] = dq.peekFirst();
            s++;e++;
        }
        for(int i=0; i<ans.length; i++){
            System.out.print(ans[i] + "  ");
        }
    }
}
