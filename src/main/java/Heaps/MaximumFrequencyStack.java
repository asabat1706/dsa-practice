package Heaps;

import java.util.*;

public class MaximumFrequencyStack {
    public static void main(String[] args){
        int[][] A = {{1,5},{1,7},{1,5},{1,7},{1,4},{1,5},{2,0},{2,0},{2,0},{2,0},{2,0},{2,0}};
        int[] ans = new int[A.length];
        HashMap<Integer,Integer> hm = new HashMap<>();
        PriorityQueue<QueuePair> maxHeap = new PriorityQueue<QueuePair>(new QueuePairComparator());
        for(int row = 0; row<A.length; row++){
            if(A[row][0] == 1){
                int e = A[row][1];
                if(!hm.containsKey(e)){
                    hm.put(e,1);
                }
                else{
                    hm.put(e,hm.get(e)+1);
                }
                int count = hm.get(e);
                QueuePair qp = new QueuePair(e,count,row);
                maxHeap.add(qp);
                ans[row] = -1;
            }
            else{
                if(!maxHeap.isEmpty()) {
                    QueuePair qp1 = maxHeap.poll();
                    int data = qp1.data;
                    hm.put(data, hm.get(data) - 1);
                    ans[row] = data;
                }
            }
        }
        for(int i=0; i<ans.length; i++){
            System.out.print(ans[i] + "  ");
        }
    }
}
class QueuePair{
    int data;
    int count;
    int row;
    public QueuePair(int data, int count, int row){
        this.data = data;
        this.count = count;
        this.row = row;
    }
}

class QueuePairComparator implements Comparator<QueuePair> {
    @Override
    public int compare(QueuePair o1, QueuePair o2) {
        if(o1.count == o2.count){
            if(o1.row > o2.row) return -1;
            else return 1;
        }
        else if(o1.count > o2.count){
            return -1;
        }
        else return 1;
    }
}